package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.model.Brand;
import com.starboard.b2b.model.Customer;

@Repository
public class BrandDaoImpl implements BrandDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Brand> list(Integer companyId) {
		return sessionFactory.getCurrentSession().createCriteria(Brand.class).add(Restrictions.eq("company", companyId))
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Brand> list() {
		return sessionFactory.getCurrentSession().createCriteria(Brand.class).list();
	}

	@Override
	public void addSelectedBrand(Integer custId, List<Integer> selectedBrand) {
		Session session = sessionFactory.getCurrentSession();

		Customer customer = (Customer) session.get(Customer.class, custId);
		for (Integer brandId : selectedBrand) {
			customer.getBrands().add((Brand) session.load(Brand.class, brandId));
		}
	}
}
