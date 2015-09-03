package com.starboard.b2b.web.controller.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.service.SecurityService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.user.UserRegisterForm;

@Controller
@RequestMapping("/backend/user")
public class BackendUserController {
	private static final Logger log = LoggerFactory.getLogger(BackendUserController.class);
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	String search(@RequestParam(value = "id", required = false) String id ,Model model) {
		model.addAttribute("roles", securityService.listRole());
		UserRegisterForm form = new UserRegisterForm();
		form.setCusId(id);
		model.addAttribute("registerForm", form);
		return "pages-back/user/create";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	String submit(@ModelAttribute UserRegisterForm registerForm,Model model, BindingResult binding) {
		log.info("/gen_user POST");
		userService.add(registerForm);
		return search(registerForm.getCusId(),model);
	}
}
