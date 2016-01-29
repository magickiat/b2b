package com.starboard.b2b.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.starboard.b2b.dao.EmailTemplateDao;
import com.starboard.b2b.model.EmailTemplate;

@Repository("emailTemplateDao")
public class EmailTemplateDaoImpl implements EmailTemplateDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EmailTemplate getTemplate(String id) {
		return (EmailTemplate) sessionFactory.getCurrentSession().get(EmailTemplate.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<EmailTemplate> list(){
		return sessionFactory.getCurrentSession().createCriteria(EmailTemplate.class).list();
	}
}
