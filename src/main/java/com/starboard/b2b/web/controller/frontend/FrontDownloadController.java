package com.starboard.b2b.web.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend/download")
public class FrontDownloadController {

	@RequestMapping("index")
	String index(Model model){
		return "pages-front/download/index";
	}
}
