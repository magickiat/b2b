package com.starboard.b2b.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.starboard.b2b.config.RepositoryConfig;
import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.config.SecurityConfig;
import com.starboard.b2b.config.ServiceConfig;
import com.starboard.b2b.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, RootConfig.class, RepositoryConfig.class, ServiceConfig.class,
		SecurityConfig.class })
@WebAppConfiguration
@EnableTransactionManagement
public class ConfigServiceImplTest {

	@Autowired
	private ConfigService service;

	@Test
	public void testReloadConfig_addNewKey_mustFound() {
		assertNull(service.getString("key"));
		service.addConfig("key", "value");
		service.reloadConfig();
		assertNotNull(service.getString("key"));
	}

	 @Test
	public void testGetInt() {
		assertNull(service.getString("int_key"));
		service.addConfig("int_key", "1234");
		service.reloadConfig();
		Integer value = service.getInt("int_key");
		assertNotNull(value);
		assertTrue(1234 == value.intValue());
	}

}
