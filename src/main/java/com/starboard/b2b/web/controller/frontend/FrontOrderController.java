package com.starboard.b2b.web.controller.frontend;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.starboard.b2b.bean.ExcelOrderBean;
import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.AddressDTO;
import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.ProductBrandGroupDTO;
import com.starboard.b2b.dto.ProductBuyerGroupDTO;
import com.starboard.b2b.dto.ProductDTO;
import com.starboard.b2b.dto.ProductSearchResult;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.dto.search.SearchProductModelDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.BrandService;
import com.starboard.b2b.service.CustomerService;
import com.starboard.b2b.service.EmailService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.B2BFileUtil;
import com.starboard.b2b.util.CartHelper;
import com.starboard.b2b.util.ExcelUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.order.OrderSummaryForm;
import com.starboard.b2b.web.form.product.SearchProductForm;

@Controller
@RequestMapping("/frontend/order/")
@SessionAttributes({ "cart", "brandId" })
public class FrontOrderController {

	private static final Logger log = LoggerFactory.getLogger(FrontOrderController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private Environment environment;

	@Autowired
	private ApplicationConfig applicationConfig;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "index", method = RequestMethod.GET)
	String step1(Model model) {
		List<ProductBrandGroupDTO> brandGroupList = brandService.getBrandGroupList(UserUtil.getCurrentUser().getCustomer().getCustId());
		model.addAttribute("brandGroupList", brandGroupList);
		// Create cart
		if (model.asMap().get("cart") == null) {
			model.addAttribute("cart", new HashMap<Long, ProductDTO>());
		} else {
			HashMap<Long, ProductDTO> cart = (HashMap<Long, ProductDTO>) model.asMap().get("cart");
			if (!cart.isEmpty()) {
				log.info("Already selected product, redirect to quick order");
				Long brandId = (Long) model.asMap().get("brandId");
				return step2SearchProduct(brandId, model);
			}
		}
		return "pages-front/order/step1_brand";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "step2/index", method = RequestMethod.GET)
	String step2ChooseAddress(@RequestParam("brand_id") Long brandId, Model model) {
		log.info("Brand id: " + brandId);

		if (brandId == null) {
			return step1(model);
		}

		if (model.asMap().get("cart") != null) {
			HashMap<Long, ProductDTO> cart = (HashMap<Long, ProductDTO>) model.asMap().get("cart");
			if (!cart.isEmpty()) {
				if (model.containsAttribute("brandId") && model.asMap().get("brandId") != null) {
					brandId = (Long) model.asMap().get("brandId");
				}
			}
		}

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
		form.setBrandId(brandId);
		model.addAttribute("searchProductForm", form);

		setSearchCondition(form, brandId, model);

		Page<SearchProductModelDTO> resultPage = productService.searchProduct(form, UserUtil.getCurrentUser().getCustomer().getCustId());
		model.addAttribute("resultPage", resultPage);

		return "pages-front/order/step2_search";
	}

	@RequestMapping(value = "step2/search-action", method = RequestMethod.GET)
	String step2SearchAction(@ModelAttribute("searchProductForm") SearchProductForm form, @ModelAttribute("brandId") Long brandId, Model model) {
		log.info("search condition: " + form.toString());

		// Show shopping cart
		model.addAttribute("showShoppingCart", "true");

		setSearchCondition(form, brandId, model);
		form.setBrandId(brandId);
		Page<SearchProductModelDTO> resultPage = productService.searchProduct(form, UserUtil.getCurrentUser().getCustomer().getCustId());
		if ("list".equals(form.getShowType())) {
			log.info("Find product price, search type 'List'");
			productService.findProductPriceList(resultPage.getResult(), brandId);
		}
		model.addAttribute("resultPage", resultPage);

		return "pages-front/order/step2_search";
	}

