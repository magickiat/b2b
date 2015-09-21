package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.model.ProductType;

@Repository
public class ProductTypeDaoImpl implements ProductTypeDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductType> findAll() {
		return sf.getCurrentSession().createCriteria(ProductType.class).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductType> findByProductBrandGroupId(Integer brandGroupId) {
		return sf.getCurrentSession().createCriteria(ProductType.class)
				.add(Restrictions.eq("brandGroupId", brandGroupId)).list();
	}
}
