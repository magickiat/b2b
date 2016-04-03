package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.CustPriceGroupDao;
import com.starboard.b2b.model.CustPriceGroup;

@Repository("custPriceGroupDao")
public class CustPriceGroupDaoImpl implements CustPriceGroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Override
	public CustPriceGroup findByCustCode(String custCode, long productType) {
		List list = sessionFactory.getCurrentSession().createCriteria(CustPriceGroup.class).add(Restrictions.like("custCode", custCode))
				.add(Restrictions.eq("productTypeId", productType)).list();
		if (list != null && list.size() > 0) {
			return (CustPriceGroup) list.get(0);
		} else {
			return null;
		}
	}
}
