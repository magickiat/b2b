package com.starboard.b2b.web.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/backend/contactus/")
public class BackendContactUsController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model){
		return "pages-back/contact-us/index";
	}
}
