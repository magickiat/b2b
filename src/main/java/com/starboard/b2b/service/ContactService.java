package com.starboard.b2b.service;

import java.util.List;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dto.ContactDTO;


/**
 * Created by nui on 14/12/2015.
 */

public interface ContactService {
	
	List<ContactDTO> list();
	
	Page<ContactDTO> listCust(Integer page);

	List<ContactDTO> list(Pagination page);

	void add(ContactDTO contact);

	void update(ContactDTO contact);
	
	void delete(int id);

}
