package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.model.SoDetail;

@Repository("soDao")
public class SoDaoImpl implements SoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<SoDTO> findByOrderId(long orderId) {
		return sessionFactory.getCurrentSession().createQuery("SELECT new com.starboard.b2b.dto.SoDTO(s) from So s where s.orderId = :orderId")
				.setLong("orderId", orderId).list();
	}

	@Override
	public List<SoDetail> findByOrderDetailId(long orderDetailId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SoDetail.class);
		criteria.add(Restrictions.eq("orderProductId", orderDetailId));
		criteria.addOrder(Order.desc("timeCreate"));
		criteria.addOrder(Order.desc("timeUpdate"));
		
		return criteria.list();
	}
}
