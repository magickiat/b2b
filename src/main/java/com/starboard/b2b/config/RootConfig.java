package com.starboard.b2b.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@ComponentScan(basePackages = { "com.starboard.b2b.util" })
public class RootConfig {
	
	/*
	 * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}")
	 * annotations. Remove this bean if you are not using @Value annotations for
	 * injecting properties.
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		source.setUseCodeAsDefaultMessage(true);
		source.setFallbackToSystemLocale(false);
		return source;
	}
	
	@Bean
	public SessionLocaleResolver sessionLocaleResolver(){
		SessionLocaleResolver res = new SessionLocaleResolver();
		res.setDefaultLocale(Locale.US);
		return res;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		LocaleChangeInterceptor intercept = new LocaleChangeInterceptor();
		intercept.setParamName("lang");
		return intercept;
	}

}
