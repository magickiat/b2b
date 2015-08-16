package com.starboard.b2b.config;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, RootConfig.class, RepositoryConfig.class, ServiceConfig.class,
		SecurityConfig.class })

@WebAppConfiguration
public class SecurityConfigTest {

	private static final String FRONTEND = "/frontend";

	private static final String BACKEND = "/backend";

	private static final String ADMIN_NAME = "admin";

	private static final String USER_NAME = "user";

	private static final String ROLE_USER = "USER";

	private static final String ROLE_ADMIN = "ADMIN";

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).addFilter(springSecurityFilterChain).build();
	}

	@Test
	public void accessAdminPage_withoutRoleAdmin_mustForbidden() throws Exception {
		mvc.perform(get(BACKEND)).andExpect(unauthenticated());
		mvc.perform(get(BACKEND).with(user(USER_NAME).password("password").roles(ROLE_USER)).with(csrf()))
				.andExpect(status().isForbidden());
	}

	@Test
	public void accessAdminPage_withRoleAdmin_MustAuthenticated() throws Exception {
		mvc.perform(get(BACKEND).with(user(ADMIN_NAME).password(ADMIN_NAME).roles(ROLE_ADMIN)).with(csrf()))
				.andExpect(status().isOk());
	}

	@Test
	public void accessFrontend_withRoleUser_MustOk() throws Exception {
		mvc.perform(get(FRONTEND).with(user(USER_NAME).password("password").roles(ROLE_USER)).with(csrf()))
				.andExpect(status().isOk());
		mvc.perform(get(FRONTEND).with(user(ADMIN_NAME).password("password").roles(ROLE_ADMIN, ROLE_USER)).with(csrf()))
				.andExpect(status().isOk());
	}

}
