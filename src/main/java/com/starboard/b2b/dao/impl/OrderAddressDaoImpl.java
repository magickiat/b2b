package com.starboard.b2b.dao.impl;

import com.starboard.b2b.dao.OrderAddressDao;
import com.starboard.b2b.model.OrdAddress;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("orderAddressDao")
public class OrderAddressDaoImpl implements OrderAddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(Object obj) {
		return sessionFactory.getCurrentSession().save(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrdAddress> findByOrderId(long orderId) {
		return sessionFactory.getCurrentSession().createCriteria(OrdAddress.class).add(Restrictions.eq("orderId", orderId)).list();
	}

	@Override
	public int deleteByOrderId(long orderId) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from OrdAddress od where od.orderId = :orderId")
				.setLong("orderId", orderId)
				.executeUpdate();
	}

    @Override
    public int deleteByOrderCode(String orderCode) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from OrdAddress oa " +
						"where oa.orderAddressId in (" +
						" select oad.orderAddressId from OrdAddress oad, Orders o " +
						" where o.orderId = oad.orderId and o.orderCode = :orderCode " +
						")")
				.setString("orderCode", orderCode)
				.executeUpdate();
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Long> findIdsByOrderCodes(List<String> orderCodes){
		final String hql = " select distinct oad.orderAddressId from OrdAddress oad, Orders o " +
				" where o.orderId = oad.orderId and o.orderCode in (:orderCodes)";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameterList("orderCodes", orderCodes).list();
	}

	@Override
	public int deleteByIds(List<Long> ids) {
		final String hql = "delete from OrdAddress oa where oa.orderAddressId in (:ids)";
		return sessionFactory.getCurrentSession().createQuery(hql).setParameterList("ids", ids).executeUpdate();
	}
}
