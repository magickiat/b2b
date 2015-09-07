package com.starboard.b2b.web.controller.backend;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.model.Customer;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.customer.CustomerForm;

@Controller
@RequestMapping("/backend/customer")
public class BackendCustomerController {
	private static final Logger log = LoggerFactory.getLogger(BackendCustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	String search(Model model) {
		model.addAttribute("customers",customerService.list());
		return "pages-back/customer/search";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	String form(Model model) {
		log.info("/create GET");
		model.addAttribute("customerForm", new CustomerForm());
		return "pages-back/customer/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	String submit(@ModelAttribute CustomerForm customerForm,Model model, BindingResult binding) {
		log.info("/create POST");
		customerService.add(customerForm);
		return search(model);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	String update(@RequestParam(value = "id", required = false) int id ,Model model) {
		log.info("/update GET");
		Customer cus = customerService.findById(id);
		List<User> users = new ArrayList<User>();
		users = userService.findUserByCusId(id);
		model.addAttribute("customerForm", cus);
		model.addAttribute("users", users);
		return "pages-back/customer/edit";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	String update(@ModelAttribute CustomerForm customerForm,Model model, BindingResult binding) {
		log.info("/update POST");
		customerService.update(customerForm);
		return update(customerForm.getId(),model);
	}
}
