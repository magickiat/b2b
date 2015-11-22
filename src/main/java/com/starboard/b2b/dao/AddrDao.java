package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.Addr;

public interface AddrDao {

	Addr findById(long addrId);

	List<Addr> findByCustId(long custId);

}