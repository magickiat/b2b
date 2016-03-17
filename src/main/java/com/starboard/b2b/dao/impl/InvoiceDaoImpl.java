package com.starboard.b2b.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.InvoiceDao;

@Repository("invoiceDao")
public class InvoiceDaoImpl implements InvoiceDao {
	private static final Logger log = LoggerFactory.getLogger(InvoiceDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long findShippedAmount(long orderDetailId) {
		String sql = "select sum(ivd.amount) from InvoiceDetail ivd";
		sql += " where ivd.orderProductId = :orderProductId";

		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setLong("orderProductId", orderDetailId);

		Object result = query.uniqueResult();
		if(result == null){
			return 0;
		}
		return (Long) result ;
	}
}
