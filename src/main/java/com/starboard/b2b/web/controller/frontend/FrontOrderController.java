package com.starboard.b2b.web.controller.frontend;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.WithnoseConstant;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.service.BrandService;
import com.starboard.b2b.service.CountryService;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Controller
@RequestMapping("/frontend/order/")
public class FrontOrderController {

	private static final Logger log = LoggerFactory.getLogger(FrontOrderController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private BrandService brandService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	String step1(Model model) {
		List<ProductBrandGroupDTO> brandGroupList = brandService
				.getBrandGroupList(UserUtil.getCurrentUser().getCustomer().getCustId());
		model.addAttribute("brandGroupList", brandGroupList);
		return "pages-front/order/step1_brand";
	}

	@RequestMapping(value = "step2/index", method = RequestMethod.GET)
	String step2ChooseAddress(@RequestParam("brand_id") Long brandId, Model model) {
		log.info("Brand id: " + brandId);
		List<AddressDTO> invoiceToAddress = customerService
				.findAddress(UserUtil.getCurrentUser().getCustomer().getCustId(), AddressConstant.TYPE_INVOICE_TO);

		/**
		 * Get first invoice address only
		 */
		AddressDTO invoiceTo = null;
		if (invoiceToAddress != null && !invoiceToAddress.isEmpty()) {
			invoiceTo = invoiceToAddress.get(0);
		}

		model.addAttribute("invoiceToAddress", invoiceTo);

		// model.addAttribute("dispatch"); // TODO get dispatch address

		model.addAttribute("countryList", countryService.findAll());
		model.addAttribute("brandId", brandId);
		return "pages-front/order/step2_address";
	}

	@RequestMapping(value = "step2/search", method = RequestMethod.GET)
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

	@RequestMapping(value = "step2/search-action", method = RequestMethod.GET)
	String step2SearchAction(@ModelAttribute SearchProductForm form, Model model) {
		log.info("search condition: " + form.toString());

		setSearchCondition(form, model);
		Page<SearchProductModelDTO> resultPage = productService.searchProduct(form);
		model.addAttribute("resultPage", resultPage);

		return "pages-front/order/step2_search";
	}

	@RequestMapping(value = "step2/view", method = RequestMethod.GET)
	String step2ModelDetail(String modelId, Model model) {
		log.info("GET step2/view");
		log.info("modelId = " + modelId);

		if (StringUtils.isEmpty(modelId)) {
			model.addAttribute("errorMsg", "Not found product model");
		} else {

			model.addAttribute("productCategoryList", productService.findAllProductCategory());
			model.addAttribute("productModelList", productService.findAllProductModel());
			model.addAttribute("productYearList", productService.findAllProductYear());
			model.addAttribute("productTechnologyList", productService.findAllProductTechnology());

			List<ProductSearchResult> productListNoWithnose = productService.findProductModel(modelId,
					WithnoseConstant.NO_WITHNOSE_PROTECTION);
			List<ProductSearchResult> productListWithnose = productService.findProductModel(modelId,
					WithnoseConstant.WITHNOSE_PROTECTION);
			
			// Find product has withnose 
			if(!productListNoWithnose.isEmpty()){
				ProductSearchResult result = productListNoWithnose.get(0);
				result.getProduct().getProductBuyerGroupId();
				model.addAttribute("hasWithnoseBoard");
			}
			
			
			model.addAttribute("productListNoWithnose", productListNoWithnose);
			model.addAttribute("productListWithnose", productListWithnose);
//			model.addAttribute("productListAll", productListAll);
			// model.addAttribute("productImagesList", productImagesList);
			// model.addAttribute("checkWithNose",
			// Integer.valueOf(productListPre1.size()));
			// model.addAttribute("header1",
			// productModelgetHeader.getHeaderText1());
			// model.addAttribute("header2",
			// productModelgetHeader.getHeaderText2());
			//
		}

		return "pages-front/order/step2_view_model";
	}

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
