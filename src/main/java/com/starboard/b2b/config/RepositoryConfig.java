package com.starboard.b2b.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class RepositoryConfig {

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
		config.setDriverClassName(env.getProperty("jdbc.driver.class_name"));
		config.setJdbcUrl(env.getProperty("hibernate.hikari.dataSource.url"));
		config.setUsername(env.getProperty("hibernate.hikari.dataSource.user"));
		config.setPassword(env.getProperty("hibernate.hikari.dataSource.password"));

		config.addDataSourceProperty("cachePrepStmts", env.getProperty("hibernate.hikari.dataSource.cachePrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSize", env.getProperty("hibernate.hikari.dataSource.prepStmtCacheSize"));
		config.addDataSourceProperty("prepStmtCacheSqlLimit", env.getProperty("hibernate.hikari.dataSource.prepStmtCacheSqlLimit"));
		config.addDataSourceProperty("providerClass", env.getProperty("hibernate.connection.provider_class"));

		return new HikariDataSource(config);
	}

	private Properties hibernateProperties() {
		final Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
