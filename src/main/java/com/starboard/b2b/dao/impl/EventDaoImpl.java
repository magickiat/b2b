package com.starboard.b2b.dao.impl;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.EventDao;
import com.starboard.b2b.dto.search.SearchEventRequest;
import com.starboard.b2b.dto.search.SearchEventResult;
import com.starboard.b2b.model.Content;
import com.starboard.b2b.model.Event;

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
 * Created by User: Thanakit Jumparuang (jthanakit.dev@gmail.com) Date: 1/21/2016 14:02
 */
@Repository("eventDao")
public class EventDaoImpl implements EventDao {
	private static final Logger log = LoggerFactory.getLogger(EventDaoImpl.class);

	
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Event> list() {
        return sessionFactory.getCurrentSession().createCriteria(Content.class).list();
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> list(Pagination page) {
		return sessionFactory.getCurrentSession().createCriteria(Event.class).setFirstResult(page.getFirstResult())
				.setMaxResults(page.getSize()).list();
	}
    @Override
    public void add(Event event) {
        sessionFactory.getCurrentSession().save(event);
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SearchEventResult listEvents(SearchEventRequest req) {
		log.info("search request: " + req);

		SearchEventResult result = new SearchEventResult();

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Event.class);
		List list = criteria.addOrder(Order.desc("timeCreate")).setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		Object totalRecord = sessionFactory.getCurrentSession().createCriteria(Event.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		result.setResult(list);
		result.setTotal((long) totalRecord);

		log.info("Total " + result.getTotal());
		return result;
	}

	@Override
	public Event findById(int eventId) {
		return (Event) sessionFactory.getCurrentSession().get(Event.class, eventId);
	}

	@Override
	public void remove(final int eventId) {
		log.info("Removing event id {}", eventId);
		final Event removeEvent = new Event();
		removeEvent.setId(eventId);
		sessionFactory.getCurrentSession().delete("", removeEvent);
		log.info("Removed event id {}", eventId);
	}

	@Override
	public void update(final Event event){
		log.info("Updating event id {} update time {}", event.getId(), event.getTimeUpdate());
		sessionFactory.getCurrentSession().update(event);
		log.info("Updated event id {}", event.getId());
	}
}
