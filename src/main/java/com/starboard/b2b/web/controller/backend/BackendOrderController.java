package com.starboard.b2b.web.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/backend/order")
public class BackendOrderController {

	@RequestMapping(name = "search", method = RequestMethod.GET)
	String search(Model model) {
		return "pages-back/order/search";
	}
}
