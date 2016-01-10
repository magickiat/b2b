package com.starboard.b2b.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ContactUsDao;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Contactus;
import com.starboard.b2b.web.form.SearchContactUsForm;

@Repository("contactUsDao")
public class ContactUsDaoImpl implements ContactUsDao {

	private static final Logger log = LoggerFactory.getLogger(CustDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SearchResult<Contactus> search(SearchRequest<SearchContactUsForm> req) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contactus.class);
		Criteria criteriaTotal = sessionFactory.getCurrentSession().createCriteria(Contactus.class);

		// ----- set criteria -----
		Criterion crKeyword = null;
		if (req != null && req.getCondition() != null) {

			if (StringUtils.isNotEmpty(req.getCondition().getKeyword())) {
				crKeyword = Restrictions.or(Restrictions.or(Restrictions.like("contactName", req.getCondition().getKeyword(), MatchMode.ANYWHERE),
						Restrictions.like("contactTitle", req.getCondition().getKeyword(), MatchMode.ANYWHERE)));
			}
		}

		if (crKeyword != null) {
			criteria.add(crKeyword);
			criteriaTotal.add(crKeyword);
		}

		// ----- Find records -----
		List list = criteria.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		// ----- Find total -----
		Object totalRecord = criteriaTotal.setProjection(Projections.rowCount()).uniqueResult();

		// ----- Set result -----
		SearchResult<Contactus> result = new SearchResult<>();
		result.setResult(list);
		result.setTotal((long) totalRecord);

		return result;
	}

	@Override
	public void save(Object contactUs) {
		sessionFactory.getCurrentSession().save(contactUs);
	}

	@Override
	public Contactus findById(long id) {
		return (Contactus) sessionFactory.getCurrentSession().get(Contactus.class, id);
	}

	@Override
	public void delete(Contactus contactUs) {
		sessionFactory.getCurrentSession().delete(contactUs);
	}

}
