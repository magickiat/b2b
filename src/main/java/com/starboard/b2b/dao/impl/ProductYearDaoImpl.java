package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductYearDao;
import com.starboard.b2b.model.ProductYear;

@Repository("productYearDao")
public class ProductYearDaoImpl implements ProductYearDao {

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductYear> findAll() {
		return sf.getCurrentSession().createCriteria(ProductYear.class).list();
	}

	@Override
	public ProductYear findByYear(String year) {
		Object result = sf.getCurrentSession().createCriteria(ProductYear.class).add(Restrictions.like("productYearName", year)).setMaxResults(1)
				.uniqueResult();

		if (result != null) {
			return (ProductYear) result;
		}

		return null;
	}
}
