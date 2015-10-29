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

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBuyerGroup> findByBrandId(Long brandId) {
		StringBuffer sb = new StringBuffer();
		sb.append("from ProductBuyerGroup bg ");
		sb.append("where bg.productBuyerGroupId in ");
		sb.append("( select distinct p.productBuyerGroupId from Product p where p.productTypeId = :productTypeId)");
		return sf.getCurrentSession().createQuery(sb.toString()).setLong("productTypeId", brandId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBuyerGroup> findByProductType(List<Long> productType) {
		StringBuffer sb = new StringBuffer();
		sb.append("from ProductBuyerGroup bg ");
		sb.append("where bg.productBuyerGroupId in ");
		sb.append("( select distinct p.productBuyerGroupId from Product p where p.productTypeId IN ( :productTypeId) )");

		return sf.getCurrentSession().createQuery(sb.toString()).setParameterList("productTypeId", productType).list();
	}

}
