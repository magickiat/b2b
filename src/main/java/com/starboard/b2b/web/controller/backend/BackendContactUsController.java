package com.starboard.b2b.web.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ContactUsDTO;
import com.starboard.b2b.service.ContactUsService;
import com.starboard.b2b.web.form.SearchContactUsForm;

@Controller
@RequestMapping("/backend/contactus/")
public class BackendContactUsController {

	@Autowired
	private ContactUsService contactUsService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model){
		
		SearchContactUsForm form = new SearchContactUsForm();
		Page<ContactUsDTO> contactUsList = contactUsService.search(form);
		model.addAttribute("contactUsList", contactUsList);
		model.addAttribute("searchForm", form);
		
		return "pages-back/contact-us/index";
	}
}
