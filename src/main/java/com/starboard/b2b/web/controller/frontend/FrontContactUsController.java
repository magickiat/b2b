package com.starboard.b2b.web.controller.frontend;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starboard.b2b.dto.ContactDTO;
import com.starboard.b2b.service.ContactService;

@Controller
public class FrontContactUsController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/frontend/contactus")
	String contactus(Model model){
		
		List<ContactDTO> contactList = contactService.list();
		model.addAttribute("contactList", contactList);
		
		return "pages-front/contactus";
	}
	
	
}
