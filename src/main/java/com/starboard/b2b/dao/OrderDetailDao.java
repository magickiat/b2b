package com.starboard.b2b.dao;

import java.io.Serializable;
import java.util.List;

import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.model.OrdDetail;

public interface OrderDetailDao {

	Serializable save(OrdDetail detail);

	List<SearchOrderDetailDTO> searchOrderDetail(Long orderId);
	
	List<String> findAllOrderCurrency(Long orderId);
}