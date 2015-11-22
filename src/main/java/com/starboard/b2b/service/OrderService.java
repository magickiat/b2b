package com.starboard.b2b.service;

import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ShippingTypeDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;

import java.util.List;
import java.util.Map;

public interface OrderService {

	List<ShippingTypeDTO> findAllShippingType();

	List<PaymentMethodDTO> findAllPaymentMethod();

	long getNextRunningNo(int year);

	OrderDTO saveOrder(Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod, Map<Long, ProductDTO> cart);

	String generateOrderCode();

	List<OrderStatusDTO> findAllOrderStatus();

	OrderDTO findOrder(Long orderId);

	List<SearchOrderDetailDTO> searchOrderDetail(Long orderId);

	SearchOrderDTO findOrderForReport(Long orderId);

	List<OrdAddressDTO> findOrderAddress(Long orderId);
}
