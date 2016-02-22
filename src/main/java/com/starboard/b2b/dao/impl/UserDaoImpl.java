package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.model.User;
import com.starboard.b2b.util.DateTimeUtil;

@Repository("userDao")
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
	public User findById(Integer id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByCustId(Long id) {
		return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("customer.custId", id)).list();
	}

	@Override
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		if(user != null){
			user.setLastActive(DateTimeUtil.getCurrentDate());
			session.update(user);
			session.flush();
			session.evict(user);
		}
		return user;
	}

	@Override
	public void add(User user) {
		if (user.getCustomer() != null) {
			Cust cust = (Cust) sessionFactory.getCurrentSession().load(Cust.class, user.getCustomer().getCustId());
			user.setCustomer(cust);
		}
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list(Pagination page) {
		return sessionFactory.getCurrentSession().createCriteria(User.class).setFirstResult(page.getFirstResult()).setMaxResults(page.getSize())
				.list();
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public boolean exist(String identifierKey, Object identifierValue) {
		Number result = (Number) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq(identifierKey, identifierValue))
				.setProjection(Projections.rowCount()).uniqueResult();
		return result.longValue() > 0;
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);		
	}

}
