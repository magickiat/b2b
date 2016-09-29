package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpContact;

public interface TmpContactDao {
	void save(TmpContact tmpContact);
	
	int deleteByCustId(long custId);
}
