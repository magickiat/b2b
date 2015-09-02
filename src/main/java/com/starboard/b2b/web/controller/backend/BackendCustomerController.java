package com.starboard.b2b.web.controller.backend;

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
import com.starboard.b2b.web.form.customer.CustomerForm;

@Controller
@RequestMapping("/backend/customer")
public class BackendCustomerController {
	private static final Logger log = LoggerFactory.getLogger(BackendCustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	String search(Model model) {
		model.addAttribute("customers",customerService.list());
		return "pages-back/customer/search";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	String form(Model model) {
		model.addAttribute("customerForm", new CustomerForm());
		return "pages-back/customer/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	String submit(@ModelAttribute CustomerForm customerForm,Model model, BindingResult binding) {
		log.info("/gen_customer POST");
		customerService.add(customerForm);
		return search(model);
	}
}
