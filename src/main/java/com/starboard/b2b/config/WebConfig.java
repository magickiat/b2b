package com.starboard.b2b.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.starboard.b2b")
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Upload folder
        log.info("upload path: " + uploadPath);
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + uploadPath);

        // WebJars
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
                .setCachePeriod(31556926);
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

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver createMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).ignoreAcceptHeader(true).useJaf(false)
                .defaultContentType(MediaType.TEXT_HTML)
                .mediaType("html", MediaType.TEXT_HTML)
                //.mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Override
    public Validator getValidator() {
        return new LocalValidatorFactoryBean();
    }

    //
    // @Bean
    // public MessageSource messageSource() {
    // ResourceBundleMessageSource source = new ResourceBundleMessageSource();
    // source.setBasename("classpath:messages");
    // source.setUseCodeAsDefaultMessage(true);
    // return source;
    // }

    /*
	 * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}")
	 * annotations. Remove this bean if you are not using @Value annotations for
	 * injecting properties.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
//        builder.propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//        builder.serializationInclusion(Include.NON_EMPTY);
//        builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//	}
}
