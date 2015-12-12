package com.starboard.b2b.web.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactusController {
	
	@RequestMapping("/frontend/contactus")
	String contactus(){
		return "pages-front/contactus";
	}
	
	
}
