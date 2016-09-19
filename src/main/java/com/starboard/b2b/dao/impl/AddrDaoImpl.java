package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.AddrDao;
import com.starboard.b2b.model.Addr;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository("addrDao")
public class AddrDaoImpl implements AddrDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Addr findById(long addrId) {
		return (Addr) sessionFactory.getCurrentSession().get(Addr.class, addrId);
	}

	@Override
	public void save(Object obj){
		 sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public Long maxId() {
		return ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("select max(addr_id) from addr").uniqueResult()).longValue();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Addr> findByCustId(long custId) {
		return sessionFactory.getCurrentSession().createCriteria(Addr.class).add(Restrictions.eq("custId", custId)).list();
	}

	@Override
	public void update(Addr addr) {
		sessionFactory.getCurrentSession().update(addr);
	}

    @Override
    public int deleteByCustId(long custId) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from Addr a where a.custId = :custId")
				.setLong("custId", custId)
				.executeUpdate();
    }
}
