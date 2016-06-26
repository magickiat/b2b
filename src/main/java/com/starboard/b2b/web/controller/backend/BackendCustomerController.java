package com.starboard.b2b.web.controller.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.CustBrandGroupDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.model.ProductType;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.CountryService;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.address.AddressForm;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.contact.ContactForm;
import com.starboard.b2b.web.form.customer.CreateCustomerForm;
import com.starboard.b2b.web.form.customer.SearchCustomerForm;
import com.starboard.b2b.web.form.user.UserForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Controller
@RequestMapping("/backend/customer")
public class BackendCustomerController {
	private static final Logger log = LoggerFactory.getLogger(BackendCustomerController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private UserService userService;

	@Autowired
	private CountryService countryService;

	@RequestMapping(method = RequestMethod.GET)
	String search(Model model) throws Exception {

		SearchCustomerForm form = new SearchCustomerForm();
		return search(form, model);
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	String search(@ModelAttribute("searchForm") SearchCustomerForm searchForm, Model model) {
		searchForm.setCountryList(countryService.findAll());
		searchForm.setProductTypeList(productService.findAllProductType());

		model.addAttribute("searchForm", searchForm);
		model.addAttribute("resultPage", customerService.listCust(searchForm));

		return "pages-back/customer/search";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	String createCustForm(Model model) {
		log.info("/create GET");
		model.addAttribute("customerForm", new CreateCustomerForm());
		return "pages-back/customer/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	String createCustomerSubmit(@ModelAttribute("customerForm") @Valid CreateCustomerForm customerForm, BindingResult binding, Model model)
			throws Exception {
		log.info("/create POST");

		model.addAttribute("customerForm", customerForm);

		if (binding.hasErrors()) {
			log.warn("binding error: " + binding.hasErrors());
			return "pages-back/customer/create";
		}
		if (customerService.isExistCustomerCode(customerForm.getCode())) {
			model.addAttribute("errorMsg", "Duplicate cutomer code");
			return "pages-back/customer/create";
		}

		customerService.add(customerForm);
		return search(new SearchCustomerForm(), model);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	String update(@RequestParam(value = "id", required = true) Long id, Model model) throws Exception {
		log.info("/update GET");
		log.info("id = " + id);

		List<User> users = new ArrayList<User>();
		List<AddressDTO> listAddress = customerService.findAddressByCustomerId(id);
		List<ContactDTO> listContact = customerService.findContactByCustomerId(id);
		List<CountryDTO> listCountry = customerService.listCountry();

		CustDTO custDto = customerService.findCustById(id);
		if (custDto != null) {
			users = userService.findUserByCustId(id);
		}

		ContactForm contactForm = new ContactForm();
		AddressForm addrFrom = new AddressForm();
		model.addAttribute("customerForm", custDto);
		model.addAttribute("users", users);
		model.addAttribute("selectedBrand", productService.getProductTypes(id));
		model.addAttribute("listAddr", listAddress);
		model.addAttribute("addressTypes", getAddressConstant());
		model.addAttribute("listMobileType", customerService.getMobileType());
		model.addAttribute("country", listCountry);
		model.addAttribute("addressForm", addrFrom);
		model.addAttribute("contactForm", contactForm);
		model.addAttribute("listContact", listContact);
		return "pages-back/customer/edit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	String update(@ModelAttribute("customerForm") @Valid CustDTO customerForm, BindingResult binding, RedirectAttributes attr, Model model)
			throws Exception {
		log.info("/update POST");
		log.info("customer id: " + customerForm.getCustId());
		if (binding.hasErrors()) {
			return "pages-back/customer/edit";
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
	String createUser(@ModelAttribute("registerForm") @Valid UserRegisterForm registerForm, BindingResult binding, Model model) throws Exception {
		log.info("/gen_user POST");
		if (!binding.hasErrors()) {
			if (!userService.isExistUsername(registerForm.getUsername())) {
				userService.add(registerForm);
				return update(registerForm.getCusId(), model);
			} else {
				model.addAttribute("errorMsg", "Exist username: " + registerForm.getUsername());
			}

		}

		return "pages-back/customer/createCustomerUser";
	}

	@RequestMapping(value = "/add_brand", method = RequestMethod.GET)
	String addBrandForm(@RequestParam(value = "id", required = true) Long id, Model model) throws Exception {
		log.info("/add_brand GET");
		log.info("Customer ID: " + id);

		BrandForm form = new BrandForm();
		form.setCustId(id);
		//
		List<CustBrandGroupDTO> listCust = customerService.getCustBrandGroupById(id);
		String listProductTypeId = "";
		if (null != listCust) {
			for (CustBrandGroupDTO custDTO : listCust) {
				listProductTypeId = listProductTypeId + ":" + custDTO.getProductTypeId();
			}
		}
		List<Integer> selectBrand = new ArrayList<Integer>();
		List<ProductType> listProductType = customerService.getProductType();
		if (listCust != null && listProductType != null) {
			for (ProductType product : listProductType) {
				if (listProductTypeId.indexOf(String.valueOf(product.getProductTypeId())) != -1) {
					selectBrand.add((int) product.getProductTypeId());
				}
			}
		}
		form.setSelectedBrand(selectBrand);
		model.addAttribute("brandForm", form);
		model.addAttribute("brands", listProductType);
		return "pages-back/customer/add_brand";
	}

	@RequestMapping(value = "/add_brand", method = RequestMethod.POST)
	String addBrandSubmit(@ModelAttribute("brandForm") BrandForm brandForm, Model model) throws Exception {
		log.info("/add_brand POST");
		log.info("Selected brand id: " + brandForm);
		User userAuthen = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		brandForm.setUserCreate(userAuthen.getUsername());
		brandForm.setUserUpdate(userAuthen.getUsername());
		customerService.addBrand(brandForm);
		return update(brandForm.getCustId(), model);
	}

	@RequestMapping(value = "add_address", method = RequestMethod.GET)
	String addAddredd(@RequestParam(value = "cusId", required = true) Long cusId, Model model) throws Exception {
		log.info("/add_address POST");
		CustDTO custDto = new CustDTO();
		List<User> users = new ArrayList<User>();
		custDto = customerService.findCustById(cusId);
		List<AddressDTO> listAddress = customerService.findAddressByCustomerId(cusId);
		List<ContactDTO> listContact = customerService.findContactByCustomerId(cusId);
		AddressDTO addrDto = new AddressDTO();
		addrDto.setCustId(cusId);
		listAddress.add(addrDto);
		List<CountryDTO> listCountry = customerService.listCountry();
		if (custDto != null) {
			users = userService.findUserByCustId(cusId);
		}
		ContactForm contactForm = new ContactForm();
		AddressForm addrFrom = new AddressForm();
		model.addAttribute("customerForm", custDto);
		model.addAttribute("users", users);
		model.addAttribute("selectedBrand", customerService.getCustBrandGroupById(cusId));
		model.addAttribute("listAddr", listAddress);
		model.addAttribute("addressTypes", getAddressConstant());
		model.addAttribute("listMobileType", customerService.getMobileType());
		model.addAttribute("country", listCountry);
		model.addAttribute("addressForm", addrFrom);
		model.addAttribute("listContact", listContact);
		model.addAttribute("contactForm", contactForm);
		return "pages-back/customer/edit";
	}

	@RequestMapping(value = "save_address", method = RequestMethod.POST)
	String saveAddressSubmit(@ModelAttribute("addressForm") @Valid AddressForm addressForm, BindingResult binding, Model model) throws Exception {
		log.info("/save_address POST");
		log.warn("binding error: " + binding.hasErrors());
		model.addAttribute("addressForm", addressForm);

		/*
		 * if (binding.hasErrors()) { return "pages-back/customer/edit"; }
		 */
		customerService.saveAddress(addressForm.getAddrId(), addressForm.getCustId(), addressForm.getAddress(), addressForm.getRegionCountryId(),
				addressForm.getTel1(), addressForm.getPostCode(), addressForm.getFax(), addressForm.getEmail(), addressForm.getType());

		return update(addressForm.getCustId(), model);
	}

	@RequestMapping(value = "add_contact", method = RequestMethod.GET)
	String addContact(@RequestParam(value = "cusId", required = true) Long cusId, Model model) throws Exception {
		log.info("/add_Contact GET");
		CustDTO custDto = new CustDTO();
		List<User> users = new ArrayList<User>();
		custDto = customerService.findCustById(cusId);
		List<AddressDTO> listAddress = customerService.findAddressByCustomerId(cusId);
		List<ContactDTO> listContact = customerService.findContactByCustomerId(cusId);
		List<CountryDTO> listCountry = customerService.listCountry();
		ContactDTO contact = new ContactDTO();
		contact.setCustId(cusId);
		listContact.add(contact);
		if (custDto != null) {
			users = userService.findUserByCustId(cusId);
		}
		ContactForm contactForm = new ContactForm();
		AddressForm addrFrom = new AddressForm();
		model.addAttribute("customerForm", custDto);
		model.addAttribute("users", users);
		model.addAttribute("selectedBrand", customerService.getCustBrandGroupById(cusId));
		model.addAttribute("listAddr", listAddress);
		model.addAttribute("addressTypes", getAddressConstant());
		model.addAttribute("listMobileType", customerService.getMobileType());
		model.addAttribute("country", listCountry);
		model.addAttribute("addressForm", addrFrom);
		model.addAttribute("contactForm", contactForm);
		model.addAttribute("listContact", listContact);
		return "pages-back/customer/edit";
	}

	@RequestMapping(value = "save_contact", method = RequestMethod.POST)
	String saveContactSubmit(@ModelAttribute("contactForm") @Valid ContactForm contact, BindingResult binding, Model model) throws Exception {
		log.info("/save_address POST");
		if(binding.hasErrors()){
			model.addAttribute("errorMsg", binding.getAllErrors().get(0).toString());
			model.addAttribute("contactForm", contact);
			return update(contact.getCustId(), model);
		}
		model.addAttribute("contactForm", contact);

		/*
		 * if (binding.hasErrors()) { return "pages-back/customer/edit"; }
		 */
		customerService.saveContact(contact);
		return update(contact.getCustId(), model);
	}

	public Map<Long, String> getAddressConstant() {
		Map<Long, String> addresses = new HashMap<Long, String>();
		addresses.put(AddressConstant.USER_INVOICE_TO, "Invoice To");
		addresses.put(AddressConstant.USER_DISPATCH_TO, "Dispatch To");
		return addresses;
	}

	@RequestMapping(value = "/edituser", method = RequestMethod.GET)
	String editUser(@RequestParam(value = "userId", required = true) Integer userId, Model model) {
		log.info("/edituser GET");

		User user = userService.findUserById(userId);

		UserRegisterForm form = new UserRegisterForm();
		form.setUserId(userId);
		form.setEmail(user.getEmail());
		form.setName(user.getName());
		form.setUsername(user.getUsername());
		form.setEnable(user.isEnabled());
		form.setCusId(user.getCustomer().getCustId());
		model.addAttribute("registerForm", form);
		return "pages-back/customer/editCustomerUser";
	}

	@RequestMapping(value = "/edituser", method = RequestMethod.POST)
	String edituser(@ModelAttribute("registerForm") @Valid UserRegisterForm registerForm, BindingResult binding, Model model) throws Exception {
		log.info("/edit_user POST");
		if (!binding.hasErrors()) {
			if(!registerForm.getPassword().trim().equals(registerForm.getConfirmPassword())){
				model.addAttribute("errorMsg", "Password does not match with Confirm Password.");
				return "pages-back/customer/editCustomerUser";
			}
			
			User user = userService.findUserById(registerForm.getUserId());
			
			if (user.getUsername().equals(registerForm.getUsername()) || !userService.isExistUsername(registerForm.getUsername())) {
				UserForm userForm = new UserForm();
				
				userForm.setUsername(registerForm.getUsername());
				userForm.setPassword(registerForm.getPassword());
				userForm.setEnable(registerForm.getEnable());
				userForm.setCustId(registerForm.getCusId());
				userForm.setId(registerForm.getUserId().toString());
				userForm.setEnable(registerForm.getEnable());
				userForm.setEmail(registerForm.getEmail());
				userForm.setName(registerForm.getName());
				
				userService.update(userForm);
				return update(registerForm.getCusId(), model);
			} else {
				model.addAttribute("errorMsg", "Exist username: " + registerForm.getUsername());
			}
		}

		return "pages-back/customer/editCustomerUser";
	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	String deleteUser(@RequestParam(value = "userId", required = true) Integer userId, Model model) throws Exception {
		log.info("/delete_user POST");
		UserForm userForm = new UserForm();
		userForm.setId(userId.toString());
		User user = userService.findUserById(userId);
		boolean isDeleteSuccess = userService.delete(userForm);
		
		if(!isDeleteSuccess){
			model.addAttribute("errorMsg", "Cannot delete user: " + user.getName());
		}
		return update(user.getCustomer().getCustId(), model);
	}
}
