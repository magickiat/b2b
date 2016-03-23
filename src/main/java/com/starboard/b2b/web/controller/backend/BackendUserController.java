package com.starboard.b2b.web.controller.backend;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.model.User;
import com.starboard.b2b.service.SecurityService;
import com.starboard.b2b.service.UserService;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.user.UserForm;
import com.starboard.b2b.web.form.user.UserRegisterForm;
import com.starboard.b2b.web.form.user.UserSearchForm;

@Controller
@RequestMapping("/backend/user")
public class BackendUserController {
	private static final Logger log = LoggerFactory.getLogger(BackendUserController.class);

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	String create(@RequestParam(value = "id", required = false) Long id, Model model) {
		model.addAttribute("roles", securityService.listRole());
		UserRegisterForm form = new UserRegisterForm();
		form.setCusId(id);
		model.addAttribute("registerForm", form);
		return "pages-back/user/create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	String submit(@ModelAttribute("registerForm") UserRegisterForm registerForm, Model model, BindingResult binding) {
		log.info("/gen_user POST");
		userService.add(registerForm);
		return create(registerForm.getCusId(), model);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	String searchForm(Model model) {
		log.info("searchForm");
		return searchAction(new UserSearchForm(), model);
	}

	@RequestMapping(value = "/search-action", method = RequestMethod.GET)
	String searchAction(@ModelAttribute("searchForm") UserSearchForm form, Model model) {
		log.info("searchAction: " + form);
		if (!model.containsAttribute("searchForm")) {
			model.addAttribute("searchForm", form);
		}
		model.addAttribute("resultPage", userService.search(form));
		return "pages-back/user/search";
	}

	@RequestMapping(value = "/edit-staff", method = RequestMethod.GET)
	String editStaff(@RequestParam("userId") Integer userId, Model model) {
		log.info("Edit staff id: " + userId);

		User user = userService.findUserById(userId);

		UserRegisterForm form = new UserRegisterForm();
		form.setUserId(userId);
		form.setEmail(user.getEmail());
		form.setName(user.getName());
		form.setUsername(user.getUsername());
		form.setEnable(user.isEnabled());
		model.addAttribute("registerForm", form);

		return "pages-back/user/edit-staff";
	}

	@RequestMapping(value = "/edit-staff", method = RequestMethod.POST)
	String editStaff(@Valid @ModelAttribute("registerForm") UserRegisterForm form, BindingResult binding, Model model) {
		log.info("Edit staff id: " + form.getUserId());

		if (!binding.hasErrors()) {
			if (!form.getPassword().trim().equals(form.getConfirmPassword())) {
				model.addAttribute("errorMsg", "Password does not match with Confirm Password.");
				return "pages-back/user/edit-staff";
			}

			User user = userService.findUserById(form.getUserId());

			if (user.getUsername().equals(form.getUsername()) || !userService.isExistUsername(form.getUsername())) {
				UserForm userForm = new UserForm();

				userForm.setUsername(form.getUsername());
				userForm.setPassword(form.getPassword());
				userForm.setEnable(form.getEnable());
				userForm.setId(form.getUserId().toString());
				userForm.setEnable(form.getEnable());
				userForm.setEmail(form.getEmail());
				userForm.setName(form.getName());

				userService.update(userForm);
				return searchForm(model);
			} else {
				model.addAttribute("errorMsg", "Exist username: " + form.getUsername());
			}
		}

		return "pages-back/user/edit-staff";
	}

	@RequestMapping("/info")
	String myInformation(Model model) {
		model.addAttribute("user", UserUtil.getCurrentUser());
		return "pages-back/user/info";
	}
}
