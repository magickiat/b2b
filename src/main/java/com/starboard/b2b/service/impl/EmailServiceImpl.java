package com.starboard.b2b.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.OrderStatusConfig;
import com.starboard.b2b.dao.BrandGroupDao;
import com.starboard.b2b.dao.EmailTemplateDao;
import com.starboard.b2b.dao.OrderDetailDao;
import com.starboard.b2b.dao.ProductDao;
import com.starboard.b2b.dao.ProductSoCategoryDao;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailReportResult;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.model.BrandGroup;
import com.starboard.b2b.model.EmailTemplate;
import com.starboard.b2b.model.Product;
import com.starboard.b2b.model.ProductSoCategory;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.EmailService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.B2BFileUtil;
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

	private static final String MAIL_SEPARATOR = ";|,| ";

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

			// if ("approved".equals(type)) {
			// message.setTo(toAddresses);
			// message.setSubject("Order Acknowledgement RO-2015-0022 - Approved
			// [Internal]");
			// template =
			// velocityEngine.getTemplate("/src/main/resources/templates/" +
			// "approved.vm");
			// } else if ("waitforapprove".equals(type)) {
			// UserDTO userDTO = orderService.findUserByOrderCode(orderNum);
			// message.setTo(userDTO.getEmail());
			// message.setSubject("Order Acknowledgement RO-2015-0022 - Wait for
			// approve");
			// template =
			// velocityEngine.getTemplate("/src/main/resources/templates/" +
			// "waitforapprove.vm");
			// }

			// Path currentRelativePath = Paths.get("");
			// String s = currentRelativePath.toAbsolutePath().toString();
			// System.out.println("Current relative path
			// is--------------------------> " + s);

			// VelocityContext velocityContext = new VelocityContext();
			// velocityContext.put("order", orderNum);
			//
			// StringWriter stringWriter = new StringWriter();
			// template.merge(velocityContext, stringWriter);
			// message.setText(stringWriter.toString());
			mailSender.send(message);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public void sendEmailOrder(OrderDTO order) throws Exception {
		if (order == null) {
			throw new B2BException("Order is required");
		}
		if (StringUtils.isEmpty(order.getOrderStatus())) {
			throw new B2BException("Invalid order status");
		}

		// ----- Send mail to user -----
		// Get email_to
		User currentUser = UserUtil.getCurrentUser();
		if (StringUtils.isEmpty(currentUser.getEmail())) {
			throw new B2BException("Not found email in User: " + currentUser.getName() + "  company: " + currentUser.getCustomer().getNameEn());
		}
		List<String> userEmails = splitEmails(currentUser.getEmail());

		// Template
		EmailTemplate userTemplate = emailTemplateDao.getTemplate(order.getOrderStatus());

		if (userTemplate == null) {
			throw new B2BException("Not found email template for send to user");
		}
		// TODO Use emails and template to send email
		// --------------- userEmails, userTemplate ---------------

		// ----- Send mail to Sale
		if (OrderStatusConfig.WAIT_FOR_APPROVE.equals(order.getOrderStatus())) {
			BrandGroup brandGroup = brandGroupDao.findById(order.getBrandGroupId());
			if (brandGroup == null) {
				throw new B2BException("Not found brand group: " + order.getBrandGroupId());
			}

			String email = brandGroup.getBrandGroupDescription();
			List<String> saleEmails = splitEmails(email);

			if (saleEmails.isEmpty()) {
				throw new B2BException("Not found email in Brand group: " + order.getBrandGroupId());
			}

			// Template
			EmailTemplate saleTemplate = emailTemplateDao.getTemplate(B2BConstant.EMAIL_TEMPLATE_NEW_ORDER_TO_SALE);
			if (saleTemplate == null) {
				throw new B2BException("Not found email template for send to Sale");
			}

			// TODO Use emails and template to send email
			// --------------- saleEmails, saleTemplate ---------------
		}
	}

	public List<String> splitEmails(String email) {
		List<String> emails = new ArrayList<>();
		if (email != null) {
			String[] split = email.split(MAIL_SEPARATOR);
			if (split != null && split.length > 0) {
				for (String string : split) {
					emails.add(string);
				}
			}
		}
		return emails;
	}

	@Override
	@Transactional(readOnly = true)
	public void sendEmailInternal(OrderDTO order) throws Exception {
		if (order == null) {
			throw new B2BException("Order is required");
		}
		if (StringUtils.isEmpty(order.getOrderStatus())) {
			throw new B2BException("Invalid order status");
		}

		// find S/O Category email
		Set<String> soCategoryEmails = findSoCategoryEmail(order);

		if (!soCategoryEmails.isEmpty()) {

			// Template
			EmailTemplate saleTemplate = emailTemplateDao.getTemplate(B2BConstant.EMAIL_TEMPLATE_NEW_ORDER_TO_SALE);
			if (saleTemplate == null) {
				throw new B2BException("Not found email template for send to Sale");
			}

			// ----- generate excel order for attach to S/O category's email
			Long[] orderId = new Long[] { order.getOrderId() };
			HSSFWorkbook excelOrder = B2BFileUtil.createExcelOrder(orderId, orderService);

			// TODO 1) send email with attach file
			// ----- Loop soCategoryEmails and send excel attach per email
			for (String email : soCategoryEmails) {
				List<String> emails = splitEmails(email);
				
				// TODO Use emails and template to send email
				// --------------- emails, saleTemplate, excelOrder ---------------
			}

			// TODO 2) delete excel file if need to create file for attach
		}

	}

	public Set<String> findSoCategoryEmail(OrderDTO order) {
		Set<String> emails = new HashSet<>();

		List<SearchOrderDetailReportResult> list = orderDetailDao.findOrderDetailByOrderId(order.getOrderId());
		if (list != null && !list.isEmpty()) {
			for (SearchOrderDetailReportResult ordDetail : list) {
				Product product = productDao.findById(ordDetail.getProductId());
				if (product != null) {
					ProductSoCategory soCategory = productSoCategoryDao.findById(product.getSoCategory());
					if (soCategory != null) {
						if (StringUtils.isNotEmpty(soCategory.getEmail())) {
							emails.add(soCategory.getEmail());
						} else {
							log.warn("Not found email for so_category: " + product.getSoCategory());
						}
					} else {
						log.warn("Not found so_category: " + product.getSoCategory());
					}

				}
			}
		}
		return emails;
	}

}
