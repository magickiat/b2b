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

	List<OrdDetail> findByOrderCode(String orderCode);

	List<SearchOrderDetailReportResult> findOrderDetailByOrderId(long orderId);

	OrdDetail findById(long orderDetailId);

	Long findIdByOrderIdAndProductId(long orderId, long productId);

	int deleteByOrderId(long orderId);

	int deleteBySoNo(String soNo);

	int deleteWithoutSoNo(Long orderId);

    int deleteByOrderCode(String orderCode);

    List<Long> findIdsByOrderCodes(List<String> orderCodeAxes);

	void deleteByIds(List<Long> ids);
}
