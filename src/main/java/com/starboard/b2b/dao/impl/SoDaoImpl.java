package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.SoDao;
import com.starboard.b2b.dto.SoDTO;
import com.starboard.b2b.model.sync.So;
import com.starboard.b2b.model.sync.SoDetail;

@Repository("soDao")
public class SoDaoImpl implements SoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<SoDTO> findByOrderId(long orderId) {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT new com.starboard.b2b.dto.SoDTO(s) from So s where s.orderId = :orderId")
				.setLong("orderId", orderId)
				.list();
	}

	@Override
	public void save(So so) {
		sessionFactory.getCurrentSession().save(so);
	}

	@Override
	public So findBySoNo(String soNo) {
		return (So)sessionFactory.getCurrentSession()
				.createQuery("from So s where s.soNo = :soNo")
				.setString("soNo", soNo)
				.uniqueResult();
	}


	/**
	 * Find So by so id
	 *
	 * @param soId so id
	 * @return So object
	 */
	@Override
	public So findSoById(long soId) {
		return (So) sessionFactory.getCurrentSession().get(So.class, soId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SoDetail> findSoDetailBySoId(long soId) {
		return (List<SoDetail>) sessionFactory.getCurrentSession().createQuery("select sd from SoDetail sd where sd.soId = :soId")
				.setLong("soId", soId).list();
	}
}
