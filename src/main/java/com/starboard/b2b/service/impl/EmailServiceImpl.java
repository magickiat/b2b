package com.starboard.b2b.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.starboard.b2b.dao.EmailTemplateDao;
import com.starboard.b2b.dto.EmailTemplateDTO;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.UserDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.EmailTemplate;
import com.starboard.b2b.service.EmailService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.util.ApplicationConfig;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private ApplicationConfig applicationConfig;

	@Autowired
	private Environment env;

	@Autowired
	private OrderService orderService;

	@Autowired
	private EmailTemplateDao emailTemplateDao;

	

	@Override
	public void sendEmail(String from, String[] toAddresses, String[] ccAddresses, String[] bccAddresses, String subject, String content,
			String[] attachments) throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
		boolean enableSendMail = applicationConfig.getEnabledSendMail();
		// Is disabled send email
		if (!enableSendMail) {
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
			// message.setTo(toAddresses);
			message.setCc(ccAddresses);
			message.setBcc(bccAddresses);
			message.setSubject(subject);
			// message.setTo("orders@star-board.com");

			VelocityEngine velocityEngine = new VelocityEngine();

			Template template = new Template();

//			if ("approved".equals(type)) {
//				message.setTo(toAddresses);
//				message.setSubject("Order Acknowledgement RO-2015-0022 - Approved [Internal]");
//				template = velocityEngine.getTemplate("/src/main/resources/templates/" + "approved.vm");
//			} else if ("waitforapprove".equals(type)) {
//				UserDTO userDTO = orderService.findUserByOrderCode(orderNum);
//				message.setTo(userDTO.getEmail());
//				message.setSubject("Order Acknowledgement  RO-2015-0022 - Wait for approve");
//				template = velocityEngine.getTemplate("/src/main/resources/templates/" + "waitforapprove.vm");
//			}

			// Path currentRelativePath = Paths.get("");
			// String s = currentRelativePath.toAbsolutePath().toString();
			// System.out.println("Current relative path
			// is--------------------------> " + s);

//			VelocityContext velocityContext = new VelocityContext();
//			velocityContext.put("order", orderNum);
//
//			StringWriter stringWriter = new StringWriter();
//			template.merge(velocityContext, stringWriter);
//			message.setText(stringWriter.toString());
			mailSender.send(message);
		}
	}

	@Override
	public void sendEmailOrder(OrderDTO order) throws Exception {
		if(order == null){
			throw new B2BException("Order is required");
		}
		if(StringUtils.isEmpty(order.getOrderStatus())){
			throw new B2BException("Invalid order status");
		}
		
		
	}

}
