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

import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.dto.CustDTO;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.BrandService;
import com.starboard.b2b.service.ConfigService;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.util.PagingUtil;
import com.starboard.b2b.web.form.address.AddressForm;
import com.starboard.b2b.web.form.brand.BrandForm;
import com.starboard.b2b.web.form.contact.ContactForm;
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
		List<AddressDTO> listAddress = customerService.findAddressByCustomerId(id);
		List<ContactDTO> listContact = customerService.findContactByCustomerId(id);
		List<CountryDTO> listCountry = customerService.listCountry();
		if (custDto != null) {
			users = userService.findUserByCustId(id);
		}
		ContactForm contactForm = new ContactForm();
		AddressForm addrFrom = new AddressForm();
		model.addAttribute("customerForm", custDto);
		model.addAttribute("users", users);
		model.addAttribute("selectedBrand", customerService.getSelectedBrand(id));
		model.addAttribute("listAddr", listAddress);
		model.addAttribute("country", listCountry);
		model.addAttribute("addressForm",addrFrom);
		model.addAttribute("contactForm", contactForm);
		model.addAttribute("listContact", listContact);
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
		model.addAttribute("selectedBrand", customerService.getSelectedBrand(cusId));
		model.addAttribute("listAddr", listAddress);
		model.addAttribute("country", listCountry);
		model.addAttribute("addressForm",addrFrom);
		model.addAttribute("listContact", listContact);
		model.addAttribute("contactForm", contactForm);
		return "pages-back/customer/edit";
	}
	
	@RequestMapping(value = "save_address", method = RequestMethod.POST)
	String saveAddressSubmit(@ModelAttribute("addressForm") @Valid AddressForm addressForm,
			BindingResult binding, Model model) throws Exception {
		log.info("/save_address POST");
		log.warn("binding error: " + binding.hasErrors());
		model.addAttribute("addressForm", addressForm);
		
		/*if (binding.hasErrors()) {
			return "pages-back/customer/edit";
		}*/
		customerService.saveAddress(addressForm.getAddrId(), addressForm.getCustId(), addressForm.getAddress(), addressForm.getRegionCountryId(), 
					addressForm.getTel1(), addressForm.getPostCode(), addressForm.getFax(), addressForm.getEmail(), addressForm.getType());
		
		return update(addressForm.getCustId(),model);
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
		model.addAttribute("selectedBrand", customerService.getSelectedBrand(cusId));
		model.addAttribute("listAddr", listAddress);
		model.addAttribute("country", listCountry);
		model.addAttribute("addressForm",addrFrom);
		model.addAttribute("contactForm", contactForm);
		model.addAttribute("listContact", listContact);
		return "pages-back/customer/edit";
	}
	
	@RequestMapping(value = "save_contact", method = RequestMethod.POST)
	String saveContactSubmit(@ModelAttribute("contactForm") @Valid ContactForm contact,
			BindingResult binding, Model model) throws Exception {
		log.info("/save_address POST");
		log.warn("binding error: " + binding.hasErrors());
		model.addAttribute("contactForm", contact);
		
		/*if (binding.hasErrors()) {
			return "pages-back/customer/edit";
		}*/
		customerService.saveContact(contact.getContactId(),contact.getCustId(),contact.getNameEn(),contact.getNameNick(),contact.getPosition(),contact.getBirthDate()
				,contact.getAddress(),contact.getTel(),contact.getEmail(),contact.getMobileId(),contact.getFax(),contact.getSkype(),contact.getFacebook(),contact.getTwitter());
		return update(contact.getCustId(),model);
	}
}
