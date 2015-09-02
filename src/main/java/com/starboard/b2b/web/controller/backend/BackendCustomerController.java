package com.starboard.b2b.web.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/backend/customer")
public class BackendCustomerController {

	@RequestMapping(method = RequestMethod.GET)
	String search(Model model) {
		return "pages-back/customer/search";
	}
}
