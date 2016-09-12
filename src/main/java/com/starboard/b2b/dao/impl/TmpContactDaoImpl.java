package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpContactDao;
import com.starboard.b2b.model.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository("contactDao")
public class TmpContactDaoImpl 
//implements TmpContactDao {
{

//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@Override
//	public Long maxId() {
//		/*Object max =  sessionFactory.getCurrentSession().createSQLQuery("select max(contact_id) from contact").uniqueResult();
//		Long lmax = (Long)max;*/
//		return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT MAX(contact_id) FROM contact").uniqueResult()).longValue();
//	}
//
//	@Override
//	public Contact findById(Long contactId) {
//		return (Contact) sessionFactory.getCurrentSession().get(Contact.class, contactId);
//	}
//
//	@Override
//	public void save(Contact obj) {
//		 sessionFactory.getCurrentSession().save(obj);
//	}

}
