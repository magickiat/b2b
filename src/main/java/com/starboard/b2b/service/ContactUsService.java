package com.starboard.b2b.service;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ContactUsDTO;
import com.starboard.b2b.web.form.CreateContactUsForm;
import com.starboard.b2b.web.form.SearchContactUsForm;

/**
 * Created by nui on 14/12/2015.
 */

public interface ContactUsService {
	Page<ContactUsDTO> search(SearchContactUsForm form);

	void save(CreateContactUsForm createForm);

	void delete(long id);
	
	boolean existContact(long id);
}
