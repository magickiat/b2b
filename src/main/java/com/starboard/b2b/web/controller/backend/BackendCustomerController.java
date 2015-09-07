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
		model.addAttribute("customerForm", new CustomerForm());
		return "pages-back/customer/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	String submit(@ModelAttribute CustomerForm customerForm,Model model, BindingResult binding) {
		log.info("/gen_customer POST");
		customerService.add(customerForm);
		return search(model);
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	String edit(@RequestParam(value = "id", required = false) int id ,Model model) {
		Customer cus = customerService.findById(id);
		List<User> users = new ArrayList<User>();
		//System.out.println("########################"+cus.getUsers().size());
		users = userService.findUserByCusId(id);
		model.addAttribute("customerForm", cus);
		System.out.println("@@@@@@@@@@@@@@@@@"+users.size());
		model.addAttribute("users", users);
		return "pages-back/customer/edit";
	}
}
