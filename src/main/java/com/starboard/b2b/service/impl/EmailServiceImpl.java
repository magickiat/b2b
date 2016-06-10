package com.starboard.b2b.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.EmailTemplateConfig;
import com.starboard.b2b.common.OrderStatusConfig;
import com.starboard.b2b.config.EmailType;
import com.starboard.b2b.dao.EmailTemplateDao;
import com.starboard.b2b.dao.ProductBrandGroupDAO;
import com.starboard.b2b.dao.ProductEmailDao;
import com.starboard.b2b.dao.UserDao;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.ProductEmailDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.SearchProductEmailDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.EmailTemplate;
import com.starboard.b2b.model.ProductEmail;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.EmailService;
import com.starboard.b2b.service.ReportService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.EmailUtils;
import com.starboard.b2b.util.UserUtil;

@Service("emailService")
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class EmailServiceImpl implements EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private ApplicationConfig applicationConfig;

	@Autowired
	private Environment env;

	@Autowired
	private EmailTemplateDao emailTemplateDao;

	@Autowired
	private ReportService reportService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductEmailDao productEmailDao;

	@Autowired
	private ProductBrandGroupDAO productBrandGroupDAO;

	// private void sendEmail(String from, String[] toAddresses, String[]
	// ccAddresses, String[] bccAddresses, String subject, String content,
	// String[] attachments) throws AddressException, MessagingException,
	// IOException {
	// boolean enableSendMail = applicationConfig.getEnabledSendMail();
	// // Is disabled send email
	// if (!enableSendMail) {
	// return;
	// }
	//
	// SimpleMailMessage message = new SimpleMailMessage();
	// message.setFrom(from);
	// message.setTo(toAddresses);
	// message.setCc(ccAddresses);
	// message.setBcc(bccAddresses);
	// message.setSubject(subject);
	//
	// VelocityEngine ve = new VelocityEngine();
	// ve.init();
	//
	// JavaMailSenderImpl sender = getMailSender();
	// sender.send(message);
	// }

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
	public void sendEmailOrderToCustomer(OrderDTO order, String host) throws Exception {
		log.info("send Email Order To Customer");

		// ----- get customer user email -----

		String custEmail = getCustomerEmail(order);
		if (StringUtils.isEmpty(custEmail)) {
			log.warn("Customer email is required.");
			return;
		}

		// Notification when new order
		EmailTemplate template = emailTemplateDao.getTemplate(order.getOrderStatus());
		if (template == null) {
			throw new B2BException("Not found email template: " + order.getOrderStatus());
		}

		// ----- If order status = wait_for_approve, set url for approve ----
		if (!host.endsWith("/")) {
			host += "/";
		}
		String url = host + "frontend/order/summary/report/" + order.getOrderId();
		log.info("URL: " + url);

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
		log.info("---> From: " + from);
		String[] to = EmailUtils.split(custEmail);
		log.info("---> To: " + to[0]);
		String[] cc = applicationConfig.getMailCCApprover();
		String[] bcc = applicationConfig.getMailBCCApprover();
		String subject = outputSubject.toString();
		String body = outputBody.toString();
		String attachFilename = order.getOrderCode() + ".pdf";

		sendEmail(from, to, cc, bcc, subject, body, report, attachFilename);
	}

	private String getCustomerEmail(OrderDTO order) {
		User user = userDao.findByUsername(order.getUserCreate());
		if (user == null) {
			throw new B2BException("Cannot found user: " + order.getUserCreate());
		}
		return user.getEmail();
	}

	@Override
	@Transactional(readOnly = true)
	public void sendEmailOrderToStaff(OrderDTO order, String host) throws Exception {
		log.info("sendEmailOrderToStaff");

		// Notification when new order
		log.info("find email with brand_group_id = " + order.getBrandGroupId());
		List<ProductEmail> staffEmailTo = productEmailDao.findByBrandGroupId(order.getBrandGroupId(), EmailType.TO);
		if (staffEmailTo == null || staffEmailTo.isEmpty()) {
			log.warn("Not found any staff email");
			return;
		}

		String emailTemplateId = order.getOrderStatus();

		if (OrderStatusConfig.WAIT_FOR_APPROVE.equals(order.getOrderStatus())) {
			emailTemplateId = EmailTemplateConfig.TEMPLATE_NEW_ORDER_FOR_SALE;
		}

		EmailTemplate template = emailTemplateDao.getTemplate(emailTemplateId);
		if (template == null) {
			throw new B2BException("Not found email template: " + emailTemplateId);
		}

		// ----- If order status = wait_for_approve, set url for approve ----
		if (!host.endsWith("/")) {
			host += "/";
		}
		String url = host + "backend/order/view?orderId=" + order.getOrderId();
		log.info("URL: " + url);
		// ----- gen pdf report -----
		byte[] report = reportService.generateRoPDF(order.getOrderId());

		// ----- evaluate email template -----
		StringWriter outputSubject = new StringWriter();
		StringWriter outputBody = new StringWriter();

		VelocityContext contextMsg = new VelocityContext();
		contextMsg.put("order", order);
		contextMsg.put("serverPath", url);// ตรวจสอบว่า template ถูกหรือไม่

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
		ve.setProperty("runtime.log.logsystem.log4j.logger", "velocity");
		ve.init();

		ve.evaluate(contextMsg, outputSubject, "emailMessage", template.getSubject());
		ve.evaluate(contextMsg, outputBody, "emailMessage", template.getBody());

		String from = applicationConfig.getMailFrom(); // Overrided to account
		String[] emailTo = EmailUtils.groupEmail(staffEmailTo);
		String[] emailCC = EmailUtils.groupEmail(productEmailDao.findByBrandGroupId(order.getBrandGroupId(), EmailType.CC));

		log.info("---> From: " + from);
		log.info("---> To[0]: " + emailTo[0]);
		String[] bcc = null;
		String subject = outputSubject.toString();
		String body = outputBody.toString();
		String attachFilename = order.getOrderCode() + ".pdf";

		sendEmail(from, emailTo, emailCC, bcc, subject, body, report, attachFilename);
	}

	private Properties getMailProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", env.getProperty("email.host"));
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

	@Override
	@Transactional
	public Map<Long, SearchProductEmailDTO> listProductEmail() {
		TreeMap<Long, SearchProductEmailDTO> emails = new TreeMap<>();

		List<ProductTypeDTO> productTypes = productBrandGroupDAO.list();

		for (ProductTypeDTO productType : productTypes) {
			SearchProductEmailDTO dto = new SearchProductEmailDTO();
			dto.setProductType(productType);
			emails.put(productType.getBrandGroupId(), dto);
		}

		List<ProductEmailDTO> list = productEmailDao.findAll();
		if (list != null) {
			log.info("load emails size: " + list.size());
		} else {
			log.warn("not found any email");
		}
		for (ProductEmailDTO productEmailDTO : list) {
			SearchProductEmailDTO emailDTO = emails.get(productEmailDTO.getBrandGroupId());
			if (emailDTO != null) {
				List<ProductEmailDTO> productEmailList = emailDTO.getEmails();
				if (productEmailList == null) {
					productEmailList = new ArrayList<>();
					emailDTO.setEmails(productEmailList);
				}
				productEmailList.add(productEmailDTO);
			} else {
				log.warn("Not found product type for " + productEmailDTO);
			}
		}
		log.info("emails = " + emails);
		return emails;
	}

	@Override
	@Transactional
	public void save(Long brandGroupId, String email, String emailType) {
		ProductEmailDTO emailInDb = productEmailDao.find(brandGroupId, email, emailType);
		if (emailInDb != null) {
			throw new B2BException("Duplicate email");
		}
		ProductEmail productEmail = new ProductEmail();
		productEmail.setBrandGroupId(brandGroupId);
		productEmail.setEmail(email);
		productEmail.setEmailType(emailType);
		productEmail.setUserCreate(UserUtil.getCurrentUsername());
		productEmail.setTimeCreate(DateTimeUtil.getCurrentDate());
		productEmailDao.save(productEmail);
	}

	@Override
	@Transactional
	public int deleteByEmailId(Long id) {
		return productEmailDao.deleteById(id);
	}

}
