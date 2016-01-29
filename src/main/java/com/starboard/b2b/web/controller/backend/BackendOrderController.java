package com.starboard.b2b.web.controller.backend;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.OrderStatusConfig;
import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.web.form.order.OrderDecisionForm;
import com.starboard.b2b.web.form.order.OrderSummaryForm;
import com.starboard.b2b.web.form.order.SearchOrderForm;

@Controller
@RequestMapping("/backend/order")
public class BackendOrderController {

	private static final Logger log = LoggerFactory.getLogger(BackendOrderController.class);

	private static final String FROM_SEARCH_PAGE = "search";

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
	String orderSummarySearchAction(@ModelAttribute("form") OrderSummaryForm form, Model model) {
		log.info("search condition: " + form.toString());

		setForm(form, model);
		model.addAttribute("resultPage", orderService.searchOrder(form));
		model.addAttribute("searchOrderForm", new SearchOrderForm());

		return "pages-back/order/search";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	String viewOrder(@RequestParam(name = "orderId") Long orderId, @RequestParam(name = "from", required = false) String from, Model model) {
		log.info("Report for order: {}", orderId);

		OrderDecisionForm form = new OrderDecisionForm();
		// ----- find order -----
		SearchOrderDTO orderReport = null;

		if (orderId != null) {
			orderReport = orderService.findOrderForReport(orderId);
		} else {
			// orderReport = order;
		}

		if (orderReport == null) {
			throw new B2BException("Not found order");
		}

		form.setOrderReport(orderReport);
		form.setPaymentTermId(orderReport.getPaymentTermId());
		form.setPaymentMethodId(orderReport.getPaymentMethod());

		log.info("order status = " + orderReport.getOrderStatus());
		if (OrderStatusConfig.WAIT_FOR_APPROVE.equals(orderReport.getOrderStatusId())) {
			form.setEditMode(true);
		} else {
			form.setEditMode(false);
		}

		form.setPaymentMethodList(orderService.findAllPaymentMethod());
		form.setPaymentTermList(orderService.findAllPaymentTerm());
		form.setProductPriceGroupList(productService.listProductPriceGroup());

		// ---- find order address -----
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

		// ----- find order detail -----
		List<SearchOrderDetailDTO> dbOrderDetails = orderService.searchOrderDetail(orderReport.getOrderCode());

		if (dbOrderDetails != null && !dbOrderDetails.isEmpty()) {
			orderReport.setOrderDetails(dbOrderDetails);
		}

		// ----- Find selling order -----
		orderReport.setSalesOrders(orderService.listSO(orderReport.getOrderId()));

		model.addAttribute("approveForm", form);
		return "pages-back/order/view";
	}

	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	String approve(@ModelAttribute("approveForm") OrderDecisionForm form, long orderId, Model model) {
		log.info(form.toString());
		log.info("orderId: " + orderId);
		orderService.approve(orderId);
		return viewOrder(orderId, FROM_SEARCH_PAGE, model);
	}

	@RequestMapping(value = "/reject", method = RequestMethod.POST)
	String reject(@ModelAttribute("approveForm") OrderDecisionForm form, Model model) {
		return viewOrder(form.getOrderReport().getOrderId(), FROM_SEARCH_PAGE, model);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	String save(@ModelAttribute("approveForm") OrderDecisionForm form, Model model) {
		return viewOrder(form.getOrderReport().getOrderId(), FROM_SEARCH_PAGE, model);
	}
}
