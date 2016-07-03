package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.PaymentTermDao;
import com.starboard.b2b.dto.PaymentTermDTO;

@Repository("paymentTermDao")
public class PaymentTermDaoImpl implements PaymentTermDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentTermDTO> list() {
		String queryString = "select new com.starboard.b2b.dto.PaymentTermDTO";
		queryString += "(pt.paymentTermId, pt.paymentTermName, pt.description)";
		queryString += " from PaymentTerm pt";
		
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	}

}
