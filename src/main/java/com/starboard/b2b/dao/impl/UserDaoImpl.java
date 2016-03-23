package com.starboard.b2b.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.Pagination;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchResult;
import com.starboard.b2b.model.Cust;
import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserSearchForm;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User findById(Integer id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByCustId(Long id) {
		return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("customer.custId", id)).list();
	}

	@Override
	public User findByUsername(String username) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
	}

	@Override
	public void add(User user) {
		if (user.getCustomer() != null) {
			Cust cust = (Cust) sessionFactory.getCurrentSession().load(Cust.class, user.getCustomer().getCustId());
			user.setCustomer(cust);
		}
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list(Pagination page) {
		return sessionFactory.getCurrentSession().createCriteria(User.class).setFirstResult(page.getFirstResult()).setMaxResults(page.getSize())
				.list();
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public boolean exist(String identifierKey, Object identifierValue) {
		Number result = (Number) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq(identifierKey, identifierValue))
				.setProjection(Projections.rowCount()).uniqueResult();
		return result.longValue() > 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SearchResult<UserDTO> search(SearchRequest<UserSearchForm> req) {
		Criteria queryTotal = sessionFactory.getCurrentSession().createCriteria(User.class).createAlias("customer", "cust", JoinType.LEFT_OUTER_JOIN);
		Criteria query = sessionFactory.getCurrentSession().createCriteria(User.class).createAlias("customer", "cust", JoinType.LEFT_OUTER_JOIN);

		// ----- set where condition -----
		if (req.getCondition() != null && StringUtils.isNotEmpty(req.getCondition().getKeyword())) {

			query.add(Restrictions.or(Restrictions.like("name", req.getCondition().getKeyword(), MatchMode.ANYWHERE),
					Restrictions.like("username", req.getCondition().getKeyword(), MatchMode.ANYWHERE),
					Restrictions.like("email", req.getCondition().getKeyword(), MatchMode.ANYWHERE),
					Restrictions.like("cust.nameEn", req.getCondition().getKeyword(), MatchMode.ANYWHERE)));

			queryTotal.add(Restrictions.or(Restrictions.like("name", req.getCondition().getKeyword(), MatchMode.ANYWHERE),
					Restrictions.like("username", req.getCondition().getKeyword(), MatchMode.ANYWHERE),
					Restrictions.like("email", req.getCondition().getKeyword(), MatchMode.ANYWHERE),
					Restrictions.like("cust.nameEn", req.getCondition().getKeyword(), MatchMode.ANYWHERE)));
		}

		// query
		Object total = queryTotal.setProjection(Projections.rowCount()).uniqueResult();
		List list = query.setFirstResult(req.getFirstResult()).setMaxResults(req.getPageSize()).list();

		SearchResult<UserDTO> result = new SearchResult<>();
		result.setTotal(total == null ? 0 : (long) total);
		result.setResult(list);
		return result;
	}

	@Override
	public User login(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		if (user != null) {
			session.update(user);
			session.flush();
			session.evict(user);
		}
		return user;
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

}
