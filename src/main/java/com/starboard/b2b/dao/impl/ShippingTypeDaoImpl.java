package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.ShippingTypeDao;
import com.starboard.b2b.dto.ShippingTypeDTO;

@Repository("shippingTypeDao")
public class ShippingTypeDaoImpl implements ShippingTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<ShippingTypeDTO> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append(
				"select new com.starboard.b2b.dto.ShippingTypeDTO(st.shippingTypeId,st.shippingTypeName,st.description,st.userCreate,st.userUpdate,st.timeCreate,st.timeUpdate)");
		sb.append(" from ShippingType st");
		return sessionFactory.getCurrentSession().createQuery(sb.toString()).list();
	}
}
