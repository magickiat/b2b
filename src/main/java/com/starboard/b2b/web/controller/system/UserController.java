package com.starboard.b2b.web.controller.system;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starboard.b2b.service.SecurityService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/gen_user", method = RequestMethod.GET)
	String form(Model model) {
		log.info("/gen_user GET");

		model.addAttribute("roles", securityService.listRole());
		if (!model.containsAttribute("registerForm")) {
			model.addAttribute("registerForm", new UserRegisterForm());
		}
		return "system/gen_user";
	}

	@RequestMapping(value = "/gen_user", method = RequestMethod.POST)
	String submit(@ModelAttribute("registerForm") @Valid UserRegisterForm registerForm, BindingResult binding,
			Model model) {
		log.info("/gen_user POST");
		if (binding.hasErrors()) {
			model.addAttribute("registerForm", registerForm);
		} else {
			userService.add(registerForm);
		}
		model.addAttribute("roles", securityService.listRole());
		return "system/gen_user";
	}
}
