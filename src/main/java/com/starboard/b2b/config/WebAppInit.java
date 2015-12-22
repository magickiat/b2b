package com.starboard.b2b.config;

import com.starboard.b2b.security.SecurityUserDetailService;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // private static final Logger log =
    // LoggerFactory.getLogger(WebAppInit.class);
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class, RepositoryConfig.class, ServiceConfig.class, SecurityUserDetailService.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new HiddenHttpMethodFilter()};
    }

}
