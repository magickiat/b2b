package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.dto.ContactDTO;

/**
 * create by nui on 13/12/2015
 */
public interface ContactDao {
	
	List<ContactDTO> list();
	
	ContactDTO getById(int id);
	
	void addContact(ContactDTO contact);
	
	void updateContact(ContactDTO contact);
	
}
