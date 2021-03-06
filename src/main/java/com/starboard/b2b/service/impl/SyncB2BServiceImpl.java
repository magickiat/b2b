package com.starboard.b2b.service.impl;

import java.util.List;
import java.util.WeakHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.dao.SyncAxDao;
import com.starboard.b2b.dao.TmpAddrAXDao;
import com.starboard.b2b.dao.TmpContactAXDao;
import com.starboard.b2b.dao.TmpOrdAddressAXDao;
import com.starboard.b2b.dao.TmpOrdDetailAXDao;
import com.starboard.b2b.dao.TmpOrdersAXDao;
import com.starboard.b2b.dao.TmpProductDao;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.dao.TmpSoDetailDao;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchSyncRequest;
import com.starboard.b2b.dto.search.SearchSyncResult;
import com.starboard.b2b.dto.search.SyncAxDto;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.Contact;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.SyncAx;
import com.starboard.b2b.model.TmpAddrFromAx;
import com.starboard.b2b.model.TmpContactFromAx;
import com.starboard.b2b.model.TmpOrdAddressFromAx;
import com.starboard.b2b.model.TmpOrdDetailFromAx;
import com.starboard.b2b.model.TmpOrdersFromAx;
import com.starboard.b2b.model.TmpProduct;
import com.starboard.b2b.model.TmpSo;
import com.starboard.b2b.model.TmpSoDetail;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.model.sync.SoDetail;
import com.starboard.b2b.service.SyncB2BService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;

@Service("syncB2BService")
public class SyncB2BServiceImpl implements SyncB2BService {

	private static final Logger log = LoggerFactory.getLogger(SyncB2BServiceImpl.class);

	private AddrDao addrDao;
	private OrderDao orderDao;
	private SoDao soDao;
	private SoDetailDao soDetailDao;
	private TmpSoDao tmpSoDao;
	private TmpSoDetailDao tmpSoDetailDao;
	private TmpProductDao tmpProductDao;
	private ProductDao productDao;
	private TmpContactAXDao tmpContactAXDao;
	private ContactDao contactDao;
	private TmpOrdersAXDao tmpOrdersAXDao;
	private TmpOrdAddressAXDao tmpOrdAddressAXDao;
	private OrderAddressDao orderAddressDao;
	private TmpOrdDetailAXDao tmpOrdDetailAXDao;
	private OrderDetailDao orderDetailDao;
	private TmpAddrAXDao tmpAddrAXDao;
	private SyncAxDao syncAxDao;

	@Autowired
	private ApplicationConfig applicationConfig;

