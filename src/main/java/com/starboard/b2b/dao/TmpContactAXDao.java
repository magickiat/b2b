package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpContactFromAx;

import java.util.List;

public interface TmpContactAXDao {
	List list();

	TmpContactFromAx findById(Long contactId);
	
	void save(TmpContactFromAx obj);

	void removeAll();

    List<Long> findCustIds();
}
