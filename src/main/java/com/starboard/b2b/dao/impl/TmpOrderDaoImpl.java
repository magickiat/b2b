package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpOrdersDao;
import com.starboard.b2b.model.TmpOrders;

@Repository("tmpOrderDao")
public class TmpOrderDaoImpl implements TmpOrdersDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public TmpOrders findBySoId(long soId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(long soId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(TmpOrders tmpOrders) {
		sessionFactory.getCurrentSession().save(tmpOrders);
	}

	
}
