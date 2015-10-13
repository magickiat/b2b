package com.starboard.b2b.dao;

import java.util.List;

import com.starboard.b2b.model.AppConfig;

public interface AppConfigDao {

	List<AppConfig> getAllConfig();
	
	String getConfig(String key);
	
	Integer add(AppConfig config);

}