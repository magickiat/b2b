package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.SyncAxDao;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.dto.search.SearchSyncRequest;
import com.starboard.b2b.dto.search.SearchSyncResult;
import com.starboard.b2b.dto.search.SyncAxDto;
import com.starboard.b2b.model.SyncAx;

@Repository("syncAxDao")
public class SyncAxDaoImpl implements SyncAxDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(SyncAx sync) {
		sessionFactory.getCurrentSession().save(sync);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SearchSyncResult search(SearchRequest<SearchSyncRequest> req) {

		SearchSyncResult result = new SearchSyncResult();

		List list = sessionFactory.getCurrentSession()
				.createQuery("select s.syncId as syncId, s.syncDate as syncDate, s.status as status, s.remark as remark from SyncAx s order by s.syncDate desc")
				.setResultTransformer(Transformers.aliasToBean(SyncAxDto.class)).setFirstResult(req.getFirstResult())
				.setMaxResults(req.getPageSize()).list();

		Object totalRecord = sessionFactory.getCurrentSession().createCriteria(SyncAx.class).setProjection(Projections.rowCount()).uniqueResult();
		result.setResult(list);
		result.setTotal((long) totalRecord);

		return result;
	}

}