	/**
	 * View single product when search by list
	 * 
	 * @param productId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "step2/product/{productId}", method = RequestMethod.GET)
	String viewSingleProduct(@PathVariable Long productId, Model model) {
		// Show shopping cart
		model.addAttribute("showShoppingCart", "true");

		ProductDTO product = productService.findById(productId);
		model.addAttribute("product", product);

		return "pages-front/order/step2_view_single_product";
	}

	@RequestMapping(value = "step2/view", method = RequestMethod.GET)
	String step2ModelDetail(@RequestParam String modelId, @ModelAttribute("brandId") Long brandId, Model model) {
		log.info("GET step2/view");
		log.info("modelId = " + modelId);

		// Show shopping cart
		model.addAttribute("showShoppingCart", "true");

		model.addAttribute("modelId", modelId);

		if (StringUtils.isEmpty(modelId)) {
			model.addAttribute("errorMsg", "Not found product model " + modelId);
		} else {

			// Find product model
			List<ProductSearchResult> productListNoWithnose = productService.findProductModel(modelId, B2BConstant.NO_WITHNOSE_PROTECTION);
			List<ProductSearchResult> productListWithnose = productService.findProductModel(modelId, B2BConstant.WITHNOSE_PROTECTION);

			model.addAttribute("productListNoWithnose", productListNoWithnose);
			model.addAttribute("productListWithnose", productListWithnose);

			// Find product buyer group from no Withnose product
			if (!productListWithnose.isEmpty()) {
				model.addAttribute("hasWithnoseBoard", true);
			}

			// Find product price
			if (!productListNoWithnose.isEmpty()) {
				productService.findProductPrice(productListNoWithnose, brandId);
			}
			if (productListWithnose != null && !productListWithnose.isEmpty()) {
				productService.findProductPrice(productListWithnose, brandId);
			}

			// find product size (productLength)
			model.addAttribute("productListNoWithnoseLength", productService.findProductLength(productListNoWithnose));
			model.addAttribute("productListWithnoseLength", productService.findProductLength(productListWithnose));

			HashMap<String, List<ProductSearchResult>> noWithnoseTech = productService.groupProductByTechnology(productListNoWithnose);
			HashMap<String, List<ProductSearchResult>> withnoseTech = productService.groupProductByTechnology(productListWithnose);

			model.addAttribute("noWithnoseTech", noWithnoseTech);
			model.addAttribute("withnoseTech", withnoseTech);

			ArrayList<HashMap<String, List<ProductSearchResult>>> allTech = new ArrayList<>();
			allTech.add(noWithnoseTech);
			allTech.add(withnoseTech);
			model.addAttribute("allTech", allTech);
		}

		return "pages-front/order/step2_view_model";
	}

	private void setSearchCondition(SearchProductForm form, Long brandGroupId, Model model) {
		List<ProductTypeDTO> productTypes = productService.getProductTypes(UserUtil.getCurrentUser().getCustomer().getCustId(), brandGroupId);
		model.addAttribute("productType", productTypes);

		// when all product type, find with relate product type
		List<ProductBuyerGroupDTO> productBuyerGroups;
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

	/*
	 * download excel order
	 */
	@RequestMapping(value = "download-template", method = RequestMethod.GET)
	public void downloadExcelOrder(@RequestParam("brand_id") Long brandGroupId, HttpServletResponse response) throws IOException {
		byte[] zip = B2BFileUtil.createExcelTemplateForOrder(applicationConfig, brandGroupId, productService);

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=STB_ORDER_FORM.zip");
		try (OutputStream output = response.getOutputStream()) {
			output.write(zip);
		}
	}

