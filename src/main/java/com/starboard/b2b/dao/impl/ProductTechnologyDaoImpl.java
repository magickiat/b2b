package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductTechnologyDao;
import com.starboard.b2b.model.ProductTechnology;

@Repository("productTechnologyDao")
public class ProductTechnologyDaoImpl implements ProductTechnologyDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductTechnology> findAll() {
		return sf.getCurrentSession().createCriteria(ProductTechnology.class).list();
	}
}
