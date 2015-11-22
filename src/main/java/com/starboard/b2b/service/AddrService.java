package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.model.Addr;

public interface AddrService {

	Addr findById(long addrId);

	List<Addr> findByCustId(long custId);

}
