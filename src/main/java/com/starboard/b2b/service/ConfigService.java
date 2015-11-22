package com.starboard.b2b.service;

public interface ConfigService {
	
	void addConfig(String key, String value);

	void reloadConfig();

	String getString(String key);

	Integer getInt(String key);
	
	Boolean getBoolean(String key);

}