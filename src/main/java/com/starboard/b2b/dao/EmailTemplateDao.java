package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.EmailTemplate;

public interface EmailTemplateDao {

	EmailTemplate getTemplate(String id);

	List<EmailTemplate> list();

}