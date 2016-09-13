package com.starboard.b2b.dao;

import java.io.Serializable;
import java.util.List;

import com.starboard.b2b.model.OrdAddress;

public interface OrderAddressDao {

	Serializable save(Object obj);

	List<OrdAddress> findByOrderId(long orderId);

}