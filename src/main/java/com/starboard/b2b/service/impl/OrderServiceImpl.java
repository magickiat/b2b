package com.starboard.b2b.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.OrderStatusConfig;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.InvoiceDao;
import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.OrderStatusDao;
import com.starboard.b2b.dao.OrdersIdRunningDao;
import com.starboard.b2b.dao.PaymentMethodDao;
import com.starboard.b2b.dao.PaymentTermDao;
import com.starboard.b2b.dao.ProductPriceDao;
import com.starboard.b2b.dao.ShippingTypeDao;
import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.dto.CustPriceGroupDTO;
import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.PaymentTermDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductPriceDTO;
import com.starboard.b2b.dto.ShippingTypeDTO;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.dto.SoDetailDTO;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.OrderStatus;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.User;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.model.sync.SoDetail;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.OrderHelper;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.order.OrderDecisionForm;
import com.starboard.b2b.web.form.order.OrderSummaryForm;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

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

	@Autowired
	private SoDao soDao;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductPriceDao productPriceDao;

	@Autowired
	private UserService userService;

	@Autowired
	private InvoiceDao invoiceDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<SoDTO> listSO(long orderId) {
		return soDao.findByOrderId(orderId);
	}

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
	@Transactional(rollbackFor = Exception.class)
	public String generateOrderCode() {
		int year = DateTimeUtil.getCurrentYear();
		long orderRunningNo = getNextRunningNo(year);
		String runingNo = "" + orderRunningNo;
		int size = runingNo.length() <= 4 ? 4 : runingNo.length();
		String strRunningNo = StringUtils.leftPad(runingNo, size, "0");
		return String.format("RO-%d-%s", year, strRunningNo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	@Deprecated
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

		//TODO prepare separate product by currency and new order by currency
		
		
		
		
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
		order.setTimeUpdate(currentDate);

		long orderId = orderDao.save(order);

		CustPriceGroupDTO custPriceGroup = customerService.findCustPriceGroup(user.getCustomer().getCustCode(), brandGroupId);

		// Save Order Detail
		if(cart != null && !cart.isEmpty()){
			Set<Long> keySet = cart.keySet();
			for (Long key : keySet) {
				ProductDTO product = cart.get(key);

				ProductPriceDTO productPrice = productPriceDao.findProductPrice(product.getProductCode(), brandGroupId, user);
				// Default currency
				if (productPrice != null) {
					if (StringUtils.isEmpty(product.getProductCurrency())) {
						String currency = productPrice.getProductCurrency();
						if (StringUtils.isEmpty(currency)) {
							currency = applicationConfig.getDefaultProductCurrency();
						}
						product.setProductCurrency(currency);
					}
				}
				// Default product unit id
				if (StringUtils.isEmpty(product.getProductUnitId())) {
					product.setProductUnitId(applicationConfig.getDefaultProductUnit());
				}

				// ----- Create order detail-----

				OrdDetail orderDetail = new OrdDetail();
				orderDetail.setOrderId(orderId);
				orderDetail.setProductId(product.getProductId());
				orderDetail.setAmount(product.getProductQuantity());
				if (productPrice != null && product.getProductQuantity() > 0) {
					orderDetail.setPrice(productPrice.getAmount());
				}
				orderDetail.setStatus(applicationConfig.getDefaultOrderDetailStatus());
				orderDetail.setProductCurrency(product.getProductCurrency());
				orderDetail.setProductUnitId(product.getProductUnitId());
				orderDetail.setProductBuyerGroupId(custPriceGroup.getProductBuyerGroupId());
				orderDetail.setUserCreate(user.getUsername());
				orderDetail.setTimeCreate(currentDate);

				orderDetailDao.save(orderDetail);
			}
		}else{
			throw new B2BException("Can't create order without product");
		}

		// Save Order address
		orderAddressDao.save(createOrderAddress(invoiceToAddr, orderId, AddressConstant.ORDER_INVOICE_TO));
		orderAddressDao.save(createOrderAddress(dispatchToAddr, orderId, AddressConstant.ORDER_DISPATCH_TO));

		// For generate report
		OrderDTO dto = new OrderDTO();
		BeanUtils.copyProperties(order, dto);
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
	@Transactional(rollbackFor = Exception.class)
	public long getNextRunningNo(int year) {
		return ordersIdRunningDao.generateRunning(year);
	}

	@Override
	@Transactional(readOnly = true)
	public OrderDTO findOrder(Long orderId) {
		if (orderId != null) {
			Orders order = orderDao.findById(orderId);
			OrderDTO dto = new OrderDTO();
			BeanUtils.copyProperties(order, dto);
			return dto;
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchOrderDetailDTO> searchOrderDetail(Long orderId) {
		List<SearchOrderDetailDTO> result = orderDetailDao.searchOrderDetail(orderId);
		findShippedOrderDetail(result);
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SearchOrderDetailDTO> searchOrderDetail(String orderCode) {
		List<SearchOrderDetailDTO> result = orderDetailDao.searchOrderDetail(orderCode);
		findShippedOrderDetail(result);
		return result;
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
	public List<OrdAddressDTO> findOrderAddress(final String orderCode) {
		List<OrdAddress> ordAddresses = orderDao.findOrderAddress(orderCode);
		List<OrdAddressDTO> ordAddressDTOs = new ArrayList<>();
		if (ordAddresses != null && !ordAddresses.isEmpty()) {
			for (OrdAddress ordAddress : ordAddresses) {
				OrdAddressDTO ordAddressDTO = new OrdAddressDTO();
				BeanUtils.copyProperties(ordAddress, ordAddressDTO);
				ordAddressDTOs.add(ordAddressDTO);
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
			BeanUtils.copyProperties(status, orderStatus);
			orderStatuses.add(orderStatus);
		}
		return orderStatuses;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<SearchOrderDTO> searchOrder(final OrderSummaryForm orderSummaryForm) {
		log.info("Search order summary form: {}", orderSummaryForm);
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
		log.info("current page: {}", page.getCurrent());
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
		So so = soDao.findSoById(soId);
		SoDTO dto = new SoDTO();
		BeanUtils.copyProperties(so, dto);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SoDetailDTO> findSoDetail(long soId) {
		List<SoDetail> so = soDao.findSoDetailBySoId(soId);
		List<SoDetailDTO> soDTOs = new ArrayList<>();
		if (so != null && !so.isEmpty()) {
			SoDetailDTO dto = new SoDetailDTO();
			BeanUtils.copyProperties(so, dto);
			soDTOs.add(dto);
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
	public UserDTO findUserByOrderCode(String orderCode) {
		User user = userDao.findUserByOrderCode(orderCode);
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		return userDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void approve(OrderDTO orderDTO) {
		if (orderDTO == null) {
			throw new B2BException("Order is required");
		}

		log.info("orderId = " + orderDTO.getOrderId());

		Orders order = orderDao.findById(orderDTO.getOrderId());
		if (order == null) {
			throw new B2BException("Not found this order id: " + orderDTO.getOrderId());
		}

		Date expectShipDate = DateTimeUtil.generateExpectShipDate();

		order.setExpectReceiptDate(expectShipDate);
		order.setExpectShipmentDate(expectShipDate);
		order.setOrderStatus(OrderStatusConfig.APPROVED);

		orderDTO.setOrderStatus(OrderStatusConfig.APPROVED);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void reject(OrderDTO orderDTO) {
		if (orderDTO == null) {
			throw new B2BException("Order is required");
		}

		log.info("orderId = " + orderDTO.getOrderId());

		Orders order = orderDao.findById(orderDTO.getOrderId());
		if (order == null) {
			throw new B2BException("Not found this order id: " + orderDTO.getOrderId());
		}

		order.setOrderStatus(OrderStatusConfig.CANCELED);

		orderDTO.setOrderStatus(OrderStatusConfig.CANCELED);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateOrder(OrderDecisionForm form) {

		// ----- Order -----
		Orders order = orderDao.findById(form.getOrderReport().getOrderId());
		if (order == null) {
			throw new B2BException("Not found order: " + form.getOrderReport().getOrderId());
		}

		order.setRemarkCustomer(form.getRemarkCustomer());
		order.setRemarkOrders(form.getRemarkOrders());
		order.setPaymentTermId(form.getPaymentTermId());
		order.setPaymentMethodId(form.getPaymentMethodId());

		log.info("Updated order " + order.getOrderCode());

		// ----- Order Details -----

		// clear order detail
		int deleted = orderDetailDao.deleteByOrderId(order.getOrderId());
		log.info("Delete order details " + deleted + " items.");

		List<SearchOrderDetailDTO> orderDetails = form.getOrderDetails();

		if (orderDetails != null && !orderDetails.isEmpty()) {
			User custUser = userService.findByUsername(order.getUserCreate());
			for (SearchOrderDetailDTO dto : orderDetails) {
				ProductPriceDTO productPrice = null;
				ProductDTO product = productService.findById(dto.getProductId());
				if (product != null) {
					productPrice = productPriceDao.findProductPrice(dto.getProductCode(), order.getBrandGroupId(), custUser);
				}

				OrdDetail detail = new OrdDetail();
				BeanUtils.copyProperties(dto, detail);
				if (productPrice != null && detail.getAmount() > 0) {
					// productPrice's amount = product price per unit
					detail.setPrice(productPrice.getAmount());
					detail.setProductCurrency(productPrice.getProductCurrency());
				}
				if (StringUtils.isEmpty(detail.getProductUnitId())) {
					detail.setProductUnitId(applicationConfig.getDefaultProductUnit());
				}
				detail.setUserCreate(order.getUserCreate());
				detail.setTimeCreate(DateTimeUtil.getCurrentDate());
				detail.setTimeUpdate(DateTimeUtil.getCurrentDate());
				detail.setUserUpdate(UserUtil.getCurrentUsername());

				orderDetailDao.save(detail);
			}
		} else {
			log.warn("This order hasn't order details");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public void findShippedOrderDetail(List<SearchOrderDetailDTO> orderDetails) {
		log.info("findShippedOrderDetail size: " + (orderDetails == null ? 0 : orderDetails.size()));

		if (orderDetails != null && orderDetails.size() > 0) {
			for (SearchOrderDetailDTO ordDetail : orderDetails) {
				long shippedAmount = invoiceDao.findShippedAmount(ordDetail.getOrderDetailId());
				ordDetail.setShiped(shippedAmount);

				long totalAmount = ordDetail.getAmount();
				ordDetail.setPending(totalAmount - shippedAmount);

				log.info(String.format("OrderDetail: %s\ttotal: %d\tshipped: %d", ordDetail.getOrderDetailId(), totalAmount, shippedAmount));
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ArrayList<OrderDTO> newOrderByCurrency(Long brandId, Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod,
			Map<Long, ProductDTO> cart) {
		
		if(cart == null || cart.isEmpty()){
			throw new B2BException("Can't create order without product");
		}

		// ----- Validate address -----
		Addr invoiceToAddr = addrDao.findById(invoiceTo);
		if (invoiceToAddr == null) {
			throw new B2BException("Address 'Invoice To' is required");
		}

		Addr dispatchToAddr = addrDao.findById(dispatchTo);
		if (dispatchToAddr == null) {
			throw new B2BException("Address 'Dispatch To' is required");
		}
		
		ArrayList<OrderDTO> orders = new ArrayList<>();
		User user = UserUtil.getCurrentUser();
		
		// ----- set product price for group -----
		Set<Entry<Long,ProductDTO>> set = cart.entrySet();
		for (Entry<Long, ProductDTO> entry : set) {
			ProductDTO product = entry.getValue();
			ProductPriceDTO productPrice = productPriceDao.findProductPrice(product.getProductCode(), product.getProductTypeId(), user);
			
			BigDecimal amount = new BigDecimal(0);
			String currency = null;
			if(productPrice != null){
				currency = productPrice.getProductCurrency();
				amount = productPrice.getAmount();
			}
			product.setProductPrice(amount);
			product.setProductCurrency(currency);
		}
		
		// ----- group product by currency -----
		OrderHelper orderHelper = new OrderHelper();
		orderHelper.setConfig(applicationConfig);
		HashMap<String,List<ProductDTO>> productByCurrency = orderHelper.groupProductByCurrency(cart);
		Set<Entry<String, List<ProductDTO>>> productEntry = productByCurrency.entrySet();
		
		for (Entry<String, List<ProductDTO>> entry : productEntry) {
			List<ProductDTO> products = entry.getValue();
			if(products == null || products.size() == 0){
				throw new B2BException("No product to create order");
			}
			
			// Save Order
			String orderCode = generateOrderCode();
			log.info("\tGenerated orderCode = " + orderCode);

			Date currentDate = DateTimeUtil.getCurrentDate();
			

			Orders order = new Orders();
			order.setCustId(user.getCustomer().getCustId());
			order.setCustCode(user.getCustomer().getCustCode());
			order.setCustUserId("" + user.getId());
			order.setOrderCode(orderCode);
			order.setOrderStatus(applicationConfig.getOrderStatusNew());
			order.setOrderDate(currentDate);
			order.setBrandGroupId(brandId);
			order.setShippingId(shippingType);
			order.setPaymentMethodId(paymentMethod);
			order.setPaymentCurrencyId(entry.getKey());
			order.setPaymentTermId(applicationConfig.getNewOrderPaymentTermId());
			order.setRemarkCustomer(customerRemark);
			order.setTimeCreate(currentDate);
			order.setUserCreate(user.getUsername());
			order.setTimeUpdate(currentDate);

			long orderId = orderDao.save(order);


			// Save Order Detail
			for (ProductDTO product : products) {
				ProductPriceDTO productPrice = productPriceDao.findProductPrice(product.getProductCode(), brandId, user);
				// Default currency
				if (productPrice != null) {
					String currency = productPrice.getProductCurrency();
					if (StringUtils.isEmpty(currency)) {
						currency = applicationConfig.getDefaultProductCurrency();
					}
					product.setProductCurrency(currency);
				}
				// Default product unit id
				if (StringUtils.isEmpty(product.getProductUnitId())) {
					product.setProductUnitId(applicationConfig.getDefaultProductUnit());
				}

				// ----- Create order detail-----

				OrdDetail orderDetail = new OrdDetail();
				orderDetail.setOrderId(orderId);
				orderDetail.setProductId(product.getProductId());
				orderDetail.setAmount(product.getProductQuantity());
				if (productPrice != null && product.getProductQuantity() > 0) {
					orderDetail.setPrice(productPrice.getAmount());
				}
				orderDetail.setStatus(applicationConfig.getDefaultOrderDetailStatus());
				orderDetail.setProductCurrency(product.getProductCurrency());
				orderDetail.setProductUnitId(product.getProductUnitId());
				orderDetail.setProductBuyerGroupId(productPrice.getProductPriceGroupId());
				orderDetail.setUserCreate(user.getUsername());
				orderDetail.setTimeCreate(currentDate);

				orderDetailDao.save(orderDetail);
			}
		

			// Save Order address
			orderAddressDao.save(createOrderAddress(invoiceToAddr, orderId, AddressConstant.ORDER_INVOICE_TO));
			orderAddressDao.save(createOrderAddress(dispatchToAddr, orderId, AddressConstant.ORDER_DISPATCH_TO));

			// For generate report
			OrderDTO dto = new OrderDTO();
			BeanUtils.copyProperties(order, dto);
			orders.add(dto);
		}
		
		return orders;
	}

}
