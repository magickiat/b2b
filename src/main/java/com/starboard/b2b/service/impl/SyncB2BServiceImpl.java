package com.starboard.b2b.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.service.SyncB2BService;

@Service("syncB2BService")
public class SyncB2BServiceImpl implements SyncB2BService {

	private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImpl.class);

	private OrderDao orderDao;
	private OrderDetailDao orderDetailDao;
	private SoDao soDao;
	private SoDetailDao soDetailDao;
//	private TmpSoDao tmpSoDao;
	private ProductDao productDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncSellOrderFromAX() {
		log.info("Sync sell order from AX");

		// ----- find SO from AX -----
//		List<TmpSo> tmpSoList = tmpSoDao.findGroupBySoNo();
//		if (tmpSoList == null || tmpSoList.isEmpty()) {
//			log.info("Not found any record for sync");
//			return;
//		}
//		
//		
//		
//		// list for report
//		ArrayList<TmpSo> tmpSoEmptyRoCode = new ArrayList<>(tmpSoList.size());
//		ArrayList<TmpSo> tmpSoNotFoundRoCode = new ArrayList<>(tmpSoList.size());
//		ArrayList<TmpSo> tmpSoOutdated = new ArrayList<>(tmpSoList.size());
//		
//		// create so
//		for (TmpSo tmpSo : tmpSoList) {
//			So so = soDao.findBySoNo(tmpSo.getSoNo());
//			if(so == null){ // Insert SO
//				if(StringUtils.isEmpty(tmpSo.getRoCode())){
//					tmpSoEmptyRoCode.add(tmpSo);
//					log.warn(tmpSo.getRunningNo() + " Not found RO_CODE");
//					continue;
//				}
//				
//				// find order
//				Orders order = orderDao.findByOrderCode(tmpSo.getRoCode());
//				if(order == null){
//					tmpSoNotFoundRoCode.add(tmpSo);
//					log.warn("Not found any order with RO Code = " + tmpSo.getRoCode());
//					continue;
//				}
//				
//				so = new So();
//				updateSoFromTemp(so, tmpSo, order.getOrderId());
//				so.setTimeCreate(DateTimeUtil.getCurrentDate());
//				so.setUserCreate(B2BConstant.AX_SYSTEM_NAME);
//				soDao.save(so);
//			}else{
//				if (isNotOutdated(tmpSo, so)) {
//					updateSoFromTemp(so, tmpSo);
//					so.setTimeUpdate(DateTimeUtil.getCurrentDate());
//					log.info(String.format("Update SO: %s completed", tmpSo.getSoNo()));
//				} else {
//					tmpSoOutdated.add(tmpSo);
//					log.info(String.format("Temp SO: %s is outdated", tmpSo.getSoNo()));
//				}
//			}
//			
//			// ----- Step 3: Clear all SO detail of this SO -----
//			//why soDetailDao.deleteBySoId(so.getSoId());
//			
//			List<TmpSo> tmpSoTransactionList = tmpSoDao.findBySoNo(tmpSo.getSoNo());
//			if(tmpSoTransactionList != null && !tmpSoTransactionList.isEmpty()){
//				for (TmpSo tmpSo2 : tmpSoTransactionList) {
//					
//					
//					// ----- Step 4: Create Order detail and SO detail -----
////					OrdDetail ordDetail = new OrdDetail();
////					ordDetail.setOrderId(so.getOrderId());
////					ordDetail.setProductId(tmpSo2.getOrderProductId());
////					ordDetail.setAmount(tmpSo2.getAmount());
////					ordDetail.setProductBuyerGroupId(tmpSo2.getProductBuyerGroupId());
////					ordDetail.setPrice(tmpSo2.getPrice());
////					ordDetail.setProductCurrency(CurrencyUtils.parseCurrencyAXToB2B(tmpSo2.getProductCurrency()));
////					ordDetail.setProductUnitId(tmpSo2.getProductUnitId());
////					ordDetail.setTimeCreate(tmpSo2.getDtsUpdate());
////					ordDetail.setTimeUpdate(tmpSo2.getDtsUpdate());
////					orderDetailDao.save(ordDetail);
////					log.info(String.format("insert order_detail '%d' for %s complete", ordDetail.getOrderDetailId(), tmpSo2.getSoNo()));
////		
//					SoDetail soDetail = new SoDetail();
//					soDetail.setSoId(so.getSoId());
//					soDetail.setProductId(tmpSo2.getOrderProductId());
//					soDetail.setOrderProductId(tmpSo2.getOrderProductId());
//					soDetail.setPrice(tmpSo2.getPrice());
//					soDetail.setAmount(tmpSo2.getAmount());
//					soDetail.setProductBuyerGroupId(tmpSo2.getProductBuyerGroupId());
//					soDetail.setProductCurrency(CurrencyUtils.parseCurrencyAXToB2B(tmpSo2.getProductCurrency()));
//					soDetail.setProductUnitId(tmpSo2.getProductUnitId());
//					soDetail.setTimeCreate(tmpSo2.getDtsUpdate());
//					soDetail.setTimeUpdate(tmpSo2.getDtsUpdate());
//					soDetailDao.save(soDetail);
//					log.info(String.format("insert so_detail for %s complete", tmpSo2.getSoNo()));
//				}
//			}
//			// ----- Step 5: Stamp flag for tmp_so -----
//			tmpSo.setImportStatus(Long.valueOf(SyncConstant.SYNC_COMPLETE));
//			
//		}
//		
//		
//		
//		
//		
//		
		
		
		
		
		
		
		
		
		
		
		
//
//		// ==========
//		// sync step
//		// ==========
//		String tempSoNo = ""; // For check when reach new so detail
//
//		// For report notification
//		ArrayList<TmpSo> soNotFoundOrder = new ArrayList<>();
//		ArrayList<TmpSo> soOutdated = new ArrayList<>();
//		ArrayList<TmpSo> soNotFoundProduct = new ArrayList<>();
//
//		// For clear order detail without SO number
//		HashSet<Long> orderSet = new HashSet<>();
//
//		for (TmpSo tmpSo : tmpSoList) {
//			log.info("SO No: " + tmpSo.getSoNo());
//			// ----- Check order -----
//			Orders order = orderDao.findByOrderCode(tmpSo.getRoCode());
//			if (order == null) {
//				log.warn("Not found order: " + tmpSo.getRoCode());
//				soNotFoundOrder.add(tmpSo);
//				continue;
//			}
//
//			orderSet.add(order.getOrderId()); // save for delete order detail
//
//			// ----- check product -----
//			Product product = productDao.findByProductCode(tmpSo.getItemCode());
//			if (product == null) {
//				log.info("Not found product: " + tmpSo.getItemCode());
//				soNotFoundProduct.add(tmpSo);
//				continue;
//			}
//			// ------ Step 1: Clear order detail by Sell Order number -----
//			int deleteBySoNo = orderDetailDao.deleteBySoNo(tmpSo.getSoNo());
//			log.info(String.format("Delete %d record", deleteBySoNo));
//
//			// when first SO detail, create SO first
//			So soInDb = null;
//			if (!tempSoNo.equalsIgnoreCase(tmpSo.getSoNo())) {
//				tempSoNo = tmpSo.getSoNo();// reset temp so number
//
//				// ----- step 2: Create/Update SO -----
//				soInDb = soDao.findBySoNo(tmpSo.getSoNo());
//				if (soInDb == null) {// insert new SO
//					soInDb = new So();
//					updateSoFromTemp(soInDb, tmpSo, order.getOrderId());
//					soInDb.setUserCreate(B2BConstant.AX_SYSTEM_NAME);
//					soInDb.setTimeCreate(DateTimeUtil.getCurrentDate());
//					soDao.save(soInDb);
//
//					log.info(String.format("Save SO: %s for Order: %s completed", tmpSo.getSoNo(), order.getOrderCode()));
//				} else {// Update SO
//					if (isTempSOLatestUpdate(tmpSo, soInDb)) {
//						updateSoFromTemp(soInDb, tmpSo, order.getOrderId());
//						soInDb.setTimeUpdate(DateTimeUtil.getCurrentDate());
//						log.info(String.format("Update SO: %s for Order: %s completed", tmpSo.getSoNo(), order.getOrderCode()));
//					} else {
//						soOutdated.add(tmpSo);
//						log.info(String.format("Temp SO: %s for Order: %S is outdated", tmpSo.getSoNo(), order.getOrderCode()));
//					}
//				}
//				// ----- Step 3: Clear all SO detail of this SO -----
//				soDetailDao.deleteBySoId(soInDb.getSoId());
//			}
//
//			// ----- Step 4: Create Order detail and SO detail -----
//			OrdDetail ordDetail = new OrdDetail();
//			ordDetail.setOrderId(order.getOrderId());
//			ordDetail.setProductId(product.getProductId());
//			ordDetail.setAmount(tmpSo.getAmount());
//			ordDetail.setProductBuyerGroupId(tmpSo.getProductBuyerGroupId());
//			ordDetail.setPrice(tmpSo.getPrice());
//			ordDetail.setProductCurrency(CurrencyUtils.parseCurrencyAXToB2B(tmpSo.getProductCurrency()));
//			ordDetail.setProductUnitId(tmpSo.getProductUnitId());
//			ordDetail.setTimeCreate(tmpSo.getDtsUpdate());
//			ordDetail.setTimeUpdate(tmpSo.getDtsUpdate());
//			orderDetailDao.save(ordDetail);
//			log.info(String.format("insert order_detail '%d' for %s complete", ordDetail.getOrderDetailId(), tmpSo.getSoNo()));
//
//			SoDetail soDetail = new SoDetail();
//			soDetail.setSoId(soInDb.getSoId());
//			soDetail.setProductId(product.getProductId());
//			soDetail.setOrderProductId(ordDetail.getOrderDetailId());
//			soDetail.setPrice(tmpSo.getPrice());
//			soDetail.setAmount(tmpSo.getAmount());
//			soDetail.setProductBuyerGroupId(tmpSo.getProductBuyerGroupId());
//			soDetail.setProductCurrency(CurrencyUtils.parseCurrencyAXToB2B(tmpSo.getProductCurrency()));
//			soDetail.setProductUnitId(tmpSo.getProductUnitId());
//			soDetail.setTimeCreate(tmpSo.getDtsUpdate());
//			soDetail.setTimeUpdate(tmpSo.getDtsUpdate());
//			soDetailDao.save(soDetail);
//			log.info(String.format("insert so_detail for %s complete", tmpSo.getSoNo()));
//
//			// ----- Step 5: Stamp flag for tmp_so -----
//			tmpSo.setImportStatus(Long.valueOf(SyncConstant.SYNC_COMPLETE));
//		}
//
//		// ----- Step 6: delete order_detail that has
//		Iterator<Long> iterator = orderSet.iterator();
//		while (iterator.hasNext()) {
//			Long orderId = (Long) iterator.next();
//			int deleted = orderDetailDao.deleteWithoutSoNo(orderId);
//			log.info(String.format("Deleted order_detail without SO %d records.", deleted));
//		}
	}

//	
//
//	public boolean isNotOutdated(TmpSo tmpSo, So soInDb) {
//		return tmpSo.getDtsUpdate() != null && tmpSo.getDtsUpdate().before(soInDb.getTimeUpdate());
//	}
//
//	private void updateSoFromTemp(So so, TmpSo tmpSo, long orderId) {
//		so.setOrderId(orderId);
//		updateSoFromTemp(so, tmpSo);
//	}
//	
//	private void updateSoFromTemp(So so, TmpSo tmpSo) {
//		so.setShippingId(tmpSo.getShippingId());
//		so.setPaymentTermId(tmpSo.getTermCode());
//		so.setPaymentMethodId(tmpSo.getPaymentMethodId());
//		so.setExpectShipmentDate(tmpSo.getExpectShipmentDate());
//		so.setSoNo(tmpSo.getSoNo());
//	}

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
//
//	@Autowired
//	public void setTmpSoDao(TmpSoDao tmpSoDao) {
//		this.tmpSoDao = tmpSoDao;
//	}

	@Autowired
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
