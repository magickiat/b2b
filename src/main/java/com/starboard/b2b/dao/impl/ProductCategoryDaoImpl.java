package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductCategoryDao;
import com.starboard.b2b.model.ProductCategory;

@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductCategory> findAll() {
		return sf.getCurrentSession().createCriteria(ProductCategory.class).list();
	}

}
