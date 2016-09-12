package com.starboard.b2b.dao;

import com.starboard.b2b.model.TmpContact;

public interface TmpContactDao {
	Long maxId();

	TmpContact findById(Long contactId);
	
	void save(TmpContact obj);
}
