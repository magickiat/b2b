package com.starboard.b2b.web.controller.backend;

import org.apache.bval.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starboard.b2b.model.User;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.controller.frontend.LoginForm;

@Controller
@RequestMapping("/backend")
public class BackendLoginController {

	private static final Logger log = LoggerFactory.getLogger(BackendLoginController.class);

	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String form(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "pages-back/login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	String submit(@Validate @ModelAttribute LoginForm form, BindingResult binding) {
		log.info("POST " + form);
		if (binding.hasErrors()) {
			return "pages-back/login";
		}
		User user = userService.findUserById(form.getUsername());
		log.info("User : " + user);
		if (user != null) {
			return "pages-back/home";
		} else {
			return "pages-back/login";
		}

	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
