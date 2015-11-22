package com.starboard.b2b.service.impl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starboard.b2b.common.MailConfig;
import com.starboard.b2b.service.ConfigService;
import com.starboard.b2b.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private ConfigService configService;

	@Override
	public void sendEmail(String from, String[] toAddresses, String[] ccAddresses, String[] bccAddresses, String subject, String content,
			String[] attachments) throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
		Boolean enableSendMail = configService.getBoolean(MailConfig.ENABLE_SEND_EMAIL);
		// Is disabled send email
		if(enableSendMail != null && !enableSendMail.booleanValue()){
			return;
		}
	}

}
