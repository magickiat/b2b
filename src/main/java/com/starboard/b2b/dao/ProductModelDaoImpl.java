package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.model.ProductModel;

@Repository
public class ProductModelDaoImpl implements ProductModelDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductModel> findAll(){
		return sf.getCurrentSession().createCriteria(ProductModel.class).list();
	}
}
