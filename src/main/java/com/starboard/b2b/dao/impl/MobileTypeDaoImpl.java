package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.MobileTypeDao;
import com.starboard.b2b.dto.MobileTypeDTO;

@Repository("mobileTypeDao")
public class MobileTypeDaoImpl implements MobileTypeDao{
	@Autowired
	private SessionFactory sf;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MobileTypeDTO> findAll() {
		return sf.getCurrentSession()
				.createQuery("select new com.starboard.b2b.dto.MobileTypeDTO(m.mobileId, m.description, m.name, m.timeCreate, m.timeUpdate, m.userCreate, m.userUpdate) from MobileType m")
				.list();
	}
	
}
