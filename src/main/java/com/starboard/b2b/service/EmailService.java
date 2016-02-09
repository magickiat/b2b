package com.starboard.b2b.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.starboard.b2b.dto.OrderDTO;

public interface EmailService {
	void sendEmail(String from, String[] toAddresses, String[] ccAddresses, String[] bccAddresses, String subject, String content,
			String[] attachments) throws AddressException, MessagingException, IOException;

	public void sendEmailOrder(OrderDTO order) throws Exception;

	void sendEmailInternal(OrderDTO order) throws Exception;
}
