package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpContactAXDao;
import com.starboard.b2b.model.TmpContact;
import com.starboard.b2b.model.TmpContactFromAx;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpContactAXDao")
public class TmpContactAXDaoImpl implements TmpContactAXDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TmpContactFromAx> list() {
		return sessionFactory.getCurrentSession().createCriteria(TmpContact.class).list();
	}

	@Override
	public TmpContactFromAx findById(Long contactId) {
		return (TmpContactFromAx) sessionFactory.getCurrentSession().get(TmpContactFromAx.class, contactId);
	}

	@Override
	public void save(TmpContactFromAx obj) {
		 sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public void removeAll() {
		final String hql = "DELETE FROM TmpContactFromAx";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}
}
