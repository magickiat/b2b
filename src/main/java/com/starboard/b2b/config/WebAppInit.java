package com.starboard.b2b.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.starboard.b2b.security.SecurityUserDetailService;

public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	private final int maxUploadSizeInMb = 10 * 1024 * 1014;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class, RepositoryConfig.class, SecurityUserDetailService.class, SecurityConfig.class };
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
		return new Filter[] { new HiddenHttpMethodFilter() };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {

		MultipartConfigElement multipartConfigElement = new MultipartConfigElement("", maxUploadSizeInMb, maxUploadSizeInMb * 2,
				maxUploadSizeInMb / 2);

		registration.setMultipartConfig(multipartConfigElement);

	}

}
