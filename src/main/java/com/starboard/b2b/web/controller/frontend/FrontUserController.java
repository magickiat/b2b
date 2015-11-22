package com.starboard.b2b.web.controller.frontend;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.AddrService;
import com.starboard.b2b.service.CountryService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.user.UserForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/frontend/user")
public class FrontUserController {

	private static final Logger log = LoggerFactory.getLogger(FrontOrderController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddrService addrService;

	@Autowired
	private CountryService countryService;

	@RequestMapping("index")
	String index(Model model) {
		return "pages-front/user/index";
	}

	@RequestMapping("view")
	String view(Model model) {

		UserForm userForm = new UserForm();
		User userAuthen = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, String> countries = getCountries();
		List<Long> addressTypes = getAddressConstant();		
		User user = userService.findByUsername(userAuthen.getUsername());
		List<Addr> addrs = new ArrayList<Addr>();
		try{
			Long cust = user.getCustomer().getCustId();
			addrs = (cust != null)?addrService.findByCustId(cust):new ArrayList<Addr>();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		userForm.setId(userAuthen.getUsername());
		userForm.setUsername(userAuthen.getUsername());
		userForm.setPassword(userAuthen.getPassword());
		userForm.setEmail(userAuthen.getEmail());
		userForm.setAddresses(addrs);
		
		model.addAttribute("userForm", userForm);
		model.addAttribute("countries", countries);
		model.addAttribute("addressTypes", addressTypes);
		
		return "pages-front/user/index";
	}

	@RequestMapping("edit")
	String view(@ModelAttribute UserForm userForm, Model model, BindingResult binding) {
		// userService.update(userForm);
		Map<String, String> countries = getCountries();
		List<Long> addresses = getAddressConstant();
		
		System.out.println("country-------> " + userForm.getCountry());
		System.out.println("addressType-------> " + userForm.getAddressType());
		
		model.addAttribute("userForm", userForm);
		model.addAttribute("countries", countries);
		model.addAttribute("addresses", addresses);
		return "pages-front/user/index";
	}

	public Map<String, String> getCountries() {
		List<CountryDTO> countryDTOList = countryService.findAll();
		Map<String, String> countries = new HashMap<String, String>();
		for (CountryDTO country : countryDTOList) {
			countries.put(country.getCountryCode(), country.getCountryName());
		}
		return countries;
	}

	public List<Long> getAddressConstant() {
		List<Long> addresses = new ArrayList<Long>();
		addresses.add(AddressConstant.INVOICE_TO);
		addresses.add(AddressConstant.DISPATCH_TO);
		return addresses;
	}
}
