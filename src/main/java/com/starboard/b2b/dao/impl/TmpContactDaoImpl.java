package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpContactDao;
import com.starboard.b2b.model.TmpContact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository("tmpContactDao")
public class TmpContactDaoImpl implements TmpContactDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long maxId() {
		/*Object max =  sessionFactory.getCurrentSession().createSQLQuery("select max(contact_id) from contact").uniqueResult();
		Long lmax = (Long)max;*/
		return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT MAX(contact_id) FROM TmpContact").uniqueResult()).longValue();
	}

	@Override
	public TmpContact findById(Long contactId) {
		return (TmpContact) sessionFactory.getCurrentSession().get(TmpContact.class, contactId);
	}

	@Override
	public void save(TmpContact obj) {
		 sessionFactory.getCurrentSession().save(obj);
	}

}
