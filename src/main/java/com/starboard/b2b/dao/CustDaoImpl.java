package com.starboard.b2b.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.SearchCustRequest;
import com.starboard.b2b.common.SearchCustResult;
import com.starboard.b2b.model.Cust;

@Repository("custDao")
public class CustDaoImpl implements CustDao {

	private static final Logger log = LoggerFactory.getLogger(CustDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public SearchCustResult listCust(SearchCustRequest req) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cust.class);

		SearchCustResult result = new SearchCustResult();
		result.setResult(criteria.setFirstResult(req.getFirstResult()).setMaxResults(req.getSize()).list());
		result.setTotal((long) criteria.setProjection(Projections.rowCount()).uniqueResult());
		
		log.info("Total" + result.getTotal());
		return result;
	}

}
