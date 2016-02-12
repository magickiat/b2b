package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpSoDao;

@Repository("tmpSoDao")
public class TmpSoDaoImpl implements TmpSoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int deleteByOrderId(long orderId) {
		String hql = "delete from TmpSo where orderId = :orderId";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("orderId", orderId).executeUpdate();
	}
}
