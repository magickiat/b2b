package com.starboard.b2b.web.controller.frontend;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ContentDTO;
import com.starboard.b2b.service.ContentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontIndexController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/frontend")
	String index(@RequestParam(value = "page", required = false) Integer page, Model model) {
		model.addAttribute("resultPage", contentService.listCont(page));
		return "pages-front/home";
	}

	@RequestMapping("/news")
	String news(@RequestParam int feedId, @RequestParam(defaultValue = "front") String side, Model model){
		Page<ContentDTO> pageContent = contentService.content(feedId);
		model.addAttribute("resultPage", pageContent);
		model.addAttribute("side", side);
		return "news";
	}
}
