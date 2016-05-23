package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ProductEmailDao;
import com.starboard.b2b.dto.ProductEmailDTO;
import com.starboard.b2b.model.ProductEmail;

@Repository("productEmailDao")
public class ProductEmailDaoImpl implements ProductEmailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEmailDTO> findByProductTypeId(Long productTypeId) {
		return sessionFactory.getCurrentSession()
				.createQuery(
						"select pe.id as id, pe.productTypeId as productTypeId, pe.email as email from ProductEmail pe where pe.productTypeId = :productTypeId")
				.setLong("productTypeId", productTypeId).setResultTransformer(Transformers.aliasToBean(ProductEmailDTO.class)).list();
	}

	@Override
	public void save(ProductEmail productEmail) {
		sessionFactory.getCurrentSession().save(productEmail);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductEmailDTO> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("select pe.id as id, pe.productTypeId as productTypeId, pe.email as email from ProductEmail pe order by pe.email ")
				.setResultTransformer(Transformers.aliasToBean(ProductEmailDTO.class)).list();
	}

	@Override
	public ProductEmailDTO findByEmail(Long productTypeId, String email) {
		return (ProductEmailDTO) sessionFactory.getCurrentSession()
				.createQuery("select pe.id as id, pe.productTypeId as productTypeId, pe.email as email from ProductEmail pe order by pe.email ")
				.setResultTransformer(Transformers.aliasToBean(ProductEmailDTO.class)).uniqueResult();
	}

}
