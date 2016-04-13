package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.sync.TmpSo;

public interface TmpSoDao {

	int deleteByOrderId(long orderId);

	List<TmpSo> findSoForImport();

}