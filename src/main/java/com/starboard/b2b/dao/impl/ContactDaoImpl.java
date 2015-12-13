package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.dto.ContactDTO;

public class ContactDaoImpl implements ContactDao {

	private static final Logger log = LoggerFactory.getLogger(ContactDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactDTO> list() {
		// TODO Auto-generated method stub

		StringBuffer sb = new StringBuffer();
		sb.append(" select new com.starboard.b2b.dto.ContactDTO(contact.id, ");
		sb.append(" contact.time_create, ");
		sb.append(" contact.time_update, ");
		sb.append(" contact.user_create, ");
		sb.append(" contact.user_update, ");
		sb.append(" contact.contact_id, ");
		sb.append(" contact.address, ");
		sb.append(" contact.birth_date, ");
		sb.append(" contact.cust_id, ");
		sb.append(" contact.email, ");
		sb.append(" contact.facebook, ");
		sb.append(" contact.fax, ");
		sb.append(" contact.img_path, ");
		sb.append(" contact.mark_up, ");
		sb.append(" contact.mobile, ");
		sb.append(" contact.mobile_id, ");
		sb.append(" contact.name_en, ");
		sb.append(" contact.name_nick, ");
		sb.append(" contact.name_th, ");
		sb.append(" contact.name_title, ");
		sb.append(" contact.position, ");
		sb.append(" contact.sales_id, ");
		sb.append(" contact.signature_path, ");
		sb.append(" contact.skype, ");
		sb.append(" contact.tel, ");
		sb.append(" contact.twitter ) ");
		sb.append(" from contact ");
		return sessionFactory.getCurrentSession().createQuery(sb.toString()).list();
	}

	@Override
	public ContactDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addContact(ContactDTO contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContact(ContactDTO contact) {
		// TODO Auto-generated method stub

	}

}
