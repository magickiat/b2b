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
				.createQuery("delete from OrdAddress od " +
						"where od.orderId in (" +
						" select od.id from OrdAddress od, Orders o " +
						" where o.orderId = od.orderId and o.orderCode = :orderCode " +
						")")
				.setString("orderCode", orderCode)
				.executeUpdate();
    }
}
