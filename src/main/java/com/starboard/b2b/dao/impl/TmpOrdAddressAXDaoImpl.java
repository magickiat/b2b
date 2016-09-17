package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpOrdAddressAXDao;
import com.starboard.b2b.model.TmpOrdAddressFromAx;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("tmpOrderAddressAXDao")
public class TmpOrdAddressAXDaoImpl implements TmpOrdAddressAXDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TmpOrdAddressFromAx> list() {
		return sessionFactory.getCurrentSession().createCriteria(TmpOrdAddressFromAx.class).list();
	}

	@Override
	public void removeAll() {
		final String hql = "DELETE FROM TmpOrdAddressFromAx";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void save(TmpOrdAddressFromAx ordAddressFromAx) {
		sessionFactory.getCurrentSession().save(ordAddressFromAx);
	}

	@Override
	public int deleteByOrderId(long orderId) {
		return sessionFactory.getCurrentSession().createQuery("delete from TmpOrdAddressFromAx od where od.orderId = :orderId").setLong("orderId", orderId)
				.executeUpdate();
	}

}
