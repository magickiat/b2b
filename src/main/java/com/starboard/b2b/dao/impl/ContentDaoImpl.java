package com.starboard.b2b.dao.impl;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.ContentDao;
import com.starboard.b2b.dto.search.SearchContentRequest;
import com.starboard.b2b.dto.search.SearchContentResult;
import com.starboard.b2b.model.Content;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ken on 9/29/2015.
 */
@Repository("contentDao")
public class ContentDaoImpl implements ContentDao {
	private static final Logger log = LoggerFactory.getLogger(ContentDaoImpl.class);

	
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Content> list() {
        return sessionFactory.getCurrentSession().createCriteria(Content.class).list();
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<Content> list(Pagination page) {
		return sessionFactory.getCurrentSession().createCriteria(Content.class).setFirstResult(page.getFirstResult())
				.setMaxResults(page.getSize()).list();
	}
    @Override
    public void add(Content content) {
        sessionFactory.getCurrentSession().save(content);
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SearchContentResult listContent(SearchContentRequest req) {
		log.info("search request: " + req);

		SearchContentResult result = new SearchContentResult();

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Content.class);
		List list = criteria.addOrder(Order.desc("timeCreate")).setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		Object totalRecord = sessionFactory.getCurrentSession().createCriteria(Content.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		result.setResult(list);
		result.setTotal((long) totalRecord);

		log.info("Total " + result.getTotal());
		return result;
	}

	@Override
	public Content findById(int feedId) {
		return (Content) sessionFactory.getCurrentSession().get(Content.class, feedId);
	}
}
