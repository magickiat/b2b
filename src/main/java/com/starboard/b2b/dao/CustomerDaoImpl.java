package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Customer findById(int id) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public Customer findByName(String name) {
		return (Customer) sessionFactory.getCurrentSession().createCriteria(Customer.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list() {
		return sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list(Page page) {
		return sessionFactory.getCurrentSession().createCriteria(Customer.class).setFirstResult(page.getFirstResult())
				.setMaxResults(page.getSize()).list();
	}

	@Override
	public void add(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		
	}
	
	@Override
	public void update(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
		
	}
}
