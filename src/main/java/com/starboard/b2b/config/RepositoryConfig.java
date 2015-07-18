package com.starboard.b2b.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
@ComponentScan(basePackages = { "com.starboard.b2b.model", "com.starboard.b2b.dao" })
public class RepositoryConfig {

	private static final Logger log = LoggerFactory.getLogger(RepositoryConfig.class);

	@Autowired
	private Environment env;

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.starboard.b2b.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
//		config.setDataSourceClassName(env.getProperty("hibernate.hikari.dataSourceClassName"));
		config.setJdbcUrl(env.getProperty("hibernate.hikari.dataSource.url"));
		config.setUsername(env.getProperty("hibernate.hikari.dataSource.user"));
		config.setPassword(env.getProperty("hibernate.hikari.dataSource.password"));

		config.addDataSourceProperty("cachePrepStmts", env.getProperty("hibernate.hikari.dataSource.cachePrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSize",
				env.getProperty("hibernate.hikari.dataSource.prepStmtCacheSize"));
		config.addDataSourceProperty("prepStmtCacheSqlLimit",
				env.getProperty("hibernate.hikari.dataSource.prepStmtCacheSqlLimit"));
		config.addDataSourceProperty("providerClass", env.getProperty("hibernate.connection.provider_class"));

		return new HikariDataSource(config);
	}

	private Properties hibernateProperties() {
		final Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//		properties.put("hibernate.connection.provider_class", env.getProperty("hibernate.connection.provider_class"));

		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
