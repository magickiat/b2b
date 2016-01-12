package com.starboard.b2b.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.starboard.b2b.common.MailConfig;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.service.ConfigService;
import com.starboard.b2b.service.EmailService;
import com.starboard.b2b.service.OrderService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private ConfigService configService;

	@Autowired
	private Environment env;
	
	@Autowired
	private OrderService orderService;

	@Override
	public void sendEmail(String from, String[] toAddresses, String[] ccAddresses, String[] bccAddresses, String subject, String content,
			String[] attachments, String type, String orderNum) throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
		Boolean enableSendMail = configService.getBoolean(MailConfig.ENABLE_SEND_EMAIL);
		// Is disabled send email
		if (enableSendMail != null && !enableSendMail.booleanValue()) {
			return;
		} else {
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost(env.getProperty("email.host"));
			mailSender.setUsername(env.getProperty("email.username"));
			mailSender.setPassword(env.getProperty("email.password"));

			Properties props = new Properties();
			props.put("mail.smtp.host", env.getProperty("email.host"));
			props.put("mail.smtp.socketFactory.port", env.getProperty("email.port"));
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
			props.put("mail.smtp.port", env.getProperty("email.port"));
			mailSender.setJavaMailProperties(props);

			SimpleMailMessage message = new SimpleMailMessage();

			message.setFrom(from);
//			message.setTo(toAddresses);
			message.setCc(ccAddresses);
			message.setBcc(bccAddresses);
			message.setSubject(subject);
			// message.setTo("orders@star-board.com");

			VelocityEngine velocityEngine = new VelocityEngine();

			Template template = new Template();

			if ("approved".equals(type)) {
				message.setTo(toAddresses);
				message.setSubject("Order Acknowledgement RO-2015-0022 - Approved [Internal]");
				template = velocityEngine.getTemplate("/src/main/resources/templates/" + "approved.vm");
			} else if ("waitforapprove".equals(type)) {
				UserDTO userDTO = orderService.findUserByOrderCode(orderNum);
				message.setTo(userDTO.getEmail());
				message.setSubject("Order Acknowledgement  RO-2015-0022 - Wait for approve");
				template = velocityEngine.getTemplate("/src/main/resources/templates/" + "waitforapprove.vm");
			}

			// Path currentRelativePath = Paths.get("");
			// String s = currentRelativePath.toAbsolutePath().toString();
			// System.out.println("Current relative path
			// is--------------------------> " + s);

			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("order", orderNum);

			StringWriter stringWriter = new StringWriter();
			template.merge(velocityContext, stringWriter);
			message.setText(stringWriter.toString());
			mailSender.send(message);
		}
	}

}
