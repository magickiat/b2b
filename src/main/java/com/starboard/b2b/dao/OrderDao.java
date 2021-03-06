package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.OrdAddress;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.web.form.order.OrderSummaryForm;

import java.util.List;

public interface OrderDao {

	long save(Orders order);

	Orders findById(Long orderId);

	SearchOrderDTO findOrderForReport(Long orderId);

	/**
	 * Search order detail by order code
	 * @param orderCode Order code
	 * @return Search result
	 */
	SearchOrderDTO findOrderForReport(String orderCode);

	/**
	 * Find order list
	 * @param searchRequest Search request
	 * @return Search result
	 */
	SearchResult<SearchOrderDTO> search(SearchRequest<OrderSummaryForm> searchRequest);
	
	// for generate excel in order summary page
	List<SearchOrderDTO> searchOrderSummaryForReport(OrderSummaryForm searchRequest);

	List<OrdAddress> findOrderAddress(String orderCode);

	List<SearchOrderDTO> findOrderForReport(Long[] ordersId);
	
	Orders findByOrderCode(String roCode);

    int deleteByOrderCode(String orderCode);

	List<Orders> list();
}
