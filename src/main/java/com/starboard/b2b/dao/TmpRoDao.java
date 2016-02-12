package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.sync.TmpRo;

public interface TmpRoDao {

	void save(TmpRo tmpRo);

	void save(List<TmpRo> tmpRoList);

	TmpRo findById(long orderDetailId);

	int deleteByOrderId(long orderId);

}