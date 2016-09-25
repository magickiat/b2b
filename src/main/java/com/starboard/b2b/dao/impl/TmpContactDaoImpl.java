package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpContactDao;
import com.starboard.b2b.model.TmpContact;

@Repository("tmpContactDao")
public class TmpContactDaoImpl implements TmpContactDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(TmpContact tmpContact) {
		sessionFactory.getCurrentSession().save(tmpContact);
	}

	@Override
	public int deleteByCustId(long custId) {
		return sessionFactory.getCurrentSession().createQuery("delete from TmpContact c where c.custId = :custId").setLong("custId", custId)
				.executeUpdate();
	}

}
