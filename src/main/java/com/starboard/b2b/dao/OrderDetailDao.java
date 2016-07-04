package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailReportResult;
import com.starboard.b2b.model.OrdDetail;

import java.io.Serializable;
import java.util.List;

public interface OrderDetailDao {

	Serializable save(OrdDetail detail);

	List<SearchOrderDetailDTO> searchOrderDetail(Long orderId);

	List<SearchOrderDetailDTO> searchOrderDetail(String orderCode);

	List<String> findAllOrderCurrency(Long orderId);

	List<SearchOrderDetailDTO> searchOrderDetail(Long[] ordersId);
	
	List<OrdDetail> findByOrderId(long orderId);
	
	List<SearchOrderDetailReportResult> findOrderDetailByOrderId(long orderId);

	OrdDetail findById(long orderDetailId);

	int deleteByOrderId(long orderId);

	int deleteBySoNo(String soNo);

	int deleteWithoutSoNo(Long orderId);
}
