package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.TmpSoDetailDao;
import com.starboard.b2b.model.TmpSoDetail;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tmpSoDetailDao")
public class TmpSoDetailDaoImpl implements TmpSoDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(TmpSoDetail detail) {
		sessionFactory.getCurrentSession().save(detail);
	}

	@Override
	public int deleteBySoId(long soId) {
		String hql = "delete from TmpSoDetail sd where sd.soId = :soId";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("soId", soId).executeUpdate();
	}

	@Override
	public TmpSoDetail findByOrderDetailId(Long orderDetailId) {
		return (TmpSoDetail) sessionFactory.getCurrentSession().createCriteria(TmpSoDetail.class).add(Restrictions.eq("orderProductId", orderDetailId))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TmpSoDetail> findBySoId(long soId) {
		return sessionFactory.getCurrentSession().createCriteria(TmpSoDetail.class).add(Restrictions.eq("soId", soId)).list();
	}

}
