package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.sync.SoDetail;

public interface SoDetailDao {

	void save(SoDetail detail);

	int deleteBySoId(long soId);

	SoDetail findByOrderDetailId(Long orderDetailId) ;

	List<SoDetail> findBySoId(long soId);

}
