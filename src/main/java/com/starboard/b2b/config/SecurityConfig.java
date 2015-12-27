package com.starboard.b2b.config;

import com.starboard.b2b.security.MD5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

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
	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/pages-front/images/**", "/upload/**", "/js/**", "/scripts/**", "/css/**", "/img/**", "/images/**", "/webjars/**", "/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		final CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);

		http.authorizeRequests().antMatchers("/login/**", "/gen_user", "/system/env").permitAll()
				.antMatchers("/backend/**").hasRole(ROLE_ADMIN)
				.antMatchers("/frontend/**").hasAnyRole(ROLE_USER, ROLE_ADMIN)
				.antMatchers("/report/**").authenticated()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/frontend")
				.failureUrl("/login?error")
				.and().logout().logoutSuccessUrl("/login")
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			    .and().rememberMe().rememberMeParameter("rememberMe").tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds((int) TimeUnit.MILLISECONDS.convert(5L, TimeUnit.DAYS)).and().csrf();
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository(){
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(datasource);
		return tokenRepository;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new MD5();
	}

}
