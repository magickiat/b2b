package com.starboard.b2b.web.controller.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.dto.CountryDTO;
import com.starboard.b2b.service.AddrService;
import com.starboard.b2b.service.CountryService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.service.impl.SyncAXService;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.address.AddressForm;
import com.starboard.b2b.web.form.user.UserForm;

@Controller
@RequestMapping("/frontend/user")
public class FrontUserController {

	private static final Logger log = LoggerFactory.getLogger(FrontUserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private AddrService addrService;

	@Autowired
	private CountryService countryService;
	
	
	@Autowired
	private SyncAXService syncAXService;
	
	

	@RequestMapping("index")
	String index(Model model) {
		return "pages-front/user/index";
	}

	@RequestMapping("view")
	String view(Model model) {
		log.info("view ");
		final UserForm userForm = new UserForm();
		final Map<String, String> countries = getCountries();
		final Map<Long, String> addressTypes = getAddressConstant();
		final List<AddressForm> addressForms = new ArrayList<>();
		try {
			userForm.setId(UserUtil.getCurrentUser().getId().toString());
			userForm.setName(UserUtil.getCurrentUser().getName());
			userForm.setUsername(UserUtil.getCurrentUsername());
			userForm.setEmail(UserUtil.getCurrentUser().getEmail());
			addressForms.addAll(addrService.findByCustId(UserUtil.getCurrentUser().getCustomer().getCustId()));
			userForm.setAddresses(addressForms);
			userForm.setCustId(UserUtil.getCurrentUser().getCustomer().getCustId());
		} catch (Exception e) {
			log.error("Got problem while finding address.");
		}
		model.addAttribute("userForm", userForm);
		model.addAttribute("countries", countries);
		model.addAttribute("addressTypes", addressTypes);

		return "pages-front/user/index";
	}

	@RequestMapping("edit")
	@ResponseBody String edit(@ModelAttribute("userForm") UserForm userForm, Model model) {
		log.info("Update user detail");
		log.info("Form: " + userForm);
		userForm.setEnable(true);
		boolean isUpdateSuccess = userService.update(userForm);
		return (isUpdateSuccess==true?"true":"false");
	}
	
	@RequestMapping("address/edit")
	@ResponseBody String editAddress2(@ModelAttribute("userForm") UserForm userForm, Model model, @RequestParam(value = "addressId", required = false) long addressId) {
		log.info("Edit address");
		boolean isUpdateSuccess = false;
		for (AddressForm addressForm : userForm.getAddresses()) {
			if (addressForm.getAddrId() == addressId) {
				isUpdateSuccess = addrService.update(addressForm);
			}
		}
		// prepare data for sync to AX system
		syncAXService.syncAddr(userForm.getCustId());
		
		return (isUpdateSuccess==true?"true":"false");
	}

	public Map<String, String> getCountries() {
		List<CountryDTO> countryDTOList = countryService.findAll();
		Map<String, String> countries = new HashMap<String, String>();
		for (CountryDTO country : countryDTOList) {
			countries.put(country.getCountryCode(), country.getCountryName());
		}
		return countries;
	}

	public Map<Long, String> getAddressConstant() {
		Map<Long, String> addresses = new HashMap<Long, String>();
		addresses.put(AddressConstant.USER_INVOICE_TO, "Invoice To");
		addresses.put(AddressConstant.USER_DISPATCH_TO, "Dispatch To");
		return addresses;
	}
}
