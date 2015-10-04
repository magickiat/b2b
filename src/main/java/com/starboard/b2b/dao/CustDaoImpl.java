package com.starboard.b2b.dao;

import java.util.List;

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SearchCustResult listCust(SearchCustRequest req) {
		log.info("search request: " + req);

		SearchCustResult result = new SearchCustResult();

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cust.class);
		List list = criteria.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		Object totalRecord = sessionFactory.getCurrentSession().createCriteria(Cust.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		result.setResult(list);
		result.setTotal((long) totalRecord);

		log.info("Total " + result.getTotal());
		return result;
	}

	@Override
	public Cust findById(Long custId) {
		return (Cust) sessionFactory.getCurrentSession().get(Cust.class, custId);
	}

}
