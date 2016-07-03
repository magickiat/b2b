package com.starboard.b2b.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.SyncConstant;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.model.sync.SoDetail;
import com.starboard.b2b.model.sync.TmpSo;
import com.starboard.b2b.service.SyncB2BService;
import com.starboard.b2b.util.CurrencyUtils;
import com.starboard.b2b.util.DateTimeUtil;

@Service("syncB2BService")
public class SyncB2BServiceImpl implements SyncB2BService {

	private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImpl.class);

	private OrderDao orderDao;
	private OrderDetailDao orderDetailDao;
	private SoDao soDao;
	private SoDetailDao soDetailDao;
	private TmpSoDao tmpSoDao;
	private ProductDao productDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncSellOrderFromAX() {
		log.info("Sync sell order from AX");

		// ----- find SO from AX -----
		List<TmpSo> tmpSoList = tmpSoDao.findSoForImport();
		if (tmpSoList == null || tmpSoList.isEmpty()) {
			log.info("Not found any record for sync");
			return;
		}

		// ==========
		// sync step
		// ==========
		String tempSoNo = ""; // For check when reach new so detail

		// For report notification
		ArrayList<TmpSo> soNotFoundOrder = new ArrayList<>();
		ArrayList<TmpSo> soOutdated = new ArrayList<>();
		ArrayList<TmpSo> soNotFoundProduct = new ArrayList<>();

		// For clear order detail without SO number
		HashSet<Long> orderSet = new HashSet<>();

		for (TmpSo tmpSo : tmpSoList) {
			log.info("SO No: " + tmpSo.getSoNo());
			// ----- Check order -----
			Orders order = orderDao.findByOrderCode(tmpSo.getRoCode());
			if (order == null) {
				log.warn("Not found order: " + tmpSo.getRoCode());
				soNotFoundOrder.add(tmpSo);
				continue;
			}

			orderSet.add(order.getOrderId()); // save for delete order detail

			// ----- check product -----
			Product product = productDao.findByProductCode(tmpSo.getItemCode());
			if (product == null) {
				log.info("Not found product: " + tmpSo.getItemCode());
				soNotFoundProduct.add(tmpSo);
				continue;
			}
			// ------ Step 1: Clear order detail by Sell Order number -----
			int deleteBySoNo = orderDetailDao.deleteBySoNo(tmpSo.getSoNo());
			log.info(String.format("Delete %d record", deleteBySoNo));

			// when first SO detail, create SO first
			So soInDb = null;
			if (!tempSoNo.equalsIgnoreCase(tmpSo.getSoNo())) {
				tempSoNo = tmpSo.getSoNo();// reset temp so number

				// ----- step 2: Create/Update SO -----
				soInDb = soDao.findBySoNo(tmpSo.getSoNo());
				if (soInDb == null) {// insert new SO
					soInDb = new So();
					updateSoFromTemp(soInDb, tmpSo, order.getOrderId());
					soInDb.setUserCreate(B2BConstant.AX_SYSTEM_NAME);
					soInDb.setTimeCreate(DateTimeUtil.getCurrentDate());
					soDao.save(soInDb);

					log.info(String.format("Save SO: %s for Order: %s completed", tmpSo.getSoNo(), order.getOrderCode()));
				} else {// Update SO
					if (isTempSOLatestUpdate(tmpSo, soInDb)) {
						updateSoFromTemp(soInDb, tmpSo, order.getOrderId());
						soInDb.setTimeUpdate(DateTimeUtil.getCurrentDate());
						log.info(String.format("Update SO: %s for Order: %s completed", tmpSo.getSoNo(), order.getOrderCode()));
					} else {
						soOutdated.add(tmpSo);
						log.info(String.format("Temp SO: %s for Order: %S is outdated", tmpSo.getSoNo(), order.getOrderCode()));
					}
				}
				// ----- Step 3: Clear all SO detail of this SO -----
				soDetailDao.deleteBySoId(soInDb.getSoId());
			}

			// ----- Step 4: Create Order detail and SO detail -----
			OrdDetail ordDetail = new OrdDetail();
			ordDetail.setOrderId(order.getOrderId());
			ordDetail.setProductId(product.getProductId());
			ordDetail.setAmount(tmpSo.getAmount());
			ordDetail.setProductBuyerGroupId(tmpSo.getProductBuyerGroupId());
			ordDetail.setPrice(tmpSo.getPrice());
			ordDetail.setProductCurrency(CurrencyUtils.parseCurrencyAXToB2B(tmpSo.getProductCurrency()));
			ordDetail.setProductUnitId(tmpSo.getProductUnitId());
			ordDetail.setTimeCreate(tmpSo.getDtsUpdate());
			ordDetail.setTimeUpdate(tmpSo.getDtsUpdate());
			orderDetailDao.save(ordDetail);
			log.info(String.format("insert order_detail '%d' for %s complete", ordDetail.getOrderDetailId(), tmpSo.getSoNo()));

			SoDetail soDetail = new SoDetail();
			soDetail.setSoId(soInDb.getSoId());
			soDetail.setProductId(product.getProductId());
			soDetail.setOrderProductId(ordDetail.getOrderDetailId());
			soDetail.setPrice(tmpSo.getPrice());
			soDetail.setAmount(tmpSo.getAmount());
			soDetail.setProductBuyerGroupId(tmpSo.getProductBuyerGroupId());
			soDetail.setProductCurrency(CurrencyUtils.parseCurrencyAXToB2B(tmpSo.getProductCurrency()));
			soDetail.setProductUnitId(tmpSo.getProductUnitId());
			soDetail.setTimeCreate(tmpSo.getDtsUpdate());
			soDetail.setTimeUpdate(tmpSo.getDtsUpdate());
			soDetailDao.save(soDetail);
			log.info(String.format("insert so_detail for %s complete", tmpSo.getSoNo()));

			// ----- Step 5: Stamp flag for tmp_so -----
			tmpSo.setImportStatus(Long.valueOf(SyncConstant.STATTUS_ONE));
		}

		// ----- Step 6: delete order_detail that has
		Iterator<Long> iterator = orderSet.iterator();
		while (iterator.hasNext()) {
			Long orderId = (Long) iterator.next();
			int deleted = orderDetailDao.deleteWithoutSoNo(orderId);
			log.info(String.format("Deleted order_detail without SO %d records.", deleted));
		}
	}

	public boolean isTempSOLatestUpdate(TmpSo tmpSo, So soInDb) {
		return tmpSo.getDtsUpdate() != null && tmpSo.getDtsUpdate().before(soInDb.getTimeUpdate());
	}

	private void updateSoFromTemp(So so, TmpSo tmpSo, long orderId) {
		so.setOrderId(orderId);
		so.setShippingId(tmpSo.getShippingId());
		so.setPaymentTermId(tmpSo.getTermCode());
		so.setPaymentMethodId(tmpSo.getPaymentMethodId());
		so.setExpectShipmentDate(tmpSo.getExpectShipmentDate());
		so.setSoNo(tmpSo.getSoNo());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncInvoiceFromAX() {
		log.info("sync invoice from AX");
	}

	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Autowired
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	@Autowired
	public void setSoDao(SoDao soDao) {
		this.soDao = soDao;
	}

	@Autowired
	public void setSoDetailDao(SoDetailDao soDetailDao) {
		this.soDetailDao = soDetailDao;
	}

	@Autowired
	public void setTmpSoDao(TmpSoDao tmpSoDao) {
		this.tmpSoDao = tmpSoDao;
	}

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