	@Override
	@Transactional
	public void syncAllFromAX() throws Exception {

		SyncAx sync = new SyncAx();
		sync.setSyncDate(DateTimeUtil.getCurrentDate());
		sync.setStatus("Processing");
		syncAxDao.save(sync);

		try {
			syncContactFromAX();
			syncAddressFromAX();
			syncProductFromAX();
			syncOrdersFromAX();
			syncOrderDetailFromAX();
			syncOrderAddressFromAX();
			syncSellOrderFromAX();
			syncSellOrderDetailFromAX();
			// syncInvoiceFromAX();

			sync.setStatus("Complete");
		} catch (Exception e) {
			log.error("============= " + e.getMessage(), e);
			sync.setStatus("Failed");
			sync.setRemark(e.getMessage());
			syncAxDao.save(sync);
			throw e;
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public void syncContactFromAX() {
		log.info("Sync Contact from AX");
		// Step 1: Get distinct custId from AX
		List<Long> custIdsAx = tmpContactAXDao.findCustIds();
		// Step 2: Remove all Contact which match custIdAx;
		if (custIdsAx != null && !custIdsAx.isEmpty()) {
			contactDao.removeByCustIds(custIdsAx);
		}
		// Step 3: Get data from AX & insert into Sync table
		List<TmpContactFromAx> tmpContactFromAXs = tmpContactAXDao.list();
		if (tmpContactFromAXs != null && !tmpContactFromAXs.isEmpty()) {
			for (TmpContactFromAx tmpContactFromAx : tmpContactFromAXs) {
				Contact syncContact = new Contact();
				BeanUtils.copyProperties(tmpContactFromAx, syncContact, "contactId");
				contactDao.save(syncContact);
			}
			// Step 4: Remove from AX
			tmpContactAXDao.removeAll();
		}
	}

	// For Address
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncAddressFromAX() {
		log.info("Sync Address from AX");
		// Step 1: Get distinct custId from AX
		List<Long> custIdsAx = tmpAddrAXDao.findCustIds();
		// Step 2: Remove all Addr which match custIdAx;
		if (custIdsAx != null && !custIdsAx.isEmpty()) {
			addrDao.deleteByCustIds(custIdsAx);
		}
		// Step 3: Get data from AX & insert into Sync table
		List<TmpAddrFromAx> addrFromAxes = tmpAddrAXDao.list();
		if (addrFromAxes != null && !addrFromAxes.isEmpty()) {
			for (TmpAddrFromAx addrFromAx : addrFromAxes) {
				Addr addr = new Addr();
				BeanUtils.copyProperties(addrFromAx, addr);
				addrDao.save(addr);
			}
			// Step 4: Remove from AX table
			tmpAddrAXDao.removeAll();
		}
	}

	// For Product
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncProductFromAX() {
		log.info("Sync Product from AX");
		// Step 1: Get data from AX
		List<TmpProduct> tmpProducts = tmpProductDao.list();
		// Step 2: Insert / Update into sync table
		if (tmpProducts != null && !tmpProducts.isEmpty()) {
			for (TmpProduct tmpProduct : tmpProducts) {
				// Step 2.1: Check if Product Code is in Product
				final Product product = productDao.findByProductCode(tmpProduct.getProductCode());
				// If Exist: then update value
				if (product != null) {
					BeanUtils.copyProperties(tmpProduct, product, "productId");
					productDao.save(product);
				} else {
					// If Not Exist: then insert
					Product newProduct = new Product();
					BeanUtils.copyProperties(tmpProduct, newProduct, "productId");
					productDao.save(newProduct);
				}
			}
			// Step 3: Remove from AX table
			tmpProductDao.removeAll();
		}
	}

	// For Order
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncOrdersFromAX() {
		log.info("Sync Order from AX");
		// Step 1: Get data from AX
		final List<TmpOrdersFromAx> ordersFromAxes = tmpOrdersAXDao.list();
		// Step 2: Insert / Update into sync table
		if (ordersFromAxes != null && !ordersFromAxes.isEmpty()) {
			for (TmpOrdersFromAx tmpOrdersFromAx : ordersFromAxes) {
				// Step 2.1: Check if order code is in Orders
				final Orders orders = orderDao.findByOrderCode(tmpOrdersFromAx.getOrderCode());
				// If Exist: then update value
				if (orders != null) {
					BeanUtils.copyProperties(tmpOrdersFromAx, orders, "orderId");
					orderDao.save(orders);
				} else {
					// If Not Exist: then insert
					Orders newOrders = new Orders();
					BeanUtils.copyProperties(tmpOrdersFromAx, newOrders, "orderId");
					orderDao.save(newOrders);
				}
				// Step 4: Remove order detail by order code
				orderDetailDao.deleteByOrderCode(tmpOrdersFromAx.getOrderCode());
			}
			// Step 5: Remove from AX table
			tmpOrdersAXDao.removeAll();
		}
	}

	// For Order Detail
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncOrderDetailFromAX() {
		log.info("Sync Order Detail from AX");
		WeakHashMap<String, Long> cacheOrder = new WeakHashMap<>();
		// Step 1: Get distinct custId from AX
		List<String> orderCodeAxes = tmpOrdDetailAXDao.findOrderCodes();
		// Step 2: Remove all order_address which match orderCodeAxes;
		if (orderCodeAxes != null && !orderCodeAxes.isEmpty()) {
			final List<Long> ids = orderDetailDao.findIdsByOrderCodes(orderCodeAxes);
			if (ids != null && !ids.isEmpty()) {
				orderDetailDao.deleteByIds(ids);
			}
		}
		// Step 3: Get data from AX & insert into Sync table
		final List<TmpOrdDetailFromAx> ordDetailFromAxes = tmpOrdDetailAXDao.list();
		if (ordDetailFromAxes != null && !ordDetailFromAxes.isEmpty()) {
			for (TmpOrdDetailFromAx tmpOrdDetailFromAx : ordDetailFromAxes) {
				// Step 3.1: Find orders by order code before insert
				Long orderId = getOrderId(cacheOrder, tmpOrdDetailFromAx.getOrderCode());
				if (orderId == null)
					continue;
				OrdDetail ordDetail = new OrdDetail();
				BeanUtils.copyProperties(tmpOrdDetailFromAx, ordDetail, "orderDetailId", "orderCode");
				ordDetail.setOrderId(orderId);
				orderDetailDao.save(ordDetail);
			}
			// Step 4: Remove from AX table
			tmpOrdDetailAXDao.removeAll();
		}
	}

	// For Order Address
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncOrderAddressFromAX() {
		log.info("Sync Order Address from AX");
		WeakHashMap<String, Long> cacheOrder = new WeakHashMap<>();
		// Step 1: Get distinct order codes from AX
		List<String> orderCodeAxes = tmpOrdAddressAXDao.findOrderCodes();
		// Step 2: Remove all order_address which match orderCodeAxes;
		if (orderCodeAxes != null && !orderCodeAxes.isEmpty()) {
			final List<Long> ids = orderAddressDao.findIdsByOrderCodes(orderCodeAxes);
			if (ids != null && !ids.isEmpty()) {
				orderAddressDao.deleteByIds(ids);
			}
		}
		// Step 3: Get data from AX & insert into sync table
		final List<TmpOrdAddressFromAx> ordAddressFromAxes = tmpOrdAddressAXDao.list();
		if (ordAddressFromAxes != null && !ordAddressFromAxes.isEmpty()) {
			for (TmpOrdAddressFromAx ordAddressFromAx : ordAddressFromAxes) {
				Long orderId = getOrderId(cacheOrder, ordAddressFromAx.getOrderCode());
				if (orderId == null)
					continue;
				OrdAddress orderAddress = new OrdAddress();
				BeanUtils.copyProperties(ordAddressFromAx, orderAddress, "orderAddressId", "orderCode");
				orderAddress.setOrderId(orderId);
				orderAddressDao.save(orderAddress);
			}
			// Step 4: Remove from AX table
			tmpOrdAddressAXDao.removeAll();
		}
	}

	// For Sale Order
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncSellOrderFromAX() {
		log.info("Sync Sell Order from AX");
		WeakHashMap<String, Long> cacheOrder = new WeakHashMap<>();
		// Step 1: Get data from AX
		final List<TmpSo> tmpSos = tmpSoDao.list();
		// Step 2: Insert / Update into sync table
		if (tmpSos != null && !tmpSos.isEmpty()) {
			for (TmpSo tmpSo : tmpSos) {
				// Step 2.1: Check if order code is in Orders
				final So so = soDao.findBySoNo(tmpSo.getSoNo());
				// Find order id by order code
				Long orderId = getOrderId(cacheOrder, tmpSo.getOrderCode());
				if (orderId == null)
					continue;
				// If Exist: then update value
				if (so != null) {
					BeanUtils.copyProperties(tmpSo, so, "soId");
					so.setOrderId(orderId);
					soDao.save(so);
				} else {
					// If Not Exist: then insert
					So newSo = new So();
					BeanUtils.copyProperties(tmpSo, newSo, "soId");
					newSo.setOrderId(orderId);
					soDao.save(newSo);
				}
			}
			// Step 4: Remove from AX table
			tmpSoDao.removeAll();
		}
	}

	// For Sale Order Detail
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void syncSellOrderDetailFromAX() {
		log.info("Sync Sell Order Detail from AX");
		WeakHashMap<String, Long> cacheSo = new WeakHashMap<>();
		WeakHashMap<String, Long> cacheProduct = new WeakHashMap<>();
		// Step 1: Get distinct order codes from AX
		List<String> soNos = tmpSoDetailDao.findSoNos();
		// Step 2: Remove all so_detail which match soNos;
		if (soNos != null && !soNos.isEmpty()) {
			final List<Long> ids = soDetailDao.findIdsSoNos(soNos);
			if (ids != null && !ids.isEmpty()) {
				soDetailDao.deleteByIds(ids);
			}
		}
		// Step 3: Get data from AX & insert into sync table
		final List<TmpSoDetail> tmpSoDetails = tmpSoDetailDao.list();
		if (tmpSoDetails != null && !tmpSoDetails.isEmpty()) {
			for (TmpSoDetail tmpSoDetail : tmpSoDetails) {
				// Step 3.1: Find sell order by sell order no before insert
				Long soId = cacheSo.get(tmpSoDetail.getSoNo());
				if (soId == null) {
					final So so = soDao.findBySoNo(tmpSoDetail.getSoNo());
					if (so == null) {
						continue;
					}
					soId = so.getSoId();
					cacheSo.put(so.getSoNo(), soId);
				}
				// Step 3.2: Find order product id before insert
				Long productId = cacheProduct.get(tmpSoDetail.getProductCode());
				if (productId == null) {
					final Product product = productDao.findByProductCode(tmpSoDetail.getProductCode());
					if (product != null) {
						productId = product.getProductId();
						cacheProduct.put(product.getProductCode(), productId);
					}
				}

				SoDetail soDetail = new SoDetail();
				BeanUtils.copyProperties(tmpSoDetail, soDetail, "soProductId");
				soDetail.setSoId(soId);
				soDetail.setOrderProductId(productId);
				soDetailDao.save(soDetail);
			}
			// Step 4: Remove from AX table
			tmpSoDetailDao.removeAll();
		}
	}

	// @Override
	// @Transactional(rollbackFor = Exception.class)
	// public void syncInvoiceFromAX() {
	// log.info("sync invoice from AX");
	// }

	@Autowired
	public void setAddrDao(AddrDao addrDao) {
		this.addrDao = addrDao;
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

	@Autowired
	public void setTmpSoDetailDao(TmpSoDetailDao tmpSoDetailDao) {
		this.tmpSoDetailDao = tmpSoDetailDao;
	}

	@Autowired
	public void setTmpProductDao(TmpProductDao tmpProductDao) {
		this.tmpProductDao = tmpProductDao;
	}

	@Autowired
	public void setTmpContactAXDao(TmpContactAXDao tmpContactAXDao) {
		this.tmpContactAXDao = tmpContactAXDao;
	}

	@Autowired
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@Autowired
	public void setTmpOrdersAXDao(TmpOrdersAXDao tmpOrdersAXDao) {
		this.tmpOrdersAXDao = tmpOrdersAXDao;
	}

	@Autowired
	public void setTmpOrdAddressAXDao(TmpOrdAddressAXDao tmpOrdAddressAXDao) {
		this.tmpOrdAddressAXDao = tmpOrdAddressAXDao;
	}

	@Autowired
	public void setOrderAddressDao(OrderAddressDao orderAddressDao) {
		this.orderAddressDao = orderAddressDao;
	}

	@Autowired
	public void setTmpOrdDetailAXDao(TmpOrdDetailAXDao tmpOrdDetailAXDao) {
		this.tmpOrdDetailAXDao = tmpOrdDetailAXDao;
	}

	@Autowired
	public void setTmpAddrAXDao(TmpAddrAXDao tmpAddrAXDao) {
		this.tmpAddrAXDao = tmpAddrAXDao;
	}

	private Long getOrderId(WeakHashMap<String, Long> cacheOrder, String orderCode) {
		Long orderId = cacheOrder.get(orderCode);
		if (orderId == null) {
			final Orders orders = orderDao.findByOrderCode(orderCode);
			if (orders == null) {
				return null;
			}
			orderId = orders.getOrderId();
			cacheOrder.put(orders.getOrderCode(), orderId);
		}
		return orderId;
	}

	@Autowired
	public void setSyncAxDao(SyncAxDao syncAxDao) {
		this.syncAxDao = syncAxDao;
	}

	@Override
	@Transactional
	public Page<SyncAxDto> search(SearchSyncRequest data) {
		SearchRequest<SearchSyncRequest> req = new SearchRequest<>(data.getPage(), applicationConfig.getPageSize());
		req.setCondition(data);

		SearchSyncResult result = syncAxDao.search(req);

		// create result page object
		final Page<SyncAxDto> page = new Page<>();
		page.setCurrent(data.getPage());
		log.info("current page: {}", page.getCurrent());
		page.setPageSize(req.getPageSize());
		page.setTotal(result.getTotal());
		page.setResult(result.getResult());
		return page;

	}
}
