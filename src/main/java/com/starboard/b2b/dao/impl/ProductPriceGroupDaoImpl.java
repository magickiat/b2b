package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductPriceGroupDao;
import com.starboard.b2b.dto.ProductPriceGroupDTO;

@Repository("productPriceGroupDao")
public class ProductPriceGroupDaoImpl implements ProductPriceGroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductPriceGroupDTO> list() {

		String queryString = "select new com.starboard.b2b.dto.ProductPriceGroupDTO";
		queryString += "(pg.productPriceGroupId, pg.productPriceGroupName, pg.description)";
		queryString += " from ProductPriceGroup pg";

		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	}
}
