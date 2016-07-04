package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductSoCategoryDao;
import com.starboard.b2b.model.ProductSoCategory;

@Repository("productSoCategoryDao")
public class ProductSoCategoryDaoImpl implements ProductSoCategoryDao {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProductSoCategory findById(String id){
		return (ProductSoCategory) sessionFactory.getCurrentSession().get(ProductSoCategory.class, id);
	}
}
