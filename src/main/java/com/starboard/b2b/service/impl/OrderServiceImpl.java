package com.starboard.b2b.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.OrderStatusDao;
import com.starboard.b2b.dao.OrdersIdRunningDao;
import com.starboard.b2b.dao.PaymentMethodDao;
import com.starboard.b2b.dao.PaymentTermDao;
import com.starboard.b2b.dao.ShippingTypeDao;
import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.PaymentTermDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ShippingTypeDTO;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.dto.SoDetailDTO;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.OrderStatus;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.So;
import com.starboard.b2b.model.SoDetail;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.order.OrderSummaryForm;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Value("${upload.path}")
	private String uploadPath;

	@Autowired
	private ApplicationConfig applicationConfig;

	@Autowired
	private ShippingTypeDao shippingTypeDao;

	@Autowired
	private PaymentMethodDao paymentMethodDao;
	
	@Autowired
	private PaymentTermDao paymentTermDao;

	@Autowired
	private OrdersIdRunningDao ordersIdRunningDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderAddressDao orderAddressDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private AddrDao addrDao;

	@Autowired
	private OrderStatusDao orderStatusDao;

	@Override
	@Transactional(readOnly = true)
	public List<ShippingTypeDTO> findAllShippingType() {
		return shippingTypeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<PaymentMethodDTO> findAllPaymentMethod() {
		return paymentMethodDao.list();
	}

	// ----- Generate Order Code [RO-Year-Running] -----
	@Override
	@Transactional
	public String generateOrderCode() {
		int year = DateTimeUtil.getCurrentYear();
		long orderRunningNo = getNextRunningNo(year);
		String runingNo = "" + orderRunningNo;
		int size = runingNo.length() <= 4 ? 4 : runingNo.length();
		String strRunningNo = StringUtils.leftPad(runingNo, size, "0");
		return String.format("RO-%d-%s", year, strRunningNo);
	}

	@Override
	@Transactional
	public OrderDTO newOrder(Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod,
			Map<Long, ProductDTO> cart) {
		Addr invoiceToAddr = addrDao.findById(invoiceTo);
		if (invoiceToAddr == null) {
			throw new IllegalArgumentException("Address 'Invoice To' is required");
		}

		Addr dispatchToAddr = addrDao.findById(dispatchTo);
		if (dispatchToAddr == null) {
			throw new IllegalArgumentException("Address 'Dispatch To' is required");
		}
		
		Entry<Long, ProductDTO> firstProduct = cart.entrySet().iterator().next();
		long brandGroupId = firstProduct.getValue().getProductTypeId();
		
		// Save Order
		String orderCode = generateOrderCode();
		log.info("\tGenerated orderCode = " + orderCode);

		Date currentDate = DateTimeUtil.getCurrentDate();
		User user = UserUtil.getCurrentUser();

		Orders order = new Orders();
		order.setCustId(user.getCustomer().getCustId());
		order.setCustCode(user.getCustomer().getCustCode());
		order.setCustUserId("" + user.getId());
		order.setOrderCode(orderCode);
		order.setOrderStatus(applicationConfig.getOrderStatusNew());
		order.setOrderDate(currentDate);
		order.setBrandGroupId(brandGroupId);
		order.setShippingId(shippingType);
		order.setPaymentMethodId(paymentMethod);
		order.setPaymentCurrencyId(user.getCustomer().getCurrency());
		order.setPaymentTermId(applicationConfig.getNewOrderPaymentTermId());
		order.setRemarkCustomer(customerRemark);
		order.setTimeCreate(currentDate);
		order.setUserCreate(user.getUsername());

		long orderId = orderDao.save(order);

		// Save Order Detail
		Set<Long> keySet = cart.keySet();
		for (Long key : keySet) {
			ProductDTO product = cart.get(key);
			// Default currency
			if (StringUtils.isEmpty(product.getProductCurrency())) {
				product.setProductCurrency(applicationConfig.getDefaultProductCurrency());
			}
			// Default product unit id
			if (StringUtils.isEmpty(product.getProductUnitId())) {
				product.setProductUnitId(applicationConfig.getDefaultProductUnit());
			}

			// ----- Create order -----
			OrdDetail orderDetail = new OrdDetail();
			orderDetail.setOrderId(orderId);
			orderDetail.setProductId(product.getProductId());
			orderDetail.setAmount(product.getProductQuantity());
			if (product.getProductPrice() != null && product.getProductPrice().intValue() >= 0) {
				orderDetail.setPrice(product.getProductPrice());
			}
			orderDetail.setProductCurrency(product.getProductCurrency());
			orderDetail.setProductUnitId(product.getProductUnitId());
			orderDetail.setProductBuyerGroupId(product.getProductBuyerGroupId());
			orderDetail.setUserCreate(user.getUsername());
			orderDetail.setTimeCreate(DateTimeUtil.getCurrentDate());

			orderDetailDao.save(orderDetail);
		}

		// Save Order address
		orderAddressDao.save(createOrderAddress(invoiceToAddr, orderId, AddressConstant.ORDER_INVOICE_TO));
		orderAddressDao.save(createOrderAddress(dispatchToAddr, orderId, AddressConstant.ORDER_DISPATCH_TO));

		// For generate report
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(orderId);
		dto.setOrderCode(orderCode);
		return dto;
	}

	public OrdAddress createOrderAddress(Addr addr, Long orderId, Long addressType) {
		OrdAddress address = new OrdAddress();
		address.setOrderId(orderId);
		address.setOrderAddr(addr.getAddress());
		address.setOrderTel(addr.getTel1());
		address.setFax(addr.getFax());
		address.setEmail(addr.getEmail());
		address.setType(addressType);
		address.setOrderFname("");
		address.setOrderLname("");
		return address;
	}

	@Override
	@Transactional
	public long getNextRunningNo(int year) {
		return ordersIdRunningDao.generateRunning(year);
	}

	@Override
	@Transactional(readOnly = true)
	public OrderDTO findOrder(Long orderId) {
		if(orderId != null){
			Orders order = orderDao.findById(orderId);
			OrderDTO dto = new OrderDTO();
			try {
				BeanUtils.copyProperties(dto, order);
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error(e.toString(), e);
			}
			return dto;
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchOrderDetailDTO> searchOrderDetail(Long orderId) {
		return orderDetailDao.searchOrderDetail(orderId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchOrderDetailDTO> searchOrderDetail(String orderCode) {
		return orderDetailDao.searchOrderDetail(orderCode);
	}

	@Override
	@Transactional(readOnly = true)
	public SearchOrderDTO findOrderForReport(Long orderId) {
		return orderDao.findOrderForReport(orderId);
	}

	@Override
	@Transactional(readOnly = true)
	public SearchOrderDTO findOrderForReport(String orderCode) {
		return orderDao.findOrderForReport(orderCode);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrdAddressDTO> findOrderAddress(Long orderId) {

		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrdAddressDTO> findOrderAddress(final String orderCode) {
		List<OrdAddress> ordAddresses = orderDao.findOrderAddress(orderCode);
		List<OrdAddressDTO> ordAddressDTOs = new ArrayList<>();
		if(ordAddresses != null && !ordAddresses.isEmpty()){
			for(OrdAddress ordAddress : ordAddresses){
				try {
					OrdAddressDTO ordAddressDTO = new OrdAddressDTO();
					BeanUtils.copyProperties(ordAddressDTO, ordAddress);
					ordAddressDTOs.add(ordAddressDTO);
				} catch (IllegalAccessException | InvocationTargetException e) {
					log.error("Got problem while copying bean properties.. with error {}", e.getMessage(), e);
				}
			}
		}
		return ordAddressDTOs;
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderStatusDTO> findAllOrderStatus() {
		final List<OrderStatusDTO> orderStatuses = new ArrayList<>();
		for (OrderStatus status : orderStatusDao.findAll()) {
			final OrderStatusDTO orderStatus = new OrderStatusDTO();
			try {
				BeanUtils.copyProperties(orderStatus, status);
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error("Got problem while copying bean properties.. with error {}", e.getMessage(), e);
			}
			orderStatuses.add(orderStatus);
		}
		return orderStatuses;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<SearchOrderDTO> searchOrder(final OrderSummaryForm orderSummaryForm) {
		log.info("Search order summary form: {}",orderSummaryForm);
		final SearchRequest<OrderSummaryForm> req = new SearchRequest<>(orderSummaryForm.getPage(), applicationConfig.getPageSize());
		req.setCondition(orderSummaryForm);

		// Find product model
		final SearchResult<SearchOrderDTO> result = orderDao.search(req);

		// Validate has image exist
		final List<SearchOrderDTO> resultList = result.getResult();
		log.info("resultList size: {}", (resultList == null ? 0 : resultList.size()));

		// create result page object
		final Page<SearchOrderDTO> page = new Page<>();
		page.setCurrent(orderSummaryForm.getPage());
		log.info("current page: {}" , page.getCurrent());
		page.setPageSize(req.getPageSize());
		page.setTotal(result.getTotal());
		page.setResult(result.getResult());
		return page;
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> findAllOrderCurrency(Long orderId) {
		return orderDetailDao.findAllOrderCurrency(orderId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchOrderDTO> findOrderForReport(Long[] ordersId) {
		return orderDao.findOrderForReport(ordersId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchOrderDetailDTO> searchOrderDetail(Long[] ordersId) {
		return orderDetailDao.searchOrderDetail(ordersId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchOrderDTO> searchOrderForReport(OrderSummaryForm orderSummaryForm) {
		return orderDao.searchOrderSummaryForReport(orderSummaryForm);
	}

	@Override
	@Transactional(readOnly = true)
	public SoDTO findSO(long soId) {
		So so = orderDao.findSoById(soId);
		SoDTO dto = new SoDTO();
		try {
			BeanUtils.copyProperties(dto, so);
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error(e.toString(), e);
		}
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SoDetailDTO> findSoDetail(long soId) {
		List<SoDetail> so = orderDao.findSoDetailBySoId(soId);
		List<SoDetailDTO> soDTOs = new ArrayList<>();
		if(so != null && !so.isEmpty()){
			try {
				SoDetailDTO dto = new SoDetailDTO();
				BeanUtils.copyProperties(dto, so);
				soDTOs.add(dto);
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error(e.toString(), e);
			}
		}
		return soDTOs;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PaymentTermDTO> findAllPaymentTerm() {
		return paymentTermDao.list();
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDTO findUserByOrderCode(String orderCode){
		User user = orderDao.findUserByOrderCode(orderCode);
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
//		try {
//			BeanUtils.copyProperties(userDTO, user);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			log.error("Got problem while copying bean properties.. with error {}", e.getMessage(), e);
//		}
		return userDTO;
	}
}
