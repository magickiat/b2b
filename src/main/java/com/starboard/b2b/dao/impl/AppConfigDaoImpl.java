package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.AppConfigDao;
import com.starboard.b2b.model.AppConfig;

@Repository("appConfigDao")
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

	@Override
	public String getConfig(String key) {
		return (String)sessionFactory.getCurrentSession().createCriteria(AppConfig.class).add(Restrictions.eq("configKey", key)).uniqueResult();
	}
}
