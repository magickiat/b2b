package com.starboard.b2b.web.controller.backend;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.starboard.b2b.service.EmailService;

@Controller
@RequestMapping("/backend/email")
public class BackendEmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.GET)
	String index(Model model) {
		model.addAttribute("listProductEmail", emailService.listProductEmail());
		return "pages-back/admin/email";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	String save(@RequestParam Long productTypeId, @RequestParam String email) {
		Log.info("save " + email + "\tProduct type id: " + productTypeId);
		emailService.save(productTypeId, email);
		return new Gson().toJson("success");
	}
}
