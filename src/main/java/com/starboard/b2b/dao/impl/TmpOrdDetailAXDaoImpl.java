package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpOrdDetailAXDao;
import com.starboard.b2b.model.TmpOrdDetailFromAx;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpOrderDetailAXDao")
public class TmpOrdDetailAXDaoImpl implements TmpOrdDetailAXDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TmpOrdDetailFromAx> list() {
		return sessionFactory.getCurrentSession().createCriteria(TmpOrdDetailFromAx.class).list();
	}

	@Override
	public void removeAll() {
		final String hql = "DELETE FROM TmpOrdDetailFromAx";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void save(TmpOrdDetailFromAx ordAddressFromAx) {
		sessionFactory.getCurrentSession().save(ordAddressFromAx);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> findOrderCodes() {
		final String hql = "SELECT DISTINCT tod.orderCode FROM TmpOrdDetailFromAx tod";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

}
