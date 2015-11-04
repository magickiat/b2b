package com.starboard.b2b.web.controller.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.WithnoseConstant;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.service.BrandService;
import com.starboard.b2b.service.CountryService;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Controller
@RequestMapping("/frontend/order/")
@SessionAttributes({ "cart" })
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
		List<ProductBrandGroupDTO> brandGroupList = brandService.getBrandGroupList(UserUtil.getCurrentUser().getCustomer().getCustId());
		model.addAttribute("brandGroupList", brandGroupList);
		return "pages-front/order/step1_brand";
	}

	@RequestMapping(value = "step2/index", method = RequestMethod.GET)
	String step2ChooseAddress(@RequestParam("brand_id") Long brandId, Model model) {
		log.info("Brand id: " + brandId);
		List<AddressDTO> invoiceToAddress = customerService.findAddress(UserUtil.getCurrentUser().getCustomer().getCustId(),
				AddressConstant.TYPE_INVOICE_TO);

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

		// Create cart
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new HashMap<Long, ProductDTO>());
		}

		// Show shopping cart
		model.addAttribute("showShoppingCart", "true");

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

		// Show shopping cart
		model.addAttribute("showShoppingCart", "true");

		setSearchCondition(form, model);
		Page<SearchProductModelDTO> resultPage = productService.searchProduct(form);
		if ("list".equals(form.getShowType())) {
			log.info("Find product price, search type 'List'");
			productService.findProductPriceList(resultPage.getResult(), UserUtil.getCurrentUser().getCustomer().getInvoiceCode());
		}
		model.addAttribute("resultPage", resultPage);

		return "pages-front/order/step2_search";
	}

	@RequestMapping(value = "step2/view", method = RequestMethod.GET)
	String step2ModelDetail(String modelId, Model model) {
		log.info("GET step2/view");
		log.info("modelId = " + modelId);

		// Show shopping cart
		model.addAttribute("showShoppingCart", "true");

		model.addAttribute("modelId", modelId);

		if (StringUtils.isEmpty(modelId)) {
			model.addAttribute("errorMsg", "Not found product model " + modelId);
		} else {

			String productBuyerGroupId = null;

			// Find product model
			List<ProductSearchResult> productListNoWithnose = productService.findProductModel(modelId, WithnoseConstant.NO_WITHNOSE_PROTECTION);
			List<ProductSearchResult> productListWithnose = productService.findProductModel(modelId, WithnoseConstant.WITHNOSE_PROTECTION);

			model.addAttribute("productListNoWithnose", productListNoWithnose);
			model.addAttribute("productListWithnose", productListWithnose);

			// Find product buyer group from no Withnose product
			if (!productListNoWithnose.isEmpty()) {
				ProductSearchResult result = productListNoWithnose.get(0);
				productBuyerGroupId = result.getProduct().getProductBuyerGroupId();
				log.info("productBuyerGroupId: " + productBuyerGroupId);
				model.addAttribute("hasWithnoseBoard", "WB".equalsIgnoreCase(productBuyerGroupId));
			}

			// Find product price
			String invoiceCode = UserUtil.getCurrentUser().getCustomer().getInvoiceCode();

			if (productListNoWithnose != null && !productListNoWithnose.isEmpty()) {
				productService.findProductPrice(productListNoWithnose, invoiceCode);
			}
			if (productListWithnose != null && !productListWithnose.isEmpty()) {
				productService.findProductPrice(productListWithnose, invoiceCode);
			}

			// find product size (productLength)
			model.addAttribute("productListNoWithnoseLength", productService.findProductLength(productListNoWithnose));
			model.addAttribute("productListWithnoseLength", productService.findProductLength(productListWithnose));

			HashMap<String, List<ProductSearchResult>> noWithnoseTech = productService.groupProductByTechnology(productListNoWithnose);
			HashMap<String, List<ProductSearchResult>> withnoseTech = productService.groupProductByTechnology(productListWithnose);

			ArrayList<HashMap<String, List<ProductSearchResult>>> allTech = new ArrayList<>();
			allTech.add(noWithnoseTech);
			allTech.add(withnoseTech);
			model.addAttribute("allTech", allTech);

			// model.addAttribute("noWithnoseTech", noWithnoseTech);
			// model.addAttribute("withnoseTech", withnoseTech);

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
		List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
		model.addAttribute("productType", productTypes);

		// when all product type, find with relate product type
		List<ProductBuyerGroupDTO> productBuyerGroups = null;
		if (form.getSelectedBrand() != null && !"".equals(form.getSelectedBrand().trim())) {
			Long brandId = new Long(form.getSelectedBrand());
			productBuyerGroups = productService.findProductBuyerGroupByBrandId(brandId);
		} else {
			productBuyerGroups = productService.findProductBuyerGroupByProductType(productTypes);
		}

		model.addAttribute("productBuyerGroup", productBuyerGroups);
		model.addAttribute("productModel", productService.findAllProductModel());
		model.addAttribute("productYear", productService.findAllProductYear());
		model.addAttribute("productTechnology", productService.findAllProductTechnology());
	}

	@RequestMapping(value = "add-to-cart", method = RequestMethod.POST)
	public @ResponseBody List<ProductDTO> addToCart(@RequestParam Long productId, @RequestParam Long quantity,
			@ModelAttribute("cart") Map<Long, ProductDTO> cart) throws IllegalArgumentException {

		log.info("productId = " + productId + "\tquantity = " + quantity);

		// Validat Quantity
		if (quantity == null) {
			throw new IllegalArgumentException("Quantity is required.");
		}
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity must over than zero.");
		}
		if (quantity > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Quantity is huge, please contact Administrator.");
		}

		// Validate Product
		if (productId == null) {
			throw new IllegalArgumentException("Please select product.");
		}

		// validate exist product
		ProductDTO product = productService.findById(productId);

		if (product == null || product.getProductCode() == null) {
			throw new IllegalArgumentException("Invalid product id");
		}

		// get exist product in cart
		ProductDTO productInCart = cart.get(productId);
		if (productInCart == null) {
			productInCart = product;
			cart.put(productId, productInCart);
		} else {
			quantity += productInCart.getProductQuantity();
		}

		productInCart.setProductQuantity(quantity);

		ArrayList<ProductDTO> result = new ArrayList<>();
		Set<Long> keySet = cart.keySet();
		for (Long key : keySet) {
			result.add(cart.get(key));
		}

		result.trimToSize();
		return result;
	}
