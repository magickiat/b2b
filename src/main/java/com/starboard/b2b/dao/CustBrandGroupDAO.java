package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.CustBrandGroup;

public interface CustBrandGroupDAO {
	List<CustBrandGroup> findByCustId(Long custId);
}
