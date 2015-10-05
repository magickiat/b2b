package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.model.ProductBuyerGroup;

@Repository("productBuyerGroupDao")
public class ProductBuyerGroupDaoImpl implements ProductBuyerGroupDao {

	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBuyerGroup> findAll() {
		return sf.getCurrentSession().createCriteria(ProductBuyerGroup.class).list();
	}

}
