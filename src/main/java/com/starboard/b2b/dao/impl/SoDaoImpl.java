package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.model.sync.So;

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
	public void save(So so) {
		sessionFactory.getCurrentSession().save(so);
	}

}
