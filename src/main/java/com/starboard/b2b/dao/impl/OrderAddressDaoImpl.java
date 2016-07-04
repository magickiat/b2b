package com.starboard.b2b.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.OrderAddressDao;

@Repository("orderAddressDao")
public class OrderAddressDaoImpl implements OrderAddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(Object obj){
		return sessionFactory.getCurrentSession().save(obj);
	}
}
