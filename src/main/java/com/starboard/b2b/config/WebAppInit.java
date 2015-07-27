package com.starboard.b2b.config;

import javax.servlet.Filter;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	// private static final Logger log =
	// LoggerFactory.getLogger(WebAppInit.class);

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class, RepositoryConfig.class, ServiceConfig.class, SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter(), new MultipartFilter(), new OpenSessionInViewFilter() };
	}

}
