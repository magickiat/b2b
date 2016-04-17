package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.SyncConstant;
import com.starboard.b2b.dao.TmpSoDao;
import com.starboard.b2b.model.sync.TmpSo;

@Repository("tmpSoDao")
public class TmpSoDaoImpl implements TmpSoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int deleteByOrderId(long orderId) {
		String hql = "delete from TmpSo where orderId = :orderId";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("orderId", orderId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TmpSo> findSoForImport() {
		String hql = " from TmpSo so ";
		hql += " where importStatus = :importStatus and dtsSystem = :dtsSystem ";
		hql += " order by soNo";

		return sessionFactory.getCurrentSession().createQuery(hql)
				.setString("dtsSystem", B2BConstant.AX_SYSTEM_NAME)
				.setLong("importStatus", SyncConstant.STATUS_FOUR)
				.list();
	}

	@Override
	public void save(TmpSo tmpSo) {
		sessionFactory.getCurrentSession().save(tmpSo);
	}
}
