package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.EmailStaffDao;
import com.starboard.b2b.model.EmailStaff;

@Repository("emailStaffDao")
public class EmailStaffDaoImpl implements EmailStaffDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EmailStaff findById(String id) {
		return (EmailStaff) sessionFactory.getCurrentSession().get(EmailStaff.class, id);
	}
}
