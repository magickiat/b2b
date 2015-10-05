package com.starboard.b2b.web.controller.backend;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.BrandService;
import com.starboard.b2b.service.ConfigService;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.util.PagingUtil;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;
import com.starboard.b2b.web.form.customer.CustomerForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Controller
@RequestMapping("/backend/customer")
public class BackendCustomerController {
	private static final Logger log = LoggerFactory.getLogger(BackendCustomerController.class);

	@Autowired
	private ConfigService configService;

	@Autowired
	private PagingUtil pagingUtil;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	String search(@RequestParam(value = "page", required = false) Integer page, Model model) throws Exception {
		model.addAttribute("resultPage", customerService.listCust(page));
		return "pages-back/customer/search";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	String createCustForm(Model model) {
		log.info("/create GET");
		model.addAttribute("customerForm", new CreateCustomerForm());
		return "pages-back/customer/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	String createCustomerSubmit(@ModelAttribute("customerForm") @Valid CreateCustomerForm customerForm,
			BindingResult binding, Model model) throws Exception {
		log.info("/create POST");
		log.warn("binding error: " + binding.hasErrors());
		model.addAttribute("customerForm", customerForm);

		if (binding.hasErrors()) {
			return "pages-back/customer/create";
		}

		customerService.add(customerForm);
		return search(0, model);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	String update(@RequestParam(value = "id", required = true) Long id, Model model) throws Exception {
		log.info("/update GET");
		log.info("id = " + id);

		CustDTO custDto = new CustDTO();
		List<User> users = new ArrayList<User>();
		custDto = customerService.findCustById(id);

		if (custDto != null) {
			users = userService.findUserByCustId(id);
		}

		model.addAttribute("customerForm", custDto);
		model.addAttribute("users", users);
		model.addAttribute("selectedBrand", customerService.getSelectedBrand(id));
		return "pages-back/customer/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	String update(@ModelAttribute @Valid CustomerForm customerForm, BindingResult binding, RedirectAttributes attr,
			Model model) throws Exception {
		log.info("/update POST");
		log.info("customer id: " + customerForm.getCustId());
		if (binding.hasErrors()) {
			attr.addFlashAttribute("msg", "Hello");
			return "redirect:update?id=" + customerForm.getCustId();
		}
		customerService.update(customerForm);
		return update(customerForm.getCustId(), model);
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	String createUser(@RequestParam(value = "custId", required = true) Long custId, Model model) {
		log.info("/createuser GET");
		UserRegisterForm form = new UserRegisterForm();
		form.setCusId(custId);
		model.addAttribute("registerForm", form);
		return "pages-back/customer/createCustomerUser";
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	String createUser(@ModelAttribute @Valid UserRegisterForm registerForm, BindingResult binding, Model model)
			throws Exception {
		log.info("/gen_user POST");
		if (!binding.hasErrors()) {
			if (!userService.isExistUsername(registerForm.getUsername())) {
				userService.add(registerForm);
				return update(registerForm.getCusId(), model);
			} else {
				model.addAttribute("errorMsg", "Exist username: " + registerForm.getUsername());
			}

		}
		model.addAttribute("registerForm", registerForm);
		return "pages-back/customer/createCustomerUser";
	}

	@RequestMapping(value = "/add_brand", method = RequestMethod.GET)
	String addBrandForm(@RequestParam(value = "id", required = true) Long id, Model model) throws Exception {
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
	String addBrandSubmit(@ModelAttribute BrandForm brandForm, Model model) throws Exception {
		log.info("/add_brand POST");
		log.info("Selected brand id: " + brandForm);
		customerService.addBrand(brandForm);
		return update(brandForm.getCustId(), model);
	}
}
