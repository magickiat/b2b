package com.starboard.b2b.web.controller.frontend;

import com.starboard.b2b.bean.ExcelOrderBean;
import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.common.WithnoseConstant;
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
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.util.ArchiveUtil;
import com.starboard.b2b.util.ExcelOrderUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.product.OrderSummaryForm;
import com.starboard.b2b.web.form.product.SearchProductForm;

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
import org.springframework.web.bind.annotation.ExceptionHandler;
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

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

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
	private BrandService brandService;

	@Autowired
	private OrderService orderService;
        
        @Autowired
        private Environment environment;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	String step1(Model model) {
		List<ProductBrandGroupDTO> brandGroupList = brandService.getBrandGroupList(UserUtil.getCurrentUser().getCustomer().getCustId());
		model.addAttribute("brandGroupList", brandGroupList);
		// Create cart
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new HashMap<Long, ProductDTO>());
		}
		return "pages-front/order/step1_brand";
	}

	@RequestMapping(value = "step2/index", method = RequestMethod.GET)
	String step2ChooseAddress(@RequestParam("brand_id") Long brandId, Model model) {
		log.info("Brand id: " + brandId);

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
	String step2ModelDetail(@RequestParam String modelId, Model model) {
		log.info("GET step2/view");
		log.info("modelId = " + modelId);

		// Show shopping cart
		model.addAttribute("showShoppingCart", "true");

		model.addAttribute("modelId", modelId);

		if (StringUtils.isEmpty(modelId)) {
			model.addAttribute("errorMsg", "Not found product model " + modelId);
		} else {

			// Find product model
			List<ProductSearchResult> productListNoWithnose = productService.findProductModel(modelId, WithnoseConstant.NO_WITHNOSE_PROTECTION);
			List<ProductSearchResult> productListWithnose = productService.findProductModel(modelId, WithnoseConstant.WITHNOSE_PROTECTION);

			model.addAttribute("productListNoWithnose", productListNoWithnose);
			model.addAttribute("productListWithnose", productListWithnose);

			// Find product buyer group from no Withnose product
			if (!productListWithnose.isEmpty()) {
				model.addAttribute("hasWithnoseBoard", true);
			}

			// Find product price
			String invoiceCode = UserUtil.getCurrentUser().getCustomer().getInvoiceCode();

			if (!productListNoWithnose.isEmpty()) {
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
		}

		return "pages-front/order/step2_view_model";
	}

	private void setSearchCondition(SearchProductForm form, Model model) {
		List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
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
        ProductTypeDTO parent = productService.getProductType(brandGroupId);
        List<ProductTypeDTO> types = productService.getProductTypes(UserUtil.getCurrentUser().getCustomer().getCustId(), brandGroupId);
        if (parent == null) {
            throw new B2BException(String.format("brand not found for brand id [%s]", brandGroupId));
        }
        if (types == null || types.isEmpty()) {
            throw new B2BException(String.format("product type not found for brand id [%s]", brandGroupId));
        }
        //
        String rootPath = environment.getProperty("upload.path");
        String parentPath = parent.getProductTypeName().toUpperCase().replaceAll(" ", "_").trim();
        List<String> files = new ArrayList<>();
        for (ProductTypeDTO type : types) {
            String name = type.getProductTypeName().toUpperCase().replaceAll(" ", "_").trim();
            files.add(String.format("%s/excel/%s/STB_ORDER_FORM_%s.xls", rootPath, name, name));
        }
        //
        byte[] zip = ArchiveUtil.zip(files);
        //
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", String.format("attachment; filename=%s%s.zip", "STB_ORDER_FORM_", parentPath));
        try (OutputStream output = response.getOutputStream()) {
            output.write(zip);
        }
    }

    /*
     * upload excel order
     */
    @RequestMapping(value = "upload-orders", method = RequestMethod.POST)
    public ModelAndView uploadExcelOrder(@RequestParam("file") MultipartFile file, @ModelAttribute("cart") Map<Long, ProductDTO> cart) {
        try {
            if (file.isEmpty()) {
                throw new B2BException("excel order file are not present in this request");
            }
            //
            List<ExcelOrderBean> orders = ExcelOrderUtil.parseOrder(file.getBytes());
            //
            if (orders == null) {
                throw new B2BException("order are not found in this upload file");
            }
            //
            List<ProductDTO> products = new ArrayList<>(orders.size());
            for (ExcelOrderBean order : orders) {
                ProductDTO product = productService.findByProductCode(order.getProductCode());
                if (product.getProductCode() == null) {
                    throw new B2BException(String.format("product not found for product code %s", order.getProductCode()));
                }
                product.setProductQuantity(order.getQuantity());
                products.add(product);
            }
            //
            for (ProductDTO product : products) {
                if (cart.get(product.getProductId()) == null) {
                    cart.put(product.getProductId(), product);
                } else {
                    ProductDTO productInCart = cart.get(product.getProductId());
                    productInCart.setProductQuantity(productInCart.getProductQuantity() + product.getProductQuantity());
                }
            }
            //
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
	public @ResponseBody void updateQuantityToCart(@RequestParam Long productId, @RequestParam Long quantity,
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
	String checkout(@ModelAttribute("cart") Map<Long, ProductDTO> cart, Model model) {
		// ----- Find product's price in cart ------
		String invoiceCode = UserUtil.getCurrentUser().getCustomer().getInvoiceCode();
		List<ProductSearchResult> products = productService.findProductPrice(cart, invoiceCode);
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
	String removeFromCart(@RequestParam Long productId, @ModelAttribute("cart") Map<Long, ProductDTO> cart, Model model) {
		log.info("/step3/remove POST");
		log.info("product id = " + productId);
		if (cart != null) {
			cart.remove(productId);
			log.info("After remove size: " + cart.size());
		} else {
			log.warn("Not found shopping cart");
		}
		return checkout(cart, model);
	}

	@RequestMapping(value = "step4/submit", method = RequestMethod.POST)
	String submitOrder(@RequestParam Long invoiceTo, @RequestParam Long dispatchTo, @RequestParam String shippingType, @RequestParam String customerRemark, @RequestParam String paymentMethod,
			@ModelAttribute("cart") Map<Long, ProductDTO> cart, Model model, SessionStatus session) {
		log.info("----- step4/submit POST");
		log.info("----- dispatchTo = " + dispatchTo);
		log.info("----- shippingType = " + shippingType);
		log.info("----- customerRemark = " + customerRemark);
		log.info("----- paymentMethod = " + paymentMethod);
		log.info("----- ----- cart size = " + cart.size());

		OrderDTO order = orderService.saveOrder(invoiceTo, dispatchTo, shippingType, customerRemark, paymentMethod, cart);
		model.addAttribute("order", order);

		// Clear Shopping Cart session
		// http://vard-lokkur.blogspot.com/2011/01/spring-mvc-session-attributes-handling.html
		session.setComplete();
		
		
		
		
		
		final SearchOrderDTO orderReport = orderService.findOrderForReport(order.getOrderCode());
		final List<OrdAddressDTO> ordAddresses = orderService.findOrderAddress(order.getOrderCode());
		for(OrdAddressDTO ordAddress : ordAddresses){
			log.info("received order address {} ", ordAddress);
			if(ordAddress.getType() == AddressConstant.ORDER_INVOICE_TO){
				orderReport.setInvoiceToAddress(ordAddress);
			}
			if(ordAddress.getType() == AddressConstant.ORDER_DISPATCH_TO){
				orderReport.setDispatchToAddress(ordAddress);
			}
		}
		List<SearchOrderDetailDTO> orderDetails = orderService.searchOrderDetail(order.getOrderCode());
		if(orderDetails != null && !orderDetails.isEmpty()){
			orderReport.setOrderDetails(orderDetails);
		}
		model.addAttribute("orderReport", orderReport);
		

		return "pages-front/order/step4_submit";
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
        setOrderSummarySearchFrom(form, model);
		Page<SearchOrderDTO> resultPage = orderService.searchOrder(form);
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("orderSummaryForm", form);
        return "pages-front/order/summary";
    }

    @RequestMapping(value = "summary/search-action", method = RequestMethod.GET)
    String orderSummarySearchAction(@ModelAttribute OrderSummaryForm form, Model model) {
        log.info("search condition: " + form.toString());
        setOrderSummarySearchFrom(form, model);
		Page<SearchOrderDTO> resultPage = orderService.searchOrder(form);
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("orderSummaryForm", form);
        return "pages-front/order/summary";
    }

	@RequestMapping(value = "summary/report/{orderCode}", method = RequestMethod.GET)
	String orderSummaryReport(@ModelAttribute OrderSummaryForm form, Model model, @PathVariable final String orderCode) {
		log.info("Report for order: {}",  orderCode);
		final SearchOrderDTO orderReport = orderService.findOrderForReport(orderCode);
		final List<OrdAddressDTO> ordAddresses = orderService.findOrderAddress(orderCode);
		for(OrdAddressDTO ordAddress : ordAddresses){
			log.info("received order address {} ", ordAddress);
			if(ordAddress.getType() == AddressConstant.ORDER_INVOICE_TO){
				orderReport.setInvoiceToAddress(ordAddress);
			}
			if(ordAddress.getType() == AddressConstant.ORDER_DISPATCH_TO){
				orderReport.setDispatchToAddress(ordAddress);
			}
		}
		List<SearchOrderDetailDTO> orderDetails = orderService.searchOrderDetail(orderCode);
		if(orderDetails != null && !orderDetails.isEmpty()){
			orderReport.setOrderDetails(orderDetails);
		}
		model.addAttribute("orderReport", orderReport);
		return "pages-front/order/report";
	}

    /**
     * Set all required search condition for order summary page
     * @param form Order Summary form
     * @param model Model attributes
     */
    private void setOrderSummarySearchFrom(final OrderSummaryForm form, final Model model){
        final List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
        model.addAttribute("productType", productTypes);
        final List<OrderStatusDTO> orderStatus = orderService.findAllOrderStatus();
        model.addAttribute("orderStatus", orderStatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public @ResponseBody
    String handleException(Exception e, HttpServletResponse response) {
        log.error(e.toString(), e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return e.getMessage();
    }

}
