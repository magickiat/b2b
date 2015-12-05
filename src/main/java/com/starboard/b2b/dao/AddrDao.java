package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.Addr;

public interface AddrDao {

	Addr findById(long addrId);
	
	void save(Object obj);
	
	Long maxId();
	
	List<Addr> findByCustId(long custId);
	
	void update(Addr addr);

}
