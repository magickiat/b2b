package com.starboard.b2b.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	private ContactDao contactDao;
	
	
	@Override
	public List<ContactDTO> list() {
		// TODO Auto-generated method stub
		return contactDao.list();
	}

	@Override
	public Page<ContactDTO> listCust(Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactDTO> list(Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ContactDTO contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ContactDTO contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
