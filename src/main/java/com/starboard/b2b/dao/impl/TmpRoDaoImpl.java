package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpRoDao;
import com.starboard.b2b.model.sync.TmpRo;

@Repository("tmpRoDao")
public class TmpRoDaoImpl implements TmpRoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(TmpRo tmpRo) {
		sessionFactory.getCurrentSession().save(tmpRo);
	}

	@Override
	public void save(List<TmpRo> tmpRoList) {
		for (TmpRo tmpRo : tmpRoList) {
			save(tmpRo);
		}
	}

	@Override
	public TmpRo findById(long orderDetailId) {
		return (TmpRo) sessionFactory.getCurrentSession().get(TmpRo.class, orderDetailId);
	}

	@Override
	public int deleteByOrderId(long orderId) {
		String hql = "delete from TmpRo where orderId = :orderId";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("orderId", orderId).executeUpdate();
	}

}
