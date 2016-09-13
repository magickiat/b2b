package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpOrdersDao;
import com.starboard.b2b.model.TmpOrders;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tmpOrderDao")
public class TmpOrderDaoImpl implements TmpOrdersDao {

	private static final Logger log = LoggerFactory.getLogger(TmpOrderDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TmpOrders findBySoId(long soId) {
		return null;
	}

	@Override
	public void remove(long soId) {
		//TODO
	}
}
