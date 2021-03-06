package com.starboard.b2b.web.controller.system;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.SecurityService;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;

@Controller
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/gen_customer", method = RequestMethod.GET)
	String form(Model model) {
		log.info("/gen_customer GET");

		model.addAttribute("roles", securityService.listRole());
		model.addAttribute("customerForm", new CreateCustomerForm());
		return "system/gen_customer";
	}

	@RequestMapping(value = "/gen_customer", method = RequestMethod.POST)
	String submit(@Valid @ModelAttribute("customerForm") CreateCustomerForm customerForm, BindingResult binding)
			throws Exception {
		log.info("/gen_customer POST");
		if (!binding.hasErrors()) {
			customerService.add(customerForm);
		}
		return "redirect:/gen_customer";
	}
}
