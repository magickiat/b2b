package com.starboard.b2b.dao;

import com.starboard.b2b.model.Addr;

import java.util.List;

public interface AddrDao {

	Addr findById(long addrId);
	
	void save(Object obj);
	
	Long maxId();
	
	List<Addr> findByCustId(long custId);
	
	void update(Addr addr);

    int deleteByCustId(long custId);

    int deleteByCustIds(List<Long> custIds);

	List<Addr> findbyCustCode(String custCode);
}
