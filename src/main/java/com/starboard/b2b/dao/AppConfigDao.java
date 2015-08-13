package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.AppConfig;

public interface AppConfigDao {

	List<AppConfig> getAllConfig();
	
	Integer add(AppConfig config);

}