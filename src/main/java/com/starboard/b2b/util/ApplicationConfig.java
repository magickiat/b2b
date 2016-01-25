package com.starboard.b2b.util;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class ApplicationConfig {

	//TODO with replace properties file
	
//	@Value("${page.size}")
	private String pageSize;

//	@Value("${order.status.new}")
	private String orderStatusNew;

//	@Value("${default.new.order.payment.term.id}")
	private String defaultPaymentTermId;

//	@Value("${default.product.currency}")
	private String defaultProductCurrency;

//	@Value("${default.product.unit}")
	private String defaultProductUnit;

//	@Value("${enabled.send.mail}")
	private String enableSendMail;

	public int getPageSize() {
		return 12;
	}

	public boolean getEnabledSendMail() {
		return false;
	}

	public String getOrderStatusNew() {
		return "10";
	}

	public String getNewOrderPaymentTermId() {
		return "3070AP";
	}

	public String getDefaultProductCurrency() {
		return "TBA";
	}

	public String getDefaultProductUnit() {
		return "PCS";
	}
}
