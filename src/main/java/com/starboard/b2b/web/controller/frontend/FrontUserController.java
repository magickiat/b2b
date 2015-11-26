package com.starboard.b2b.web.controller.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.model.Addr;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.AddrService;
import com.starboard.b2b.service.CountryService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.user.AddressForm;
import com.starboard.b2b.web.form.user.UserForm;

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
		List<AddressForm> addressForms = new ArrayList<AddressForm>();
		try{
			Long cust = user.getCustomer().getCustId();
			addressForms = (cust != null)?addrService.findByCustId(cust):new ArrayList<AddressForm>();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		userForm.setId(userAuthen.getUsername());
		userForm.setUsername(userAuthen.getUsername());
		userForm.setPassword(userAuthen.getPassword());
		userForm.setEmail(userAuthen.getEmail());
		userForm.setAddresses(addressForms); // AddressList
		
		model.addAttribute("userForm", userForm);
		model.addAttribute("countries", countries);
		model.addAttribute("addressTypes", addressTypes);
		
		return "pages-front/user/index";
	}

	@RequestMapping("edit") // this method call from both update user and address?? where the update user detail section?
	String edit(@ModelAttribute UserForm userForm, Model model, BindingResult binding) {
		User userAuthen = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, String> countries = getCountries();
		List<Long> addressTypes = getAddressConstant();	
		System.out.println("### edit ###");
		System.out.println("userForm1 Email----> " + userForm.getEmail()); // Not using sysout
		//userService.update(userForm);
		addrService.update(userForm);
		User user = userService.findByUsername(userAuthen.getUsername());
		List<AddressForm> addressForms = new ArrayList<AddressForm>();//Duplicate dec *
		try{
			Long cust = user.getCustomer().getCustId(); // create method to get just customer id instead of get whole user object then use only cust id
			addressForms = (cust != null)?addrService.findByCustId(cust):new ArrayList<AddressForm>(); //Duplicate declaration *
		}catch(Exception e){
			e.printStackTrace(); //<-- Do not print stack trace
		}
		
		userForm.setId(userForm.getUsername()); //getUsername(), this is not id
		userForm.setUsername(userForm.getUsername());
		userForm.setPassword(userForm.getPassword());
		userForm.setEmail(userForm.getEmail());
		userForm.setAddresses(addressForms);
		
		model.addAttribute("userForm", userForm);
		model.addAttribute("countries", countries);
		model.addAttribute("addressTypes", addressTypes);
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
