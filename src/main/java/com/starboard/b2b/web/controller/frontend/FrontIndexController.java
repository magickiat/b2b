package com.starboard.b2b.web.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.service.ContentService;

@Controller
public class FrontIndexController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/frontend")
	String index(@RequestParam(value = "page", required = false) Integer page, Model model) {
		model.addAttribute("resultPage", contentService.listCont(page));
		return "pages-front/home";
	}
}
