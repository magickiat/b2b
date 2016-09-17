package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpOrdAddressFromAx;

import java.util.List;

public interface TmpOrderAddressAXDao {

	List<TmpOrdAddressFromAx> list();

	void removeAll();

	void save(TmpOrdAddressFromAx ordAddressFromAx);

	int deleteByOrderId(long orderId);

}
