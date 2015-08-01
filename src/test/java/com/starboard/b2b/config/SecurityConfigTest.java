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
		mvc.perform(get("/backend")).andExpect(unauthenticated());
		mvc.perform(get("/backend").with(user("user").password("password").roles("USER")).with(csrf()))
				.andExpect(status().isForbidden());
	}

	@Test
	public void accessAdminPage_withRoleAdmin_MustAuthenticated() throws Exception {
		mvc.perform(get("/backend").with(user("admin").password("admin").roles("ADMIN")).with(csrf()))
				.andExpect(status().isOk());
	}

	@Test
	public void accessFrontend_withRoleUser_MustOk() throws Exception {
		mvc.perform(get("/frontend").with(user("user").password("password").roles("USER")).with(csrf()))
				.andExpect(status().isOk());
		mvc.perform(get("/frontend").with(user("admin").password("password").roles("ADMIN", "USER")).with(csrf()))
				.andExpect(status().isOk());
	}

}
