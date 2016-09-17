package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpOrdersAXDao;
import com.starboard.b2b.model.TmpOrdersFromAx;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpOrdersAXDao")
public class TmpOrdersAXDaoImpl implements TmpOrdersAXDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TmpOrdersFromAx> list() {
		return sessionFactory.getCurrentSession().createCriteria(TmpOrdersFromAx.class).list();
	}

	@Override
	public void removeAll() {
		final String hql = "DELETE FROM TmpOrdersFromAx";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void save(TmpOrdersFromAx tmpOrdersFromAx) {
		sessionFactory.getCurrentSession().save(tmpOrdersFromAx);
	}

}
