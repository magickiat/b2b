package com.starboard.b2b.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.EmailTemplateConfig;
import com.starboard.b2b.common.OrderStatusConfig;
import com.starboard.b2b.dao.BrandGroupDao;
import com.starboard.b2b.dao.EmailStaffDao;
import com.starboard.b2b.dao.EmailTemplateDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.ProductSoCategoryDao;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.EmailTemplate;
import com.starboard.b2b.service.EmailService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ReportService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.EmailUtils;
import com.starboard.b2b.util.UserUtil;

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
	private OrderDetailDao orderDetailDao;

	@Autowired
	private EmailTemplateDao emailTemplateDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductSoCategoryDao productSoCategoryDao;

	@Autowired
	private BrandGroupDao brandGroupDao;

	@Autowired
	private EmailStaffDao emailStaffDao;

	@Autowired
	private ReportService reportService;

	private void sendEmail(String from, String[] toAddresses, String[] ccAddresses, String[] bccAddresses, String subject, String content,
			String[] attachments) throws AddressException, MessagingException, IOException {
		boolean enableSendMail = applicationConfig.getEnabledSendMail();
		// Is disabled send email
		if (!enableSendMail) {
			return;
		}

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(toAddresses);
		message.setCc(ccAddresses);
		message.setBcc(bccAddresses);
		message.setSubject(subject);

		VelocityEngine ve = new VelocityEngine();
		ve.init();

		JavaMailSenderImpl sender = getMailSender();
		sender.send(message);
	}

	private void sendEmail(String from, String[] toAddresses, String[] ccAddresses, String[] bccAddresses, String subject, String content,
			byte[] attachments, String attachFilename) throws AddressException, MessagingException, IOException {
		boolean enableSendMail = applicationConfig.getEnabledSendMail();
		// Is disabled send email
		if (!enableSendMail) {
			log.info("Disabled sending email. If you want to send mail, please enable it");
			return;
		}

		if (StringUtils.isEmpty(from)) {
			throw new B2BException("Email from is required");
		}
		if (toAddresses == null || toAddresses.length == 0) {
			throw new B2BException("Email to is required");
		}

		JavaMailSenderImpl sender = getMailSender();
		MimeMessage message = sender.createMimeMessage();
		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setFrom(from);
		helper.setTo(toAddresses);
		if (ccAddresses != null && ccAddresses.length > 0) {
			helper.setCc(ccAddresses);
		}
		if (bccAddresses != null && bccAddresses.length > 0) {
			helper.setBcc(bccAddresses);
		}
		helper.setSubject(subject);
		if (attachments != null && attachments.length > 0) {
			helper.addAttachment(attachFilename, new ByteArrayResource(attachments));
		}

		helper.setText(content, true);

		sender.send(message);
		log.info("send mail complete");
	}

	@Override
	@Transactional(readOnly = true)
	public void sendEmailOrderToCustomer(OrderDTO order) throws Exception {
		log.info("send Email Order To Customer");

		// ----- get customer user email -----
		String custEmail = UserUtil.getCurrentUser().getEmail();
		if (StringUtils.isEmpty(custEmail)) {
			return;
		}

		// Notification when new order
		EmailTemplate template = emailTemplateDao.getTemplate(order.getOrderStatus());
		if (template == null) {
			throw new B2BException("Not found email template: " + order.getOrderStatus());
		}

		// ----- gen pdf report -----
		byte[] report = reportService.generateRoPDF(order.getOrderId());

		// ----- evaluate email template -----
		StringWriter outputSubject = new StringWriter();
		StringWriter outputBody = new StringWriter();

		VelocityContext contextMsg = new VelocityContext();
		contextMsg.put("order", order);

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
		ve.setProperty("runtime.log.logsystem.log4j.logger", "velocity");
		ve.init();

		ve.evaluate(contextMsg, outputSubject, "emailMessage", template.getSubject());
		ve.evaluate(contextMsg, outputBody, "emailMessage", template.getBody());

		String from = applicationConfig.getMailFrom(); // Overrided to account
														// loged in at runtime
		String[] to = EmailUtils.split(custEmail);
		String[] cc = applicationConfig.getMailCCApprover();
		String[] bcc = applicationConfig.getMailBCCApprover();
		String subject = outputSubject.toString();
		String body = outputBody.toString();
		String attachFilename = order.getOrderCode() + ".pdf";

		log.info("email to: " + to.length);
		log.info("mail: " + to[0]);
		sendEmail(from, to, cc, bcc, subject, body, report, attachFilename);
	}

	@Override
	@Transactional(readOnly = true)
	public void sendEmailOrderToStaff(OrderDTO order, String host) throws Exception {
		log.info("sendEmailOrderToStaff");

		// Notification when new order
		String emailTemplateId = order.getOrderStatus();
		if (order.getOrderStatus() == OrderStatusConfig.WAIT_FOR_APPROVE) {
			emailTemplateId = EmailTemplateConfig.TEMPLATE_NEW_ORDER_FOR_SALE;
		}

		EmailTemplate template = emailTemplateDao.getTemplate(emailTemplateId);
		if (template == null) {
			throw new B2BException("Not found email template: " + emailTemplateId);
		}

		// ----- If order status = wait_for_approve, set url for approve ----
		String url = host + "/backend/order/view?orderId=" + order.getOrderId();

		// ----- gen pdf report -----
		byte[] report = reportService.generateRoPDF(order.getOrderId());

		// ----- evaluate email template -----
		StringWriter outputSubject = new StringWriter();
		StringWriter outputBody = new StringWriter();

		VelocityContext contextMsg = new VelocityContext();
		contextMsg.put("order", order);
		contextMsg.put("serverPath", url);

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
		ve.setProperty("runtime.log.logsystem.log4j.logger", "velocity");
		ve.init();

		ve.evaluate(contextMsg, outputSubject, "emailMessage", template.getSubject());
		ve.evaluate(contextMsg, outputBody, "emailMessage", template.getBody());

		String from = applicationConfig.getMailFrom(); // Overrided to account
														// loged in at runtime
		String[] to = applicationConfig.getMailApprover();
		String[] cc = applicationConfig.getMailCCApprover();
		String[] bcc = applicationConfig.getMailBCCApprover();
		String subject = outputSubject.toString();
		String body = outputBody.toString();
		String attachFilename = order.getOrderCode() + ".pdf";

		sendEmail(from, to, cc, bcc, subject, body, report, attachFilename);
	}

	private Properties getMailProperties() {
		Properties props = new Properties();

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		return props;
	}

	private JavaMailSenderImpl getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(env.getProperty("email.host"));
		mailSender.setPort(Integer.parseInt(env.getProperty("email.port")));
		mailSender.setUsername(env.getProperty("email.username"));
		mailSender.setPassword(env.getProperty("email.password"));
		mailSender.setJavaMailProperties(getMailProperties());
		return mailSender;
	}
}
