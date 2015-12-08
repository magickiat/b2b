package com.starboard.b2b.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.starboard.b2b.security.MD5;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.starboard.b2b" },
excludeFilters = {
        @Filter(type = FilterType.ASSIGNABLE_TYPE,
                value = {
                    WebConfig.class,
                    SecurityConfig.class
                })
    })
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ROLE_USER = "USER";
	private static final String ROLE_ADMIN = "ADMIN";
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/pages-front/images/**", "/upload/**", "/js/**", "/scripts/**", "/css/**", "/img/**", "/webjars/**", "/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login/**", "/gen_user/**", "/gen_customer/**").permitAll()
				.antMatchers("/backend/**").hasRole(ROLE_ADMIN)
				.antMatchers("/frontend/**").hasAnyRole(ROLE_USER, ROLE_ADMIN)
				.antMatchers("/report/**").authenticated()
				.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/frontend").failureUrl("/login?error").and().logout().logoutSuccessUrl("/login")
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new MD5();
	}

}
