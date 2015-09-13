package com.starboard.b2b.config;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.starboard.b2b.service.ConfigService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.starboard.b2b")
public class WebConfig extends WebMvcConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

	@Autowired
	private ConfigService configService;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Upload folder
		registry.addResourceHandler("/upload/**").addResourceLocations("file:" + getUploadPath());

		// WebJars
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
				.setCachePeriod(31556926);
	}

	private String getUploadPath() {
		String uploadPath = configService.getString("upload_path");
		if (uploadPath == null) {
			throw new RuntimeException("Not found configuration upload_path");
		}
		if (!uploadPath.endsWith("/") | !uploadPath.endsWith("\\")) {
			uploadPath += "/";
		}

		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.exists() | !uploadFolder.isDirectory()) {
			log.info("Creating upload folder");
			uploadFolder.mkdirs();
		}

		log.info("uploadPath: " + uploadPath);
		return uploadPath;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).ignoreAcceptHeader(true).useJaf(false)
				.defaultContentType(MediaType.TEXT_HTML).mediaType("html", MediaType.TEXT_HTML)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("json", MediaType.APPLICATION_JSON);
	}

}
