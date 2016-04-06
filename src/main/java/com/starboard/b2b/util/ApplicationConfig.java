package com.starboard.b2b.util;

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

	@Value("${page.size}")
	private int pageSize;
	
	@Value("${enabled.send.mail}")
	private boolean enableSendMail;

	@Value("${order.status.new}")
	private String orderStatusNew;

	@Value("${default.new.order.payment.term.id}")
	private String defaultPaymentTermId;

	@Value("${default.product.currency}")
	private String defaultProductCurrency;

	@Value("${default.product.unit}")
	private String defaultProductUnit;

	@Value("${default.order.currency}")
	private String defaultCurrencyNewOrder;

	@Value("${default.product.buyer.group}")
	private String defaultProductBuyerGroup;

	@Value("${email.sales}")
	private String emailSales;

	@Value("${default.product.length}")
	private String defaultProductLength;

	public int getPageSize() {
		return pageSize;
	}

	public boolean getEnabledSendMail() {
		return enableSendMail;
	}

	public String getOrderStatusNew() {
		return orderStatusNew;
	}

	public String getNewOrderPaymentTermId() {
		return defaultPaymentTermId;
	}

	public String getDefaultProductCurrency() {
		return defaultProductCurrency;
	}

	public String getDefaultProductUnit() {
		return defaultProductUnit;
	}

	public String getDefaultProductBuyerGroup() {
		return defaultProductBuyerGroup;
	}

	public Long getDefaultOrderDetailStatus() {
		return 0L;
	}

	public String getDefaultProductLength() {
		return defaultProductLength;
	}

	public String[] getMailApprover() {
		return EmailUtils.split(emailSales);
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

	public String getDefaultCurrencyForOrder() {
		return defaultCurrencyNewOrder;
	}
}
