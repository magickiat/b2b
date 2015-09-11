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
import com.starboard.b2b.service.BrandService;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CustomerForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Controller
@RequestMapping("/backend/customer")
public class BackendCustomerController {
	private static final Logger log = LoggerFactory.getLogger(BackendCustomerController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	String search(Model model) throws Exception {
		model.addAttribute("customers", customerService.list());
		return "pages-back/customer/search";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	String form(Model model) {
		log.info("/create GET");
		model.addAttribute("customerForm", new CustomerForm());
		return "pages-back/customer/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	String submit(@ModelAttribute CustomerForm customerForm, Model model, BindingResult binding) throws Exception {
		log.info("/create POST");
		customerService.add(customerForm);
		return search(model);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	String update(@RequestParam(value = "id", required = false) Integer id, Model model) throws Exception {
		log.info("/update GET");
		Customer cust = customerService.findById(id);
		List<User> users = new ArrayList<User>();
		if (cust != null) {
			users = userService.findUserByCustId(id);
		}
		
		model.addAttribute("customerForm", cust);
		model.addAttribute("users", users);
		model.addAttribute("selectedBrand", customerService.getSelectedBrand(cust.getId()));
		return "pages-back/customer/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	String update(@ModelAttribute CustomerForm customerForm, Model model, BindingResult binding) throws Exception {
		log.info("/update POST");
		customerService.update(customerForm);
		return update(customerForm.getId(), model);
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	String createuser(@RequestParam(value = "id", required = true) Integer id, Model model) {
		log.info("/createuser GET");
		UserRegisterForm form = new UserRegisterForm();
		form.setCusId(id);
		model.addAttribute("registerForm", form);
		return "pages-back/customer/createCustomerUser";
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	String createuser(@ModelAttribute UserRegisterForm registerForm, Model model, BindingResult binding)
			throws Exception {
		log.info("/gen_user POST");
		userService.add(registerForm);
		return update(registerForm.getCusId(), model);
	}

	@RequestMapping(value = "/add_brand", method = RequestMethod.GET)
	String addBrandForm(@RequestParam(value = "id", required = true) Integer id, Model model) throws Exception {
		log.info("/add_brand GET");

		log.info("Customer ID: " + id);

		BrandForm form = new BrandForm();
		form.setCustId(id);
		form.setSelectedBrand(customerService.getSelectedBrandId(form.getCustId()));

		model.addAttribute("brandForm", form);
		model.addAttribute("brands", brandService.list());
		return "pages-back/customer/add_brand";
	}

	@RequestMapping(value = "/add_brand", method = RequestMethod.POST)
	String addBrandSubmit(@ModelAttribute BrandForm brandForm, Model model, BindingResult binding) throws Exception {
		log.info("/add_brand POST");
		log.info("Selected brand id: " + brandForm);
		customerService.addBrand(brandForm);
		return update(brandForm.getCustId(), model);
	}
}
