package com.starboard.b2b.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starboard.b2b.service.EnvironmentService;

@Controller
public class EnvironmentController {

	private EnvironmentService environmentService;
	
	@RequestMapping(name = "/system/env", method = RequestMethod.GET)
	String info(Model model){
		model.addAttribute("evnData", environmentService.getEnvironment());
		return "system/env";
	}

	@Autowired
	public void setEnvironmentService(EnvironmentService environmentService) {
		this.environmentService = environmentService;
	}
}
