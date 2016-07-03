package com.starboard.b2b.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tempProductDao")
public class TempProductDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	
}
