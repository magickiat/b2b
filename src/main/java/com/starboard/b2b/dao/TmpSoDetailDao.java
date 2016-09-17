package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpSoDetail;

import java.util.List;

public interface TmpSoDetailDao {

	void save(TmpSoDetail detail);

	int deleteBySoId(long soId);

	TmpSoDetail findByOrderDetailId(Long orderDetailId) ;

	List<TmpSoDetail> findBySoId(long soId);

}
