package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpAddr;

import java.util.List;

public interface TmpAddrDao {

	TmpAddr findById(long addrId);
	
	void save(Object obj);
	
	Long maxId();
	
	List<TmpAddr> findByCustId(long custId);
	
	void update(TmpAddr addr);

}
