package com.starboard.b2b.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {
	void sendEmail(String from, String[] toAddresses, String[] ccAddresses, String[] bccAddresses, String subject, String content,
			String[] attachments) throws AddressException, MessagingException, IOException;
}
