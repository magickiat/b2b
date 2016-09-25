package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.InvoiceDao;
import com.starboard.b2b.model.Invoice;
import com.starboard.b2b.model.InvoiceDetail;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

	/**
	 * Find Invoice by invoice id
	 *
	 * @param invoiceId Invoice id
	 * @return Invoice object
	 */
	@Override
	public Invoice findInvoiceById(long invoiceId) {
		return (Invoice) sessionFactory.getCurrentSession().get(Invoice.class, invoiceId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceDetail> findInvoiceDetailByInvoiceId(long invoiceId) {
		return (List<InvoiceDetail>) sessionFactory.getCurrentSession().createQuery("select ivd from InvoiceDetail ivd where ivd.invoiceId = :invoiceId")
				.setLong("invoiceId", invoiceId).list();
	}
}
