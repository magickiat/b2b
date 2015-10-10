package com.starboard.b2b.web.controller.frontend;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.service.BrandService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Controller
public class FrontOrderController {

	private static final Logger log = LoggerFactory.getLogger(FrontOrderController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private BrandService brandService;

	@RequestMapping(value = "/frontend/order/index", method = RequestMethod.GET)
	String step1(Model model) {
		List<ProductBrandGroupDTO> brandGroupList = brandService
				.getBrandGroupList(UserUtil.getCurrentUser().getCustomer().getCustId());
		model.addAttribute("brandGroupList", brandGroupList);
		return "pages-front/order/step1_brand";
	}

	@RequestMapping(value = "/frontend/order/step2/index", method = RequestMethod.GET)
	String step2ChooseAddress(@RequestParam("brand_id") Long brandId, Model model) {
		log.info("Brand id: " + brandId);
		model.addAttribute("brandId", brandId);
		return "pages-front/order/step2_address";
	}

	@RequestMapping(value = "/frontend/order/step2/search", method = RequestMethod.GET)
	String step2SearchProduct(@RequestParam("brand_id") Long brandId, Model model) {
		log.info("step2_search GET");
		log.info("Brand id: " + brandId);

		// set search condition
		SearchProductForm form = new SearchProductForm();
		form.setShowType("image");
		form.setPage(1);
		form.setBrandId(brandId);
		model.addAttribute("searchProductForm", form);
		
		setSearchCondition(form, model);
		
		Page<SearchProductModelDTO> resultPage = productService.searchProduct(form);
		model.addAttribute("resultPage", resultPage);
		

		return "pages-front/order/step2_search";
	}

	@RequestMapping(value = "/frontend/order/step2/searchaction", method = RequestMethod.GET)
	String step2SearchAction(@ModelAttribute SearchProductForm form, Model model) {
		log.info("search condition: " + form.toString());
		
		setSearchCondition(form, model);
		Page<SearchProductModelDTO> resultPage = productService.searchProduct(form);
		model.addAttribute("resultPage", resultPage);

		return "pages-front/order/step2_search";
	}
	
//	String step2ModelDetail

	private void setSearchCondition(SearchProductForm form, Model model) {
		model.addAttribute("productType", productService.findAllProductType(form.getBrandId()));
		model.addAttribute("productBuyerGroup", productService.findAllProductBuyerGroup());
		model.addAttribute("productModel", productService.findAllProductModel());
		model.addAttribute("productYear", productService.findAllProductYear());
		model.addAttribute("productTechnology", productService.findAllProductTechnology());
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
