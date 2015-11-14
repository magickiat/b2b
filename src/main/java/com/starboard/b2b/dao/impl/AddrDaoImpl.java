package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.model.Addr;

@Repository("addrDao")
public class AddrDaoImpl implements AddrDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Addr findById(long addrId){
		return (Addr) sessionFactory.getCurrentSession().get(Addr.class, addrId);
	}
}
