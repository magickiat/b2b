package com.starboard.b2b.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.OrderConfig;
import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.dao.OrderDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.OrdersIdRunningDao;
import com.starboard.b2b.dao.PaymentMethodDao;
import com.starboard.b2b.dao.ShippingTypeDao;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ShippingTypeDTO;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.OrdAddressId;
import com.starboard.b2b.model.OrdDetail;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.ConfigService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private ShippingTypeDao shippingTypeDao;

	@Autowired
	private PaymentMethodDao paymentMethodDao;

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
	private ConfigService configService;

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
	public void saveOrder(Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod,
			Map<Long, ProductDTO> cart) {
		Addr invoiceToAddr = addrDao.findById(invoiceTo);
		if (invoiceToAddr == null) {
			throw new IllegalArgumentException("Address 'Invoice To' is required");
		}

		Addr dispatchToAddr = addrDao.findById(dispatchTo);
		if (dispatchToAddr == null) {
			throw new IllegalArgumentException("Address 'Dispatch To' is required");
		}
		// TODO Ask question when multiple brand is choosed
		Entry<Long, ProductDTO> firstProduct = cart.entrySet().iterator().next();
		long brandGroupId = firstProduct.getValue().getProductTypeId();

		// Create Order
		String orderCode = generateOrderCode();
		log.info("\tGenerated orderCode = " + orderCode);

		User user = UserUtil.getCurrentUser();

		Orders order = new Orders();
		order.setCustId(user.getCustomer().getCustId());
		order.setCustCode(user.getCustomer().getCustCode());
		order.setCustUserId("" + user.getId());
		order.setOrderCode(orderCode);
		order.setOrderStatus(configService.getString(OrderConfig.KEY_DEFAULT_ORDER_STATUS));
		order.setOrderDate(DateTimeUtil.getCurrentDate());
		order.setBrandGroupId(brandGroupId);
		order.setShippingId(shippingType);
		order.setPaymentMethodId(paymentMethod);
		order.setPaymentCurrencyId(user.getCustomer().getCurrency());
		order.setPaymentTermId(configService.getString(OrderConfig.KEY_DEFAULT_PAYMENT_TERM_ID));
		order.setRemarkCustomer(customerRemark);
		order.setTimeCreate(DateTimeUtil.getCurrentDate());

		order.setTimeUpdate(DateTimeUtil.getCurrentDate());
		long orderId = orderDao.save(order);

		// Create Order Detail
		Set<Long> keySet = cart.keySet();
		for (Long key : keySet) {
			ProductDTO product = cart.get(key);
			// Default currency
			if (StringUtils.isEmpty(product.getProductCurrency())) {
				product.setProductCurrency(configService.getString(OrderConfig.KEY_PRODUCT_PRICE_TBA));
			}
			// Default product unit id
			if (StringUtils.isEmpty(product.getProductUnitId())) {
				product.setProductUnitId(configService.getString(OrderConfig.KEY_DEFAULT_PRODUCT_UNIT_ID));
			}

			OrdDetail orderDetail = new OrdDetail();
			orderDetail.setOrderId(orderId);
			orderDetail.setOrderProductId(product.getProductId());
			orderDetail.setAmount(product.getProductQuantity());
			if (product.getProductPrice() != null && product.getProductPrice().intValue() >= 0) {
				orderDetail.setPrice(product.getProductPrice().multiply(new BigDecimal(product.getProductQuantity())));
			}
			orderDetail.setProductCurrency(product.getProductCurrency());
			orderDetail.setProductUnitId(product.getProductUnitId());
			orderDetail.setProductBuyerGroupId(product.getProductBuyerGroupId());
			orderDetail.setUserCreate(user.getUsername());
			orderDetail.setTimeCreate(DateTimeUtil.getCurrentDate());

			orderDetailDao.save(orderDetail);
		}

		orderAddressDao.save(createOrderAddress(invoiceToAddr, orderId, AddressConstant.INVOICE_TO));
		orderAddressDao.save(createOrderAddress(dispatchToAddr, orderId, AddressConstant.DISPATCH_TO));
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
}
