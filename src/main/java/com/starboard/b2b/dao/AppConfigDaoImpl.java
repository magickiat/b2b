package com.starboard.b2b.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.model.AppConfig;

@Repository
public class AppConfigDaoImpl implements AppConfigDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<AppConfig> getAllConfig() {
		return sessionFactory.getCurrentSession().createCriteria(AppConfig.class).list();
	}
	
	public Integer add(AppConfig config){
		return (Integer)sessionFactory.getCurrentSession().save(config);
	}
}
