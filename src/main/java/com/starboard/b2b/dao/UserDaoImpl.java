package com.starboard.b2b.dao;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public UserDaoImpl() {
	}

	@Override
	public User findByUsername(String username) {
		throw new NotImplementedException();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

}
