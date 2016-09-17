package com.starboard.b2b.dao;

import java.io.Serializable;

import com.starboard.b2b.model.TmpOrdDetail;

public interface TmpOrdDetailDao {

	Serializable save(TmpOrdDetail detail);

	TmpOrdDetail findById(long orderDetailId);

	int deleteBySoNo(String soNo);

	int deleteWithoutSoNo(Long orderId);

	int deleteByOrderCode(String orderCode);

	int deleteByOrderId(long orderId);

}
