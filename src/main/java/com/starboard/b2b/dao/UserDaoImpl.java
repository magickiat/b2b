package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.model.Customer;
import com.starboard.b2b.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User findById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByCustId(Long id) {
		return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("customer.id", id))
				.list();
	}

	@Override
	public User findByUsername(String username) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username)).uniqueResult();
	}

	@Override
	public void add(User user) {
		if (user.getCustomer() != null) {
			Customer cust = (Customer) sessionFactory.getCurrentSession().load(Customer.class,
					user.getCustomer().getCustId());
			user.setCustomer(cust);
		}
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list(Pagination page) {
		return sessionFactory.getCurrentSession().createCriteria(User.class).setFirstResult(page.getFirstResult())
				.setMaxResults(page.getSize()).list();
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public boolean exist(String identifierKey, Object identifierValue) {
		Number result = (Number) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq(identifierKey, identifierValue)).setProjection(Projections.rowCount())
				.uniqueResult();
		return result.longValue() > 0;
	}

}
