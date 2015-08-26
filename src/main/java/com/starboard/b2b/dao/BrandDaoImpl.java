package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.starboard.b2b.model.Brand;

public class BrandDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

//	public List<Brand> list(Integer companyId) {
//		sessionFactory.getCurrentSession().createCriteria(Brand.class).add(Restrictions.eq("company", companyId))
//				.list();
//	}
}