	/*
	 * upload excel order
	 */
	@RequestMapping(value = "upload-orders", method = RequestMethod.POST)
	public ModelAndView uploadExcelOrder(@ModelAttribute("brandId") Long currentBrandId, @RequestParam("file") MultipartFile file,
			@ModelAttribute("cart") Map<Long, ProductDTO> cart) {
		try {
			if (file.isEmpty()) {
				throw new B2BException("excel order file are not present in this request");
			}

			List<ExcelOrderBean> orders = ExcelUtil.parseOrder(file.getBytes());

			int orderSize = orders == null ? 0 : orders.size();
			if (orderSize > 0) {

				CartHelper helper = new CartHelper();
				helper.setBrandService(brandService);
				HashMap<Long, Long> brandGroup = helper.getBrandGroup();

				List<ProductDTO> products = new ArrayList<>(orderSize);

				for (ExcelOrderBean order : orders) {
					// ----- validate product is available to sell -----
					ProductDTO product = productService.findByProductCode(order.getProductCode());
					if (product.getProductCode() == null) {
						throw new B2BException(String.format("Product %s not available", order.getProductCode()));
					}

					// ----- validate product is current brand in cart -----
					log.info("product.getProductTypeId() = " + product.getProductTypeId());
					Long brandGroupId = brandGroup.get(product.getProductTypeId());
					if (brandGroupId == null || brandGroupId != currentBrandId) {
						throw new B2BException(String.format("Brand of product %s doesn't same as current brand", product.getProductCode()));
					}

					product.setProductQuantity(order.getQuantity());
					products.add(product);
				}

				// ----- update cart -----
				if (!products.isEmpty()) {
					for (ProductDTO product : products) {
						if (cart.get(product.getProductId()) == null) {
							cart.put(product.getProductId(), product);
						} else {
							ProductDTO productInCart = cart.get(product.getProductId());
							productInCart.setProductQuantity(productInCart.getProductQuantity() + product.getProductQuantity());
						}
					}
				}

			}

			return new ModelAndView("redirect:step3/checkout");
		} catch (IOException ex) {
			throw new B2BException("could not read excel order file");
		} catch (EncryptedDocumentException ex) {
			throw new B2BException("excel order file has password protection");
		} catch (InvalidFormatException ex) {
			throw new B2BException("uploaded file are not an valid excel file format");
		}
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

	@RequestMapping(value = "update-to-cart", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.OK)
	public @ResponseBody String updateQuantityToCart(@RequestParam Long productId, @RequestParam Long quantity,
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
			throw new IllegalArgumentException("Not found this product in cart");
		}

		productInCart.setProductQuantity(quantity);
		log.info("Remaining quantity: " + productInCart.getProductQuantity());

		return new Gson().toJson("success");
	}

