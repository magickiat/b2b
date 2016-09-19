package com.starboard.b2b.dao;

import com.starboard.b2b.model.Contact;

import java.util.List;

public interface ContactDao {
	Long maxId();
	
	Contact findById(Long contactId);
	
	void save(Contact obj);

    void removeByCustId(long custId);

    void removeByCustIds(List<Long> custIds);

    List<Contact> findByCustId(long custId);
}