//
//	@RequestMapping(value = "add-list-to-cart", method = RequestMethod.POST)
//	public @ResponseBody List<ProductDTO> addListToCart(@RequestBody ProductDtoWrapper products, @ModelAttribute("cart") Map<Long, ProductDTO> cart)
//			throws IllegalArgumentException {
//
//		List<ProductDTO> list = products.getProducts();
//		for (ProductDTO productDTO : list) {
//			long quantity = productDTO.getProductQuantity();
//			long productId = productDTO.getProductId();
//
//			// Validat Quantity
//			if (quantity <= 0) {
//				throw new IllegalArgumentException("Quantity must over than zero.");
//			}
//			if (quantity > Integer.MAX_VALUE) {
//				throw new IllegalArgumentException("Quantity is huge, please contact Administrator.");
//			}
//
//			// Validate Product
//
//			// validate exist product
//			ProductDTO product = productService.findById(productId);
//
//			if (product == null || product.getProductCode() == null) {
//				throw new IllegalArgumentException("Invalid product id");
//			}
//
//			// get exist product in cart
//			ProductDTO productInCart = cart.get(productId);
//			if (productInCart == null) {
//				productInCart = product;
//				cart.put(productId, productInCart);
//			} else {
//				quantity += productInCart.getProductQuantity();
//			}
//
//			productInCart.setProductQuantity(quantity);
//		}
//
//		ArrayList<ProductDTO> result = new ArrayList<>();
//		Set<Long> keySet = cart.keySet();
//		for (Long key : keySet) {
//			result.add(cart.get(key));
//		}
//
//		result.trimToSize();
//		return result;
//	}

	@RequestMapping(value = "/step3/checkout", method = RequestMethod.GET)
	String checkout(@ModelAttribute("cart") Map<Long, ProductDTO> cart, Model model) {
		String invoiceCode = UserUtil.getCurrentUser().getCustomer().getInvoiceCode();
		List<ProductSearchResult> products = productService.findProductPrice(cart, invoiceCode);
		model.addAttribute("products", products);
		return "pages-front/order/step3_confirm";
	}
	
	@RequestMapping(value = "/step3/remove", method = RequestMethod.POST)
	String removeFromCart(@RequestParam Long productId, @ModelAttribute("cart") Map<Long, ProductDTO> cart, Model model) {
		log.info("/step3/remove POST");
		log.info("product id = " + productId);
		if(cart != null){
			log.info("Before remove size: " + cart.size());
			ProductDTO dto = cart.remove(productId);
			log.info("Remove product: " + dto);
			log.info("After remove size: " + cart.size());
		}else{
			log.warn("Not found shopping cart");
		}
		return checkout(cart, model);
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

	// @ExceptionHandler(IllegalArgumentException.class)
	// public @ResponseBody String handleException(Exception e,
	// HttpServletResponse response) {
	// response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	// return e.getMessage();
	// }

}
