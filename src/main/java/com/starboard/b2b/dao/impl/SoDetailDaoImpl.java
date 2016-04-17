package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.model.sync.SoDetail;

@Repository("soDetailDao")
public class SoDetailDaoImpl implements SoDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(SoDetail detail) {
		sessionFactory.getCurrentSession().save(detail);
	}

	@Override
	public int deleteBySoId(long soId) {
		String hql = "delete from SoDetail sd where sd.soId = :soId";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("soId", soId).executeUpdate();
	}

	@Override
	public SoDetail findByOrderDetailId(Long orderDetailId) {
		return (SoDetail) sessionFactory.getCurrentSession().createCriteria(SoDetail.class).add(Restrictions.eq("orderProductId", orderDetailId))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SoDetail> findBySoId(long soId) {
		return sessionFactory.getCurrentSession().createCriteria(SoDetail.class).add(Restrictions.eq("soId", soId)).list();
	}

}
