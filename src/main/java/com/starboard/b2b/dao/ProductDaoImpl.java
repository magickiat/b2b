package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Product> list() {
		return sf.getCurrentSession().createCriteria(Product.class).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Product> list(Integer brandId) {
		Session session = sf.getCurrentSession();
		Brand brand = (Brand) session.get(Brand.class, brandId);
		return sf.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("brand", brand)).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Product> list(Pagination page) {
		Criteria criteria = sf.getCurrentSession().createCriteria(Product.class);
		criteria.setFirstResult(page.getFirstResult());
		criteria.setMaxResults(page.getSize());
		return criteria.list();
	}
}
