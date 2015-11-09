package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.CustBrandGroupDAO;
import com.starboard.b2b.model.CustBrandGroup;

@Repository("custBrandGroupDAO")
public class CustBrandGroupDAOImpl implements CustBrandGroupDAO {
	private static final Logger log = LoggerFactory.getLogger(CustBrandGroupDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<CustBrandGroup> findByCustId(Long custId) {
		log.info("findByCustId: " + custId);
		return sessionFactory.getCurrentSession().createCriteria(CustBrandGroup.class)
				.add(Restrictions.eq("id.custId", custId)).addOrder(Order.asc("id.custId")).list();
	}

}
