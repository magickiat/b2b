package com.starboard.b2b.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.starboard.b2b.common.Page;
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
import com.starboard.b2b.web.form.order.OrderDecisionForm;
import com.starboard.b2b.web.form.order.OrderSummaryForm;

public interface OrderService {

	List<ShippingTypeDTO> findAllShippingType();

	List<PaymentMethodDTO> findAllPaymentMethod();

	List<PaymentTermDTO> findAllPaymentTerm();

	long getNextRunningNo(int year);

	OrderDTO newOrder(Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod, Map<Long, ProductDTO> cart);

	ArrayList<OrderDTO> newOrderByCurrency(Long invoiceTo, Long dispatchTo, String shippingType, String customerRemark, String paymentMethod,
			Map<Long, ProductDTO> cart);

	String generateOrderCode();

	List<OrderStatusDTO> findAllOrderStatus();

	OrderDTO findOrder(Long orderId);

	List<SearchOrderDetailDTO> searchOrderDetail(Long orderId);

	List<SearchOrderDetailDTO> searchOrderDetail(String orderCode);

	void findShippedOrderDetail(List<SearchOrderDetailDTO> orderDetails);

	SearchOrderDTO findOrderForReport(Long orderId);

	SearchOrderDTO findOrderForReport(String orderCode);

	List<OrdAddressDTO> findOrderAddress(String orderCode);

	Page<SearchOrderDTO> searchOrder(OrderSummaryForm orderSummaryForm);

	List<SearchOrderDTO> searchOrderForReport(OrderSummaryForm orderSummaryForm);

	List<String> findAllOrderCurrency(Long orderId);

	List<SearchOrderDTO> findOrderForReport(Long[] ordersId);

	List<SearchOrderDetailDTO> searchOrderDetail(Long[] ordersId);

	SoDTO findSO(final long soId);

	List<SoDetailDTO> findSoDetail(final long soId);

	UserDTO findUserByOrderCode(String orderCode);

	List<SoDTO> listSO(long orderId);

	void approve(OrderDTO orderReport);

	void reject(OrderDTO order);

	void updateOrder(OrderDecisionForm form);

}
