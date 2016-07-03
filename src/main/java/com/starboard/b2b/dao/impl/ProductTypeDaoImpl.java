package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.ProductTypeDao;
import com.starboard.b2b.model.ProductType;

@Repository("productTypeDao")
public class ProductTypeDaoImpl implements ProductTypeDao {
	
	private static final Logger log = LoggerFactory.getLogger(ProductTypeDaoImpl.class);

	@Autowired
	private SessionFactory sf;

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductType> findAll() {
		return sf.getCurrentSession().createCriteria(ProductType.class).addOrder(Order.asc("productTypeName")).list();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductType findById(Long id) {
		return ProductType.class.cast(sf.getCurrentSession().get(ProductType.class, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductType> findByProductBrandGroupId(Long brandGroupId) {
		Query query = sf.getCurrentSession().createQuery(
				"select new com.starboard.b2b.model.ProductType(a.productTypeId, a.productTypeName, a.productTypeParentId, a.productTypeDescription, a.userCreate, a.userUpdate, a.timeCreate, a.timeUpdate)  "
						+ " from ProductType as a, ProductBrandGroup b where a.productTypeId = b.id.productTypeId and b.id.brandGroupId = :brandGroupId");

		return query.setLong("brandGroupId", brandGroupId).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> findByCustomerAndBrand(Long customerId, Long brandGroupId) {
		Query query = sf.getCurrentSession().createQuery(
				"SELECT new com.starboard.b2b.model.ProductType(p.productTypeId, p.productTypeName, p.productTypeParentId, p.productTypeDescription, p.userCreate, p.userUpdate, p.timeCreate, p.timeUpdate) FROM com.starboard.b2b.model.ProductType p, com.starboard.b2b.model.CustBrandGroup c, com.starboard.b2b.model.ProductBrandGroup b WHERE p.productTypeId = c.id.brandGroupId AND c.id.brandGroupId = b.id.productTypeId AND c.id.custId = :cid AND b.id.brandGroupId = :bid");
		query.setLong("cid", customerId);
		query.setLong("bid", brandGroupId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> listDistinctProductType() {
		String queryString = "from ProductType type";
		queryString += " where type.productTypeId in ";
		queryString += " (select distinct g.id.brandGroupId from ProductBrandGroup g) ";
		queryString += " order by type.productTypeId";

		return sf.getCurrentSession().createQuery(queryString).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> findByCustomer(Long customerId) {
		log.info("cust id = " + customerId);
		
		Query query = sf.getCurrentSession().createQuery(
				"SELECT new com.starboard.b2b.model.ProductType(p.productTypeId, p.productTypeName, p.productTypeParentId, p.productTypeDescription, p.userCreate, p.userUpdate, p.timeCreate, p.timeUpdate) "
				+ " FROM com.starboard.b2b.model.ProductType p, com.starboard.b2b.model.CustBrandGroup c WHERE p.productTypeId = c.id.brandGroupId AND c.id.custId = :cid ");
		query.setLong("cid", customerId);
		return query.list();
	}

	@Override
	public void save(ProductType pt) {
		sf.getCurrentSession().save(pt);
	}
}
