package com.starboard.b2b.web.controller.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/frontend/order")
public class FrontOrderController {

	private static final Logger log = LoggerFactory.getLogger(FrontOrderController.class);

	@RequestMapping(value = "index", method = RequestMethod.GET)
	String step1(Model model) {
		return "pages-front/order/step1_brand";
	}

	@RequestMapping(value = "step2", method = RequestMethod.GET)
	String step2(@RequestParam("brand_id") Integer brandId, Model model) {
		log.info("Brand id: " + brandId);
		model.addAttribute("brandId", brandId);
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
