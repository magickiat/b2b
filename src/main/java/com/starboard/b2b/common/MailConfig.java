package com.starboard.b2b.common;

public interface MailConfig {
	// ----- Email Host -----
	String EMAIL_HOST = "email.host";
	String EMAIL_PORT = "email.port";
	String EMAIL_USERNAME = "email.username";
	String EMAIL_PASSWORD = "email.password";

	// ----- Global config -----
	String ENABLE_SEND_EMAIL = "email.enable";
	
	String EMAIL_FROM = "email.from";
	String EMAIL_TO = "email.to";
	String EMAIL_CC = "email.cc";
	String EMAIL_BCC = "email.bcc";

	// ----- RO -----
	String EMAIL_RO_FROM = "email.ro.from";
	String EMAIL_RO_TO = "email.ro.to";
	String EMAIL_RO_CC = "email.ro.cc";
	String EMAIL_RO_BCC = "email.ro.bcc";
	String EMAIL_RO_SUBJECT = "email.ro.subject";

}
