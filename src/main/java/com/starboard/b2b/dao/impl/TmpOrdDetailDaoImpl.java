package com.starboard.b2b.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpOrdDetailDao;
import com.starboard.b2b.model.TmpOrdDetail;

@Repository("tmpOrderDetailDao")
public class TmpOrdDetailDaoImpl implements TmpOrdDetailDao {
	
	private static final Logger log = LoggerFactory.getLogger(TmpOrdDetailDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(TmpOrdDetail detail) {
		return sessionFactory.getCurrentSession().save(detail);
	}

	@Override
	public TmpOrdDetail findById(long orderDetailId) {
		return (TmpOrdDetail) sessionFactory.getCurrentSession().get(TmpOrdDetail.class, orderDetailId);
	}

	@Override
	public int deleteBySoNo(String soNo) {
		String hql = "delete from TmpOrdDetail as od where exists ";
		hql += " ( from So as s, TmpSoDetail as sd where s.soId = sd.soId ";
		hql += " and sd.orderProductId = od.orderDetailId ";
		hql += " and s.soNo = :soNo )";
		return sessionFactory.getCurrentSession().createQuery(hql).setString("soNo", soNo).executeUpdate();
	}

	@Override
	public int deleteWithoutSoNo(Long orderId) {
		log.info("++++ order id = " + orderId);

		String hql = "delete from TmpOrdDetail as od1 where od1.orderId = :orderId and od1.orderDetailId not in( ";
		hql += "	select od2.orderDetailId from  TmpOrdDetail as od2";
		hql += "	, TmpSoDetail as sd, TmpSo s where od2.orderDetailId = sd.orderProductId ";
		hql += "	and sd.soId = s.soId";
		hql += "	and s.orderId = :orderId";
		hql += ") ";
		return sessionFactory.getCurrentSession().createQuery(hql).setLong("orderId", orderId).executeUpdate();
	}

	@Override
	public int deleteByOrderCode(String orderCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByOrderId(long orderId) {
		return sessionFactory.getCurrentSession().createQuery("delete from TmpOrdDetail od where od.orderId = :orderId").setLong("orderId", orderId)
				.executeUpdate();
	}
}
