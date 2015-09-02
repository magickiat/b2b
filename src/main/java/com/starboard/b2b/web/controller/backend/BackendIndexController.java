package com.starboard.b2b.web.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/backend/")
public class BackendIndexController {

	@RequestMapping(method = RequestMethod.GET)
	String index() {
		return "pages-back/order/search";
	}
}
