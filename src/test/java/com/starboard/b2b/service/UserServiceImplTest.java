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
	
	@Test
	public void testAdd_whenStart_mustOneUser() {
		UserRegisterForm form = new UserRegisterForm();
		form.setUsername("magicalcyber");
		userService.add(form);
		
		User user = userService.findByUsername(form.getUsername());
		assertNotNull(user);
		assertEquals(form.getUsername(), user.getUsername());
	}

}
