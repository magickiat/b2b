package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.PaymentMethodDao;
import com.starboard.b2b.dto.PaymentMethodDTO;

@Repository("paymentMethodDao")
public class PaymentMethodDaoImpl implements PaymentMethodDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<PaymentMethodDTO> list() {
		StringBuffer sb = new StringBuffer();
		sb.append("select new com.starboard.b2b.dto.PaymentMethodDTO(p.paymentMethodId, p.paymentMethodName, p.description, p.userCreate, p.userUpdate, p.timeCreate, p.timeUpdate) ");
		sb.append(" from PaymentMethod p");
		
		return sessionFactory.getCurrentSession().createQuery(sb.toString()).list();
	}
}
