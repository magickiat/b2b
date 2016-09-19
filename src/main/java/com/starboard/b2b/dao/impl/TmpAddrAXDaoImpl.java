package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpAddrAXDao;
import com.starboard.b2b.model.TmpAddrFromAx;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpAddrAXDao")
public class TmpAddrAXDaoImpl implements TmpAddrAXDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TmpAddrFromAx> list() {
		return sessionFactory.getCurrentSession().createCriteria(TmpAddrFromAx.class).list();
	}

	@Override
	public void removeAll() {
		final String hql = "DELETE FROM TmpAddrFromAx";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void save(TmpAddrFromAx tmpAddrFromAx) {
		sessionFactory.getCurrentSession().save(tmpAddrFromAx);
	}

    @Override
	@SuppressWarnings("unchecked")
    public List<Long> findCustIds() {
		String hql = "SELECT DISTINCT ta.custId FROM TmpAddrFromAx ta";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
    }

}
