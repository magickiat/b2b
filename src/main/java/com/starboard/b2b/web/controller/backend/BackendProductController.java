package com.starboard.b2b.web.controller.backend;

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
import org.springframework.web.multipart.MultipartFile;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.dto.search.SearchRequest;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ExcelUtil;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Controller
@RequestMapping("/backend/product")
public class BackendProductController {

	private static final Logger log = LoggerFactory.getLogger(BackendProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model) {
		SearchProductForm searchForm = new SearchProductForm();
		List<ProductTypeDTO> productTypes = productService.findAllProductType();
		model.addAttribute("productType", productTypes);

		// when all product type, find with relate product type
		List<ProductBuyerGroupDTO> productBuyerGroups;
		if (StringUtils.isNotEmpty(searchForm.getSelectedBrand())) {
			Long brandId = new Long(searchForm.getSelectedBrand());
			productBuyerGroups = productService.findProductBuyerGroupByBrandId(brandId);
		} else {
			productBuyerGroups = productService.findProductBuyerGroupByProductType(productTypes);
		}

		model.addAttribute("productBuyerGroup", productBuyerGroups);
		model.addAttribute("productModel", productService.findAllProductModel());
		model.addAttribute("productYear", productService.findAllProductYear());
		model.addAttribute("productTechnology", productService.findAllProductTechnology());

		model.addAttribute("searchForm", searchForm);

		return search(searchForm, model);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	String search(@ModelAttribute("searchForm") SearchProductForm searchForm, Model model) {
		Page<SearchProductModelDTO> searchProduct = productService.searchProductBackend(searchForm);
		model.addAttribute("resultPage", searchProduct);
		model.addAttribute("searchForm", searchForm);
		return "pages-back/product/index";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	String upload(Model model) {
		return "pages-back/product/upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	String upload(@RequestParam("file") MultipartFile file, Model model) throws Exception {

		if (file.isEmpty()) {
			throw new B2BException("excel product file are not present in this request");
		}

		List<ProductDTO> uploadProducts = ExcelUtil.parseProduct(file.getInputStream());

		if (uploadProducts == null || uploadProducts.isEmpty()) {
			throw new B2BException("Product not not found in this upload file");
		}

		log.info("uploadProducts size: " + uploadProducts.size());

		productService.updateProduct(uploadProducts);

		model.addAttribute("msg", "upload complete");
		return "pages-back/product/upload";
	}

}