	//
	// @RequestMapping(value = "add-list-to-cart", method = RequestMethod.POST)
	// public @ResponseBody List<ProductDTO> addListToCart(@RequestBody
	// ProductDtoWrapper products, @ModelAttribute("cart") Map<Long, ProductDTO>
	// cart)
	// throws IllegalArgumentException {
	//
	// List<ProductDTO> list = products.getProducts();
	// for (ProductDTO productDTO : list) {
	// long quantity = productDTO.getProductQuantity();
	// long productId = productDTO.getProductId();
	//
	// // Validat Quantity
	// if (quantity <= 0) {
	// throw new IllegalArgumentException("Quantity must over than zero.");
	// }
	// if (quantity > Integer.MAX_VALUE) {
	// throw new IllegalArgumentException("Quantity is huge, please contact
	// Administrator.");
	// }
	//
	// // Validate Product
	//
	// // validate exist product
	// ProductDTO product = productService.findById(productId);
	//
	// if (product == null || product.getProductCode() == null) {
	// throw new IllegalArgumentException("Invalid product id");
	// }
	//
	// // get exist product in cart
	// ProductDTO productInCart = cart.get(productId);
	// if (productInCart == null) {
	// productInCart = product;
	// cart.put(productId, productInCart);
	// } else {
	// quantity += productInCart.getProductQuantity();
	// }
	//
	// productInCart.setProductQuantity(quantity);
	// }
	//
	// ArrayList<ProductDTO> result = new ArrayList<>();
	// Set<Long> keySet = cart.keySet();
	// for (Long key : keySet) {
	// result.add(cart.get(key));
	// }
	//
	// result.trimToSize();
	// return result;
	// }
	@RequestMapping(value = "step3/checkout", method = RequestMethod.GET)
	String checkout(@ModelAttribute("cart") Map<Long, ProductDTO> cart, @ModelAttribute("brandId") Long brandId, Model model) {
		// ----- Find product's price in cart ------
		List<ProductSearchResult> products = productService.findProductPrice(cart, brandId);
		model.addAttribute("products", products);

		// ----- Find Invoice Address ------
		long custId = UserUtil.getCurrentUser().getCustomer().getCustId();
		List<AddressDTO> invoiceToAddress = customerService.findAddress(custId, AddressConstant.USER_INVOICE_TO);
		// Get first invoice address only
		AddressDTO invoiceTo;
		if (invoiceToAddress != null && !invoiceToAddress.isEmpty()) {
			invoiceTo = invoiceToAddress.get(0);
			model.addAttribute("invoiceToAddress", invoiceTo);
		}

		// ----- Find Dispatch to Address ------
		List<AddressDTO> dispatchToAddress = customerService.findAddress(custId, AddressConstant.USER_DISPATCH_TO);
		model.addAttribute("dispatchToAddress", dispatchToAddress);

		// ----- Find Shipping Type -----
		model.addAttribute("shippingTypeList", orderService.findAllShippingType());

		// ----- Find Payment Method -----
		model.addAttribute("paymentMethodList", orderService.findAllPaymentMethod());

		return "pages-front/order/step3_confirm";
	}

	@RequestMapping(value = "step3/remove", method = RequestMethod.POST)
	String removeFromCart(@RequestParam Long productId, @ModelAttribute("cart") Map<Long, ProductDTO> cart, @ModelAttribute("brandId") Long brandId,
			Model model) {
		log.info("/step3/remove POST");
		log.info("product id = " + productId);
		if (cart != null) {
			cart.remove(productId);
			log.info("After remove size: " + cart.size());
		} else {
			log.warn("Not found shopping cart");
		}
		return checkout(cart, brandId, model);
	}

