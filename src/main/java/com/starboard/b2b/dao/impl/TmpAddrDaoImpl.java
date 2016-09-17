package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpAddrDao;
import com.starboard.b2b.model.TmpAddr;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository("tmpAddrDao")
public class TmpAddrDaoImpl implements TmpAddrDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TmpAddr findById(long addrId) {
		return (TmpAddr) sessionFactory.getCurrentSession().get(TmpAddr.class, addrId);
	}

	@Override
	public void save(Object obj){
		 sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public Long maxId() {
		return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("select max(addr_id) from TmpAddr").uniqueResult()).longValue();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TmpAddr> findByCustId(long custId) {
		return sessionFactory.getCurrentSession().createCriteria(TmpAddr.class).add(Restrictions.eq("custId", custId)).list();
	}

	@Override
	public void update(TmpAddr addr) {
		sessionFactory.getCurrentSession().update(addr);
	}
}
