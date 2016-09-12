package com.starboard.b2b.dao;

import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailReportResult;
import com.starboard.b2b.model.TmpOrdDetail;

import java.io.Serializable;
import java.util.List;

public interface TmpOrdDetailDao {

	Serializable save(TmpOrdDetail detail);

	List<SearchOrderDetailDTO> searchOrderDetail(Long orderId);

	List<SearchOrderDetailDTO> searchOrderDetail(String orderCode);

	List<String> findAllOrderCurrency(Long orderId);

	List<SearchOrderDetailDTO> searchOrderDetail(Long[] ordersId);
	
	List<TmpOrdDetail> findByOrderId(long orderId);
	
	List<SearchOrderDetailReportResult> findOrderDetailByOrderId(long orderId);

	TmpOrdDetail findById(long orderDetailId);

	int deleteByOrderId(long orderId);

	int deleteBySoNo(String soNo);

	int deleteWithoutSoNo(Long orderId);
}
