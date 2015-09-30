package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.model.CustBrandGroup;

@Repository("custBrandGroupDAO")
public class CustBrandGroupDAOImpl implements CustBrandGroupDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<CustBrandGroup> findByCustId(Long custId) {
		return sessionFactory.getCurrentSession().createCriteria(CustBrandGroup.class)
		.add(Restrictions.eq("id.custId", custId)).addOrder(Order.asc("id.custId")).list();
	}

}
