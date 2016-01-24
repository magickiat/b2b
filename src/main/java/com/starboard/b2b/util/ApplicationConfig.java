package com.starboard.b2b.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

	@Value("${page.size}")
	private int pageSize;

	@Value("${order.status.new}")
	private String orderStatusNew;

	@Value("${default.new.order.payment.term.id}")
	private String defaultPaymentTermId;

	@Value("${default.product.currency}")
	private String defaultProductCurrency;

	@Value("${default.product.unit}")
	private String defaultProductUnit;

	@Value("${enabled.send.mail}")
	private boolean enableSendMail;

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
}
