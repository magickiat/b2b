package com.starboard.b2b.web.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starboard.b2b.model.User;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.web.form.user.UserForm;

@Controller
@RequestMapping("/frontend/user")
public class FrontUserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	String index(Model model){
		return "pages-front/user/index";
	}
	
	@RequestMapping("view")
	String view(Model model){
		
		UserForm userForm = new UserForm();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userForm.setId(user.getUsername());
		userForm.setUsername(user.getUsername());
		userForm.setPassword(user.getPassword());
		userForm.setEmail(user.getEmail());
		model.addAttribute("userForm",userForm);
		
		return "pages-front/user/index";
	}
	
	@RequestMapping("edit")
	String view(@ModelAttribute UserForm userForm,Model model, BindingResult binding) {
		userService.update(userForm);
		return "pages-front/user/view";
	}
}
