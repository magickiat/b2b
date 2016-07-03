package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.BrandGroupDao;
import com.starboard.b2b.model.BrandGroup;

@Repository("brandGroupDao")
public class BrandGroupDaoImpl implements BrandGroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public BrandGroup findById(long brandGroupId) {
		return (BrandGroup) sessionFactory.getCurrentSession().get(BrandGroup.class, brandGroupId);
	}
}
