package com.starboard.b2b.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.model.OrdDetail;

@Repository("orderDetailDao")
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(OrdDetail detail) {
		return sessionFactory.getCurrentSession().save(detail);
	}
}
