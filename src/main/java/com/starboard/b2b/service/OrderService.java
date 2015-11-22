package com.starboard.b2b.service;

import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ShippingTypeDTO;

import java.util.List;
import java.util.Map;

public interface OrderService {

	List<ShippingTypeDTO> findAllShippingType();

	List<PaymentMethodDTO> findAllPaymentMethod();
	
	long getNextRunningNo(int year); 

	void saveOrder(Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod, Map<Long, ProductDTO> cart);

	String generateOrderCode();

	List<OrderStatusDTO> findAllOrderStatus();
}
