package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpProductDao;
import com.starboard.b2b.model.TmpProduct;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpProductDao")
public class TmpProductDaoImpl implements TmpProductDao {

	private static final Logger log = LoggerFactory.getLogger(TmpProductDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TmpProduct> list() {
		return sessionFactory.getCurrentSession().createCriteria(TmpProduct.class).list();
	}

	@Override
	public void removeAll() {
		final String hql = "DELETE FROM TmpProduct";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}
}
