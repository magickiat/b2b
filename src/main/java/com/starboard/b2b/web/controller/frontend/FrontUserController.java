package com.starboard.b2b.web.controller.frontend;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.model.User;
import com.starboard.b2b.service.AddrService;
import com.starboard.b2b.service.CountryService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.user.AddressForm;
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
		final UserForm userForm = new UserForm();
		final User userAuthen = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final Map<String, String> countries = getCountries();
		final List<Long> addressTypes = getAddressConstant();
		final List<AddressForm> addressForms = new ArrayList<>();
		try{
			final User user = userService.findByUsername(userAuthen.getUsername());
			userForm.setId(userAuthen.getId().toString());
			userForm.setUsername(userAuthen.getUsername());
			userForm.setEmail(userAuthen.getEmail());
			addressForms.addAll(addrService.findByCustId(user.getCustomer().getCustId()));
			userForm.setAddresses(addressForms);
			userForm.setCustId(user.getCustomer().getCustId());
		}catch(Exception e){
			log.error("Got problem while finding address.");
		}
		model.addAttribute("userForm", userForm);
		model.addAttribute("countries", countries);
		model.addAttribute("addressTypes", addressTypes);
		
		return "pages-front/user/index";
	}

	@RequestMapping("edit")
	String edit(@ModelAttribute UserForm userForm, Model model, BindingResult binding) {
		Map<String, String> countries = getCountries();
		List<Long> addressTypes = getAddressConstant();
		log.info("### edit ###");
		log.info("userForm1 Email----> " + userForm.getEmail());
		List<AddressForm> addressForms = new ArrayList<>();
		try{
			//Update user detail
			userService.update(userForm);
			//Get address detail
			addressForms.addAll(addrService.findByCustId(userForm.getCustId()));
			userForm.setAddresses(addressForms);
		}catch(Exception e){
			log.error("Got problem while finding address.");
		}

		model.addAttribute("userForm", userForm);
		model.addAttribute("countries", countries);
		model.addAttribute("addressTypes", addressTypes);
		return "pages-front/user/index";
	}

	@RequestMapping("address/edit")
	String editAddress(@ModelAttribute UserForm userForm, Model model, BindingResult binding) {
		Map<String, String> countries = getCountries();
		List<Long> addressTypes = getAddressConstant();	
		log.info("userForm Email----> " + userForm.getEmail());
		List<AddressForm> addressForms = new ArrayList<>();
		try{
			//Update address detail
			addrService.update(userForm);
			//Get address detail
			addressForms.addAll(addrService.findByCustId(userForm.getCustId()));
			userForm.setAddresses(addressForms);
		}catch(Exception e){
			log.error("Got problem while finding address.");
		}
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
