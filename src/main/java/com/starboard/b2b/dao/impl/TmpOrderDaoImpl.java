package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpOrdersDao;
import com.starboard.b2b.model.TmpOrders;

@Repository("tmpOrderDao")
public class TmpOrderDaoImpl implements TmpOrdersDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TmpOrders findBySoId(long soId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(long soId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(TmpOrders tmpOrders) {
		sessionFactory.getCurrentSession().save(tmpOrders);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TmpOrders> findByOrderCode(String orderCode) {
		return sessionFactory.getCurrentSession().createCriteria(TmpOrders.class).add(Restrictions.eq("orderCode", orderCode)).list();
	}

	@Override
	public int deleteByOrderCode(String orderCode) {
		return sessionFactory.getCurrentSession().createQuery("delete from TmpOrders t where t.orderCode = :orderCode")
				.setString("orderCode", orderCode).executeUpdate();
	}

	@Override
	public TmpOrders findById(long orderId) {
		return (TmpOrders) sessionFactory.getCurrentSession().get(TmpOrders.class, orderId);
	}

	@Override
	public int deleteById(long orderId) {
		return sessionFactory.getCurrentSession().createQuery("delete from TmpOrders t where t.orderId = :orderId").setLong("orderId", orderId)
				.executeUpdate();
	}

	@Override
	public boolean isExistByOrderCode(String orderCode) {
		return sessionFactory.getCurrentSession().createCriteria(TmpOrders.class).setProjection(Projections.id()).setMaxResults(1)
				.uniqueResult() != null;
	}

	@Override
	public void delete(List<TmpOrders> existTmpOrders) {
		if(existTmpOrders != null && !existTmpOrders.isEmpty()){
			for (TmpOrders tmpOrders : existTmpOrders) {
				sessionFactory.getCurrentSession().delete(tmpOrders);
			}
		}
		
	}

}
