package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.SoDetailDao;
import com.starboard.b2b.model.sync.SoDetail;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
	@SuppressWarnings("unchecked")
    public List<Long> findIdsSoNos(List<String> soNos) {
		String hql = "select distinct sd.soProductId from SoDetail sd, So s where sd.soId = s.soId and s.soNo in (:soNos)";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameterList("soNos", soNos).list();
    }

	@Override
	public void deleteByIds(List<Long> ids) {
		String hql = "delete from SoDetail sd where sd.soProductId in (:ids)";
		sessionFactory.getCurrentSession().createQuery(hql).setParameterList("ids", ids).executeUpdate();
	}

}
