package com.starboard.b2b.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("applicationConfig")
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class ApplicationConfig {

	private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
	// TODO with replace properties file
	
	@Autowired
	private Environment env;

	// @Value("${page.size}")
	private String pageSize;

	// @Value("${order.status.new}")
	private String orderStatusNew;

	// @Value("${default.new.order.payment.term.id}")
	private String defaultPaymentTermId;

	// @Value("${default.product.currency}")
	private String defaultProductCurrency;

	// @Value("${default.product.unit}")
	private String defaultProductUnit;

	public int getPageSize() {
		return Integer.parseInt(env.getProperty("page.size"));
	}

	public boolean getEnabledSendMail() {
		return Boolean.parseBoolean(env.getProperty("enabled.send.mail"));
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

	public String getDefaultProductBuyerGroup() {
		return "GROUP1";
	}

	public Long getDefaultOrderDetailStatus() {
		return 0L;
	}

	public String getDefaultProductLength() {
		return "Undefined";
	}

	public String[] getMailApprover() {
		return EmailUtils.split(env.getProperty("email.sales"));
	}

	public String[] getMailBCCApprover() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getMailCCApprover() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMailFrom() {
		return "b2b@star-board.com";
	}
}
