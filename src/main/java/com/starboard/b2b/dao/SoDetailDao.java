package com.starboard.b2b.dao;

import com.starboard.b2b.model.sync.SoDetail;

import java.util.List;

public interface SoDetailDao {

	void save(SoDetail detail);

	int deleteBySoId(long soId);

	SoDetail findByOrderDetailId(Long orderDetailId) ;

	List<SoDetail> findBySoId(long soId);

    List<Long> findIdsSoNos(List<String> soNos);

	void deleteByIds(List<Long> ids);
}
