package com.starboard.b2b.web.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/frontend/order")
public class FrontOrderController {
	
	

	@RequestMapping(value = "index", method = RequestMethod.GET)
	String step1(Model model) {
		return "pages-front/order/step1_brand";
	}

	@RequestMapping(value = "step2", method = RequestMethod.GET)
	String step2(Integer brandId, Model model) {
		
		return "pages-front/order/step2_address";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	String createOrderForm(Model model) {
		return "pages-front/order/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	String createOrderSubmit(Model model) {
		return "pages-front/order/create";
	}

	@RequestMapping(value = "summary", method = RequestMethod.GET)
	String orderSummary(Model model) {
		return "pages-front/order/summary";
	}
}
