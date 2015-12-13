package com.starboard.b2b.dao.impl;

import java.math.BigInteger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ContactDao;
import com.starboard.b2b.model.Contact;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long maxId() {
		/*Object max =  sessionFactory.getCurrentSession().createSQLQuery("select max(contact_id) from contact").uniqueResult();
		Long lmax = (Long)max;*/
		return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT MAX(contact_id) FROM contact").uniqueResult()).longValue();
	}

	@Override
	public Contact findById(Long contactId) {
		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, contactId);
	}

	@Override
	public void save(Contact obj) {
		 sessionFactory.getCurrentSession().save(obj);
	}

}
