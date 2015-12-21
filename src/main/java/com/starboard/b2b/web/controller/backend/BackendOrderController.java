package com.starboard.b2b.web.controller.backend;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.web.form.product.OrderSummaryForm;
import com.starboard.b2b.web.form.product.SearchOrderForm;

@Controller
@RequestMapping("/backend/order")
public class BackendOrderController {

	private static final Logger log = LoggerFactory.getLogger(BackendOrderController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	private void setForm(final OrderSummaryForm form, final Model model) {
		final List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
		model.addAttribute("productType", productTypes);
		final List<OrderStatusDTO> orderStatus = orderService.findAllOrderStatus();
		model.addAttribute("orderStatus", orderStatus);
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	String search(Model model) {
		log.info("GET search");
		
		OrderSummaryForm form = new OrderSummaryForm();
		setForm(form, model);
		
		model.addAttribute("resultPage", orderService.searchOrder(form));
		model.addAttribute("searchOrderForm", new SearchOrderForm());
		
		return "pages-back/order/search";
	}
	
	@RequestMapping(value = "search-action", method = RequestMethod.GET)
    String orderSummarySearchAction(@ModelAttribute OrderSummaryForm form, Model model) {
        log.info("search condition: " + form.toString());
        
        setForm(form, model);
        model.addAttribute("resultPage", orderService.searchOrder(form));
		model.addAttribute("searchOrderForm", new SearchOrderForm());
		
		return "pages-back/order/search";
    }
}
