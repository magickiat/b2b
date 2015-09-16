package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.model.product.Product;

public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Product> list() {
		return sf.getCurrentSession().createCriteria(Product.class).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Product> list(Page page) {
		Criteria criteria = sf.getCurrentSession().createCriteria(Product.class);
		criteria.setFirstResult(page.getFirstResult());
		criteria.setMaxResults(page.getSize());
		return criteria.list();
	}
}
