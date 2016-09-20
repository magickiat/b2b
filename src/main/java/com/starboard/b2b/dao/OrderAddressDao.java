package com.starboard.b2b.dao;

import com.starboard.b2b.model.OrdAddress;

import java.io.Serializable;
import java.util.List;

public interface OrderAddressDao {

	Serializable save(Object obj);

	List<OrdAddress> findByOrderId(long orderId);

	int deleteByOrderId(long orderId);

	int deleteByOrderCode(String orderCode);

    @SuppressWarnings("unchecked")
    List<Long> findIdsByOrderCodes(List<String> orderCodes);

	int deleteByIds(List<Long> ids);
}
