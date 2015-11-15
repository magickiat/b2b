package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductTypeDao;
import com.starboard.b2b.model.ProductType;

@Repository("productTypeDao")
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
	public List<ProductType> findByProductBrandGroupId(Long brandGroupId) {
		Query query = sf.getCurrentSession().createQuery(
				"select new com.starboard.b2b.model.ProductType(a.productTypeId, a.productTypeName, a.productTypeParentId, a.productTypeDescription, a.userCreate, a.userUpdate, a.timeCreate, a.timeUpdate)  "
				+ " from ProductType as a, ProductBrandGroup b where a.productTypeId = b.id.productTypeId and b.id.brandGroupId = :brandGroupId");
		
		return query.setLong("brandGroupId", brandGroupId).list();

	}
}
