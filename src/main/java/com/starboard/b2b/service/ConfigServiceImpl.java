package com.starboard.b2b.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.dao.AppConfigDao;
import com.starboard.b2b.model.AppConfig;

@Service
public class ConfigServiceImpl implements ConfigService {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigServiceImpl.class);

	@Autowired
	private AppConfigDao appConfigDao;

	private HashMap<String, String> config = new HashMap<>();

	public ConfigServiceImpl() {
	}
	
	@PostConstruct
	private void loadConfig() {
		log.info("Loading config...");
		List<AppConfig> allConfig = appConfigDao.getAllConfig();
		for (AppConfig appConfig : allConfig) {
			config.put(appConfig.getConfigKey(), appConfig.getConfigValue());
		}
		log.info(String.format("%d loaded config", config.size()));
	}

	public void reloadConfig() {
		config.clear();
		loadConfig();
	}

	@Transactional(readOnly = true)
	public String getString(String key) {
		return config.get(key);
	}

	@Transactional(readOnly = true)
	public Integer getInt(String key) {
		Integer value = null;
		String temp = config.get(key);
		if (temp != null) {
			value = Integer.valueOf(temp);
		}
		return value;
	}

	@Transactional
	public void addConfig(String key, String value) {
		if (StringUtils.isEmpty(key)) {
			throw new IllegalArgumentException("key is required");
		}
		if (StringUtils.isEmpty(value)) {
			throw new IllegalArgumentException("value is required");
		}

		AppConfig config = new AppConfig(key, value);
		config.setCreatedDate(new Date());
		Integer id = appConfigDao.add(config);
		log.info("config id: " + id);
	}

}
