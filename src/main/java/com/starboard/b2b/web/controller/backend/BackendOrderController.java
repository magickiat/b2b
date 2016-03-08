package com.starboard.b2b.web.controller.backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.OrderStatusConfig;
import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.EmailService;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.service.RoSyncService;
import com.starboard.b2b.util.DateTimeUtil;
import com.starboard.b2b.util.UserUtil;
import com.starboard.b2b.web.form.order.OrderDecisionForm;
import com.starboard.b2b.web.form.order.OrderSummaryForm;
import com.starboard.b2b.web.form.order.SearchOrderForm;
import com.starboard.b2b.web.form.order.SplitOrderForm;

@Controller
@RequestMapping("/backend/order")
// @SessionAttributes(value = { "orderDetails" })
public class BackendOrderController {

	private static final Logger log = LoggerFactory.getLogger(BackendOrderController.class);

	private static final String SESSION_ORDER_DETAILS_FORM = "orderDetailsForm";
	private static final String SPLIT_FORM = "splitForm";

	@Autowired
	private Environment environment;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private RoSyncService roSyncService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

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
	String orderSummarySearchAction(@ModelAttribute("form") OrderSummaryForm form, Model model) {
		log.info("search condition: " + form.toString());

		setForm(form, model);
		model.addAttribute("resultPage", orderService.searchOrder(form));
		model.addAttribute("searchOrderForm", new SearchOrderForm());

		return "pages-back/order/search";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	String viewOrder(@RequestParam(name = "orderId") Long orderId, Model model, HttpServletRequest request) {
		log.info("Report for order: {}", orderId);

		OrderDecisionForm form = new OrderDecisionForm();
		// ----- find order -----
		SearchOrderDTO orderReport = null;

		if (orderId != null) {
			orderReport = orderService.findOrderForReport(orderId);
		}

		if (orderReport == null) {
			throw new B2BException("Not found order");
		}

		// set value form
		form.setOrderReport(orderReport);
		form.setPaymentTermId(orderReport.getPaymentTermId());
		form.setPaymentMethodId(orderReport.getPaymentMethod());
		form.setRemarkCustomer(orderReport.getRemarkCustomer());
		form.setRemarkOrders(orderReport.getRemarkOrders());

		log.info("order status = " + orderReport.getOrderStatus());
		if (OrderStatusConfig.WAIT_FOR_APPROVE.equals(orderReport.getOrderStatusId())) {
			form.setEditMode(true);
		} else {
			form.setEditMode(false);
		}

		// ----- find order detail -----
		List<SearchOrderDetailDTO> dbOrderDetails = orderService.searchOrderDetail(orderReport.getOrderCode());

		if (dbOrderDetails != null && !dbOrderDetails.isEmpty()) {
			form.setOrderDetails(dbOrderDetails);
			log.info("form.getOrderDetails() size: " + form.getOrderDetails().size());
		} else {
			request.getSession().removeAttribute(SESSION_ORDER_DETAILS_FORM);
		}

		setOrderFormValue(form);

		model.addAttribute("approveForm", form);
		request.getSession().setAttribute(SESSION_ORDER_DETAILS_FORM, form);

		return "pages-back/order/view";
	}

	private void setOrderFormValue(OrderDecisionForm form) {

		form.setPaymentMethodList(orderService.findAllPaymentMethod());
		form.setPaymentTermList(orderService.findAllPaymentTerm());
		form.setProductPriceGroupList(productService.listProductPriceGroup());

		// ---- find order address -----
		final List<OrdAddressDTO> ordAddresses = orderService.findOrderAddress(form.getOrderReport().getOrderCode());
		for (OrdAddressDTO ordAddress : ordAddresses) {
			log.info("received order address {} ", ordAddress);
			if (ordAddress.getType().equals(AddressConstant.ORDER_INVOICE_TO)) {
				form.getOrderReport().setInvoiceToAddress(ordAddress);
			}
			if (ordAddress.getType().equals(AddressConstant.ORDER_DISPATCH_TO)) {
				form.getOrderReport().setDispatchToAddress(ordAddress);
			}
		}

		// ----- Find selling order -----
		form.getOrderReport().setSalesOrders(orderService.listSO(form.getOrderReport().getOrderId()));

	}

	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	String approve(@ModelAttribute("approveForm") OrderDecisionForm form, Model model, HttpServletRequest request) {
		log.info(form.toString());
		log.info("orderId: " + form.getOrderReport().getOrderId());

		OrderDTO order = orderService.findOrder(form.getOrderReport().getOrderId());
		if (order == null) {
			throw new B2BException("Not found order " + form.getOrderReport().getOrderId());
		}

		// ----- approve -----
		orderService.updateOrder(form);
		orderService.approve(order);
		roSyncService.syncRoFromB2BtoAX(form.getOrderReport().getOrderId());

		// ----- send mail order -----
		String host = environment.getProperty("base.url");
		if (StringUtils.isEmpty(host)) {
			throw new B2BException("Not found host config");
		}

		try {
			emailService.sendEmailOrderToCustomer(order, host);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		// ----- send mail to staff -----
		try {
			emailService.sendEmailOrderToStaff(order, host);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return viewOrder(form.getOrderReport().getOrderId(), model, request);
	}

	@RequestMapping(value = "/reject", method = RequestMethod.POST)
	String reject(@ModelAttribute("approveForm") OrderDecisionForm form, Model model, HttpServletRequest request) {
		OrderDTO order = orderService.findOrder(form.getOrderReport().getOrderId());
		if (order == null) {
			throw new B2BException("Not found order " + form.getOrderReport().getOrderId());
		}

		// ----- reject -----
		orderService.reject(order);

		// ----- send mail order -----
		String host = environment.getProperty("base.url");
		if (StringUtils.isEmpty(host)) {
			throw new B2BException("Not found host config");
		}

		try {
			emailService.sendEmailOrderToCustomer(order, host);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		// ----- send mail to staff -----
		try {
			emailService.sendEmailOrderToStaff(order, host);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return viewOrder(form.getOrderReport().getOrderId(), model, request);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	String save(@ModelAttribute("approveForm") OrderDecisionForm form, Model model, HttpServletRequest request) {
		log.info("Form: " + form);
		log.info("orderDtails: " + form.getOrderDetails());
		if (form.isEditMode()) {
			orderService.updateOrder(form);
		} else {
			throw new B2BException("Not save because it not edit mode");
		}

		return viewOrder(form.getOrderReport().getOrderId(), model, request);
	}

	@RequestMapping(value = "/change-price-group", method = RequestMethod.POST)
	String changePriceGroup(@ModelAttribute("approveForm") OrderDecisionForm form, Model model, HttpServletRequest request) {
		log.info("Change price group: " + form);
		// ----- set require list form -----
		setOrderFormValue(form);
		
		// ----- remove order details when click remove -----
		for(SearchOrderDetailDTO dto : form.getOrderDetails()){
			if(dto.getProductId() == null){
				form.getOrderDetails().remove(dto);
				break;
			}
		}

		// ----- find new price group -----
		if (form.getOrderDetails() != null && !form.getOrderDetails().isEmpty()) {
			log.info("form.getOrderDetails() size: " + form.getOrderDetails().size());
			productService.findOrderPriceList(form.getOrderDetails());
		}

		model.addAttribute("approveForm", form);
		request.getSession().setAttribute(SESSION_ORDER_DETAILS_FORM, form);

		return "pages-back/order/view";
	}

	@RequestMapping(value = "/split", method = RequestMethod.POST)
	String split(@ModelAttribute("approveForm") OrderDecisionForm form, Model model, HttpServletRequest request) {
		log.info("split");
		log.info("Form: " + form);

		List<SearchOrderDetailDTO> orderDetails = form.getOrderDetails();

		SearchOrderDetailDTO orderDetail = null;
		for (SearchOrderDetailDTO dto : orderDetails) {
			if (dto.getOrderDetailId() == form.getSplitOrderDetailId()) {
				orderDetail = dto;
				break;
			}
		}

		log.info("Order Detail: " + orderDetail);
		if (orderDetail == null) {
			throw new B2BException("Not found order detail id: " + form.getSplitOrderDetailId());
		}
		if (orderDetail.getAmount() <= 0) {
			throw new B2BException("Order detail id: " + form.getSplitOrderDetailId() + " not have any quantity");
		}

		// ----- set form -----
		List<SearchOrderDetailDTO> splitOrderDetails = new ArrayList<>();
		splitOrderDetails.add(orderDetail);

		SplitOrderForm splitForm = new SplitOrderForm();
		splitForm.setSplitNum(1);
		splitForm.setOrderDetail(orderDetail);
		splitForm.setSplitOrderDetails(splitOrderDetails);

		form.setPaymentMethodList(orderService.findAllPaymentMethod());
		form.setPaymentTermList(orderService.findAllPaymentTerm());
		form.setProductPriceGroupList(productService.listProductPriceGroup());

		model.addAttribute(SPLIT_FORM, splitForm);
		request.getSession().setAttribute(SESSION_ORDER_DETAILS_FORM, form);

		return "pages-back/order/split";
	}

	@RequestMapping(value = "/split-action", method = RequestMethod.POST)
	String splitOrderDetail(@ModelAttribute("splitForm") SplitOrderForm form, Model model, HttpServletRequest request) {
		log.info("Split order form: " + form);

		if (form.getSplitNum() <= 0) {
			model.addAttribute("errorMsg", "Invalid number of split");
		} else if (form.getSplitNum() > form.getOrderDetail().getAmount()) {
			model.addAttribute("errorMsg", "Maximum split line is " + form.getOrderDetail().getAmount());
		} else {
			List<SearchOrderDetailDTO> splitOrderDetails = new ArrayList<>();
			SearchOrderDetailDTO original = form.getOrderDetail();
			for (int i = 0; i < form.getSplitNum(); i++) {
				SearchOrderDetailDTO dto = new SearchOrderDetailDTO();
				BeanUtils.copyProperties(original, dto);
				dto.setAmount(1);
				dto.setShiped(0);
				dto.setPending(1);
				splitOrderDetails.add(dto);
			}

			form.setSplitOrderDetails(splitOrderDetails);
			changePriceGroupForSplit(form, model, request);
		}

		return "pages-back/order/split";
	}

	@RequestMapping(value = "/change-price-group-for-split", method = RequestMethod.POST)
	String changePriceGroupForSplit(@ModelAttribute("splitForm") SplitOrderForm form, Model model, HttpServletRequest request) {
		log.info("Change price group for split: " + form);

		// ----- find new price group -----
		log.info("form.getSplitOrderDetails() size: " + form.getSplitOrderDetails().size());
		productService.findOrderPriceList(form.getSplitOrderDetails());

		return "pages-back/order/split";
	}

	// save-split-order
	@RequestMapping(value = "/save-split-order", method = RequestMethod.POST)
	String saveSplitOrder(@ModelAttribute("splitForm") SplitOrderForm form, Model model, HttpServletRequest request) {
		log.info("Save split order: " + form);

		OrderDecisionForm orderDetailForm = (OrderDecisionForm) request.getSession().getAttribute(SESSION_ORDER_DETAILS_FORM);
		if (orderDetailForm == null) {
			throw new B2BException("Not found any session for Split Order");
		}

		// ----- Remove original order detail from session -----
		log.info("Remove original order detail from session");
		List<SearchOrderDetailDTO> orderDetails = orderDetailForm.getOrderDetails();
		for (SearchOrderDetailDTO dto : orderDetails) {
			if (dto.getOrderDetailId() == form.getOrderDetail().getOrderDetailId()) {
				log.info("Remove : " + dto);
				orderDetails.remove(dto);
				break;
			}
		}

		// ----- Reset shiped item-----
		List<SearchOrderDetailDTO> splitOrderDetails = form.getSplitOrderDetails();
		for (SearchOrderDetailDTO dto : splitOrderDetails) {
			dto.setShiped(0);
			dto.setUserCreate(UserUtil.getCurrentUsername());
			dto.setTimeCreate(DateTimeUtil.getCurrentDate());
			dto.setUserUpdate(null);
			dto.setTimeUpdate(null);
		}

		// ----- Set new split order details -----
		orderDetails.addAll(form.getSplitOrderDetails());

		return changePriceGroup(orderDetailForm, model, request);
	}
}
