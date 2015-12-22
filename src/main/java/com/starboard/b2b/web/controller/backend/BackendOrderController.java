package com.starboard.b2b.web.controller.backend;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starboard.b2b.common.AddressConstant;
import com.starboard.b2b.common.OrderStatus;
import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.OrderStatusDTO;
import com.starboard.b2b.dto.ProductTypeDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.service.OrderService;
import com.starboard.b2b.service.ProductService;
import com.starboard.b2b.web.form.order.ApproveRejectForm;
import com.starboard.b2b.web.form.order.OrderSummaryForm;
import com.starboard.b2b.web.form.order.SearchOrderForm;

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

	@RequestMapping(value = "view/{orderCode}", method = RequestMethod.GET)
	String viewOrder(@PathVariable final String orderCode, Model model) {
		log.info("Report for order: {}", orderCode);
		
		ApproveRejectForm form = new ApproveRejectForm();
		// ----- find order -----
		final SearchOrderDTO orderReport = orderService.findOrderForReport(orderCode);
		if(orderReport == null){
			throw new B2BException("Not found order");
		}
		
		form.setOrderReport(orderReport);
		form.setPaymentTermId(orderReport.getPaymentTermId());
		form.setPaymentMethodId(orderReport.getPaymentMethod());

		log.info("order status = " + orderReport.getOrderStatus());
		if (OrderStatus.WAIT_FOR_APPROVE.equals(orderReport.getOrderStatusId())) {
			form.setEditMode(true);
		}else{
			form.setEditMode(false);
		}

		form.setPaymentMethodList(orderService.findAllPaymentMethod());
		form.setPaymentTermList(orderService.findAllPaymentTerm());
		form.setProductPriceGroupList(productService.listProductPriceGroup());
		
		
		// ---- find order address -----
		final List<OrdAddressDTO> ordAddresses = orderService.findOrderAddress(orderCode);
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
		List<SearchOrderDetailDTO> orderDetails = orderService.searchOrderDetail(orderCode);
		if (orderDetails != null && !orderDetails.isEmpty()) {
			orderReport.setOrderDetails(orderDetails);
		}

		model.addAttribute("form", form);

		return "pages-back/order/view";
	}
	
	
	String approveReject(ApproveRejectForm form, Model model){
		return viewOrder(form.getOrderReport().getOrderCode(), model);
	}
}
