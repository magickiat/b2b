package com.starboard.b2b.web.controller.backend;

import java.util.Map;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starboard.b2b.dto.SearchProductEmailDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.EmailService;

@Controller
@RequestMapping("/backend/email")
public class BackendEmailController {

	private static final Logger log = LoggerFactory.getLogger(BackendEmailController.class);

	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.GET)
	String index(Model model) {
		Map<Long, SearchProductEmailDTO> emails = emailService.listProductEmail();
		log.info("product_type emails size: " + emails.size());
		model.addAttribute("listProductEmail", emails);
		return "pages-back/admin/email";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	String save(@RequestParam Long productTypeId, @RequestParam String email, @RequestParam String emailType) {
		log.info("save " + email + "\tProduct type id: " + productTypeId + "\tType: " + emailType);
		try {
			emailService.save(productTypeId, email, emailType);
			return null;
		} catch (B2BException e) {
			Log.error(e.getMessage());
			return e.getMessage();
		}
	}

}
