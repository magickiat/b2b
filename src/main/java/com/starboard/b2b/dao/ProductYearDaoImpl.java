package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.model.ProductYear;

@Repository
public class ProductYearDaoImpl implements ProductYearDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductYear> findAll() {
		return sf.getCurrentSession().createCriteria(ProductYear.class).list();
	}
}
