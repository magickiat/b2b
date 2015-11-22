package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.model.Orders;

public interface OrderDao {

	long save(Orders order);

	Orders findById(Long orderId);

	SearchOrderDTO findOrderForReport(Long orderId);

}