package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.CommonSearchRequest;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Orders;
import com.starboard.b2b.web.form.product.OrderSummaryForm;

public interface OrderDao {

	long save(Orders order);

	Orders findById(Long orderId);

	SearchOrderDTO findOrderForReport(Long orderId);

	/**
	 * Find order list
	 * @param searchRequest Search request
	 * @return Search result
	 */
	SearchResult<SearchOrderDTO> search(CommonSearchRequest<OrderSummaryForm> searchRequest);
}
