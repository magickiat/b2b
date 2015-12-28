package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.CustomerDao;
import com.starboard.b2b.model.Cust;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Cust findById(Long id) {
		return (Cust) sessionFactory.getCurrentSession().get(Cust.class, id);
	}

	@Override
	public Cust findByName(String name) {
		return (Cust) sessionFactory.getCurrentSession().createCriteria(Cust.class).add(Restrictions.eq("nameEn", name)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cust> list() {
		return sessionFactory.getCurrentSession().createCriteria(Cust.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cust> list(Pagination page) {
		return sessionFactory.getCurrentSession().createCriteria(Cust.class).setFirstResult(page.getFirstResult()).setMaxResults(page.getSize())
				.list();
	}

	@Override
	public void add(Cust customer) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cust.class);
		Long maxCustId = (Long) criteria.setProjection(Projections.max("custId")).uniqueResult();
		customer.setCustId( maxCustId + 1);
		
		Log.info("cust_id = " + customer.getCustId());
		
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void update(Cust customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	public boolean exist(String identifierKey, Object identifierValue) {
		Number result = (Number) sessionFactory.getCurrentSession().createCriteria(Cust.class).add(Restrictions.eq(identifierKey, identifierValue))
				.setProjection(Projections.rowCount()).uniqueResult();
		return result.longValue() > 0;
	}
}
