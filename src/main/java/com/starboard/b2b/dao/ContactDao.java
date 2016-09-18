package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.Contact;

public interface ContactDao {
	Long maxId();
	
	Contact findById(Long contactId);
	
	void save(Contact obj);

    void removeByCustId(long custId);

    List<Contact> findByCustId(long custId);
}
