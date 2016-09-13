package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.TmpOrderAddressDao;
import com.starboard.b2b.model.TmpOrdAddress;

@Repository("tmpOrderAddressDao")
public class TmpOrderAddressDaoImpl implements TmpOrderAddressDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(TmpOrdAddress addr) {
		sessionFactory.getCurrentSession().save(addr);
	}

}
