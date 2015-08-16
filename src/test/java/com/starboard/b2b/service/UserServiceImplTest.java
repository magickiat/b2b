package com.starboard.b2b.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.config.RepositoryConfig;
import com.starboard.b2b.config.RootConfig;
import com.starboard.b2b.config.SecurityConfig;
import com.starboard.b2b.config.ServiceConfig;
import com.starboard.b2b.config.WebConfig;
import com.starboard.b2b.model.User;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, RootConfig.class, RepositoryConfig.class, ServiceConfig.class,
		SecurityConfig.class })
@WebAppConfiguration
@EnableTransactionManagement
public class UserServiceImplTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ConfigService configService;
	
	@Test
	public void testAdd_whenStart_mustOneUser() {
		UserRegisterForm form = new UserRegisterForm();
		form.setUsername("magicalcyber");
		form.setPassword("password");
		userService.add(form);
		
		User user = userService.findByUsername(form.getUsername());
		assertNotNull(user);
		assertEquals(form.getUsername(), user.getUsername());
	}
	
	@Test
	public void testListPage(){
		for (int i = 0; i < 30; i++) {
			UserRegisterForm form = new UserRegisterForm();
			form.setUsername("magicalcyber"+i);
			form.setPassword("password");
			userService.add(form);
		}
		
		configService.addConfig("page_size", "10");
		configService.reloadConfig();
		
		int pageSize = configService.getInt("page_size");
		
		Page page = new Page(1, pageSize);
		List<User> users1 = userService.list(page);
		assertNotNull(users1);
		assertTrue(users1.size() == pageSize);
		
		// Next page
		page.setCurrent(page.getCurrent()+1);
		List<User> users2 = userService.list(page);
		assertTrue(users2.size() == pageSize);
		assertTrue(!users1.containsAll(users2));
	}
	
}
