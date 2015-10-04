package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.model.ProductBrandGroup;

@Repository("productBrandGroupDAO")
public class ProductBrandGroupDAOImpl implements ProductBrandGroupDAO {
	private static final Logger log = LoggerFactory.getLogger(ProductBrandGroupDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<ProductBrandGroup> findByProductTypeId(Long brandGroupId) {
		log.info("findByProductTypeId: " + brandGroupId);
		
		return sessionFactory.getCurrentSession().createCriteria(ProductBrandGroup.class)
				.add(Restrictions.eq("id.brandGroupId", brandGroupId)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}

}
