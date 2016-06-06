package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.ProductBrandGroupDAO;
import com.starboard.b2b.dto.ProductTypeDTO;
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

		return sessionFactory.getCurrentSession().createCriteria(ProductBrandGroup.class).add(Restrictions.eq("id.brandGroupId", brandGroupId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductTypeDTO> list() {
		String hql = "";
		hql += "select pg.id.brandGroupId as brandGroupId, pt.productTypeName as productTypeName from ProductBrandGroup pg";
		hql += " , ProductType pt where pg.id.productTypeId = pt.productTypeId";
		hql += " group by pg.id.brandGroupId";
		return sessionFactory.getCurrentSession().createQuery(hql).setResultTransformer(Transformers.aliasToBean(ProductTypeDTO.class)).list();
	}

}
