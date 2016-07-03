package com.starboard.b2b.web.controller.frontend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ContactUsDTO;
import com.starboard.b2b.service.ContactUsService;
import com.starboard.b2b.web.form.SearchContactUsForm;

@Controller
public class FrontContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	@RequestMapping("/frontend/contactus")
	String contactus(Model model){
		SearchContactUsForm form = new SearchContactUsForm();
		
		Page<ContactUsDTO> resultPage = contactUsService.search(form);
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("searchForm", form);
		
		return "pages-front/contactus";
	}
	
	
}
