package com.starboard.b2b.web.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontendLoginController {

	@RequestMapping(value = "/front", method = RequestMethod.GET)
	String form(Model model) {
		return "pages-front/index";
	}
}
