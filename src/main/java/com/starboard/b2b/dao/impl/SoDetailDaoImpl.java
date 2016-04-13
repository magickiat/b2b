package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.model.sync.SoDetail;

@Repository("soDetailDao")
public class SoDetailDaoImpl implements SoDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(SoDetail detail) {
		sessionFactory.getCurrentSession().save(detail);
	}

}