	@RequestMapping(value = "step4/submit", method = RequestMethod.POST)
	String submitOrder(@RequestParam Long invoiceTo, @RequestParam Long dispatchTo, @RequestParam String shippingType,
			@RequestParam String customerRemark, @RequestParam String paymentMethod, @ModelAttribute("brandId") Long brandId,
			@ModelAttribute("cart") Map<Long, ProductDTO> cart, Model model, SessionStatus session, HttpServletRequest request) {
		log.info("----- step4/submit POST");
		log.info("----- brandId = " + brandId);
		log.info("----- dispatchTo = " + dispatchTo);
		log.info("----- shippingType = " + shippingType);
		log.info("----- customerRemark = " + customerRemark);
		log.info("----- paymentMethod = " + paymentMethod);
		log.info("----- ----- cart size = " + cart.size());

		List<OrderDTO> orders = orderService.newOrderByCurrency(brandId, invoiceTo, dispatchTo, shippingType, customerRemark, paymentMethod, cart);

		// ----- send mail to Sales -----
		String host = environment.getProperty("base.url");
		if (StringUtils.isEmpty(host)) {
			throw new B2BException("Not found host config");
		}

		for (OrderDTO order : orders) {

			try {
				emailService.sendEmailOrderToStaff(order, host);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}

			// ----- send mail to Customer -----
			try {
				emailService.sendEmailOrderToCustomer(order, host);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		// Clear Shopping Cart session
		// http://vard-lokkur.blogspot.com/2011/01/spring-mvc-session-attributes-handling.html
		model.addAttribute("brandId", null);
		model.addAttribute("cart", null);
		session.setComplete();

		// ----- for show finish button -----
		model.addAttribute("orderComplete", true);
		
		//----- find all order details to show by currency -----
		ArrayList<SearchOrderDTO> orderDetails = new ArrayList<>();
		Iterator<OrderDTO> iterator = orders.iterator();
		while (iterator.hasNext()) {
			OrderDTO orderDTO = (OrderDTO) iterator.next();
			orderDetails.add(searchOrder(orderDTO));
		}
		model.addAttribute("details", orderDetails);

		return "pages-front/order/step4_submit";
	}

	private SearchOrderDTO searchOrder(OrderDTO order) {
		final SearchOrderDTO orderReport = orderService.findOrderForReport(order.getOrderCode());
		final List<OrdAddressDTO> ordAddresses = orderService.findOrderAddress(order.getOrderCode());
		for (OrdAddressDTO ordAddress : ordAddresses) {
			log.info("received order address {} ", ordAddress);
			if (ordAddress.getType() == AddressConstant.ORDER_INVOICE_TO) {
				orderReport.setInvoiceToAddress(ordAddress);
			}
			if (ordAddress.getType() == AddressConstant.ORDER_DISPATCH_TO) {
				orderReport.setDispatchToAddress(ordAddress);
			}
		}
		List<SearchOrderDetailDTO> orderDetails = orderService.searchOrderDetail(order.getOrderCode());
		if (orderDetails != null && !orderDetails.isEmpty()) {
			orderReport.setOrderDetails(orderDetails);
		}
		return orderReport;
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
		log.info("summary GET");
		final OrderSummaryForm form = new OrderSummaryForm();
		form.setCustId(UserUtil.getCurrentUser().getCustomer().getCustId());
		setOrderSummarySearchForm(form, model);
		Page<SearchOrderDTO> resultPage = orderService.searchOrder(form);
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("orderSummaryForm", form);
		return "pages-front/order/summary";
	}

	@RequestMapping(value = "summary/search-action", method = RequestMethod.GET)
	String orderSummarySearchAction(@ModelAttribute("form") OrderSummaryForm form, Model model) {
		log.info("search condition: " + form.toString());
		setOrderSummarySearchForm(form, model);
		Page<SearchOrderDTO> resultPage = orderService.searchOrder(form);
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("orderSummaryForm", form);
		return "pages-front/order/summary";
	}

	@RequestMapping(value = "summary/report/{orderId}", method = RequestMethod.GET)
	String viewOrderSummary(@PathVariable Long orderId, Model model) {
		log.info("Report for order: {}", orderId);
		final SearchOrderDTO orderReport = orderService.findOrderForReport(orderId);
		final List<OrdAddressDTO> ordAddresses = orderService.findOrderAddress(orderReport.getOrderCode());
		for (OrdAddressDTO ordAddress : ordAddresses) {
			log.info("received order address {} ", ordAddress);
			if (ordAddress.getType().equals(AddressConstant.ORDER_INVOICE_TO)) {
				orderReport.setInvoiceToAddress(ordAddress);
			}
			if (ordAddress.getType().equals(AddressConstant.ORDER_DISPATCH_TO)) {
				orderReport.setDispatchToAddress(ordAddress);
			}
		}
		List<SearchOrderDetailDTO> orderDetails = orderService.searchOrderDetail(orderId);
		if (orderDetails != null && !orderDetails.isEmpty()) {
			orderReport.setOrderDetails(orderDetails);
		}
		model.addAttribute("orderReport", orderReport);
		return "pages-front/order/report";
	}

	/**
	 * Set all required search condition for order summary page
	 * 
	 * @param form
	 *            Order Summary form
	 * @param model
	 *            Model attributes
	 */
	private void setOrderSummarySearchForm(final OrderSummaryForm form, final Model model) {
		final List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
		model.addAttribute("productType", productTypes);
		final List<OrderStatusDTO> orderStatus = orderService.findAllOrderStatus();
		model.addAttribute("orderStatus", orderStatus);
	}

}
