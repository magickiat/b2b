package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpInvoiceDao;

@Repository("tmpInvoiceDao")
public class TmpInvoiceDaoImpl implements TmpInvoiceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int deleteByOrderId(long orderId) {
		String hql = "delete from TmpInvoice where orderId = :orderId";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("orderId", orderId).executeUpdate();
	}
	
}
