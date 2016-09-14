package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.TmpOrders;

public interface TmpOrdersDao {

    TmpOrders findBySoId(final long soId);

    void remove(final long soId);

	void save(TmpOrders tmpOrders);

	List<TmpOrders> findByOrderCode(String orderCode);

	int deleteByOrderCode(String orderCode);

	TmpOrders findById(long orderId);

	int deleteById(long orderId);
	
	boolean isExistByOrderCode(String orderCode);

	void delete(List<TmpOrders> existTmpOrders);
}
