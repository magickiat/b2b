package com.starboard.b2b.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/front", method = RequestMethod.GET)
	String form(Model model) {
		model.addAttribute("msg", "World");
		return "pages-front/index";
	}
}
