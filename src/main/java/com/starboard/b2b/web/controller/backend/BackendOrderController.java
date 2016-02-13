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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
import com.starboard.b2b.web.form.order.OrderDecisionForm;
import com.starboard.b2b.web.form.order.OrderSummaryForm;
import com.starboard.b2b.web.form.order.SearchOrderForm;

@Controller
@RequestMapping("/backend/order")
@SessionAttributes(value = {"orderDetails"})
public class BackendOrderController {

    private static final Logger log = LoggerFactory.getLogger(BackendOrderController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RoSyncService roSyncService;

    private void setForm(final OrderSummaryForm form, final Model model) {
        final List<ProductTypeDTO> productTypes = productService.findProductTypeByBrandId(form.getBrandId());
        model.addAttribute("productType", productTypes);
        final List<OrderStatusDTO> orderStatus = orderService.findAllOrderStatus();
        model.addAttribute("orderStatus", orderStatus);
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    String search(Model model) {
        OrderSummaryForm form = new OrderSummaryForm();
        setForm(form, model);
        model.addAttribute("resultPage", orderService.searchOrder(form));
        model.addAttribute("searchOrderForm", new SearchOrderForm());
        return "pages-back/order/search";
    }

    @RequestMapping(value = "search-action", method = RequestMethod.GET)
    String orderSummarySearchAction(@ModelAttribute("form") OrderSummaryForm form, Model model) {
        setForm(form, model);
        model.addAttribute("resultPage", orderService.searchOrder(form));
        model.addAttribute("searchOrderForm", new SearchOrderForm());
        return "pages-back/order/search";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    String viewOrder(@RequestParam(name = "orderId") Long orderId, Model model) {
        if (orderId == null) {
            throw new B2BException("Order ID not found");
        }
        OrderDecisionForm form = new OrderDecisionForm();
        SearchOrderDTO orderReport = orderService.findOrderForReport(orderId);
        if (orderReport == null) {
            throw new B2BException("Order not found");
        }
        // find order address
        final List<OrdAddressDTO> ordAddresses = orderService.findOrderAddress(orderReport.getOrderCode());
        for (OrdAddressDTO ordAddress : ordAddresses) {
            if (ordAddress.getType().equals(AddressConstant.ORDER_INVOICE_TO)) {
                orderReport.setInvoiceToAddress(ordAddress);
            }
            if (ordAddress.getType().equals(AddressConstant.ORDER_DISPATCH_TO)) {
                orderReport.setDispatchToAddress(ordAddress);
            }
        }
        // find order detail
        List<SearchOrderDetailDTO> dbOrderDetails = orderService.searchOrderDetail(orderReport.getOrderId());
        if (dbOrderDetails != null && !dbOrderDetails.isEmpty()) {
            orderReport.setOrderDetails(dbOrderDetails);
        }
        // Find selling order
        orderReport.setSalesOrders(orderService.listSO(orderReport.getOrderId()));

        if (OrderStatusConfig.WAIT_FOR_APPROVE.equals(orderReport.getOrderStatusId())) {
            form.setEditMode(true);
        } else {
            form.setEditMode(false);
        }
        //
        form.setPaymentMethodList(orderService.findAllPaymentMethod());
        form.setPaymentTermList(orderService.findAllPaymentTerm());
        form.setProductPriceGroupList(productService.listProductPriceGroup());
        //
        form.setOrderReport(orderReport);
        model.addAttribute("approveForm", form);
        return "pages-back/order/view";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    String approve(@RequestParam(name = "orderId", defaultValue = "0", required = true) Long orderId, Model model) {
        OrderDTO order = orderService.findOrder(orderId);
        if (order == null) {
            throw new B2BException("Not found order " + orderId);
        }
        orderService.approve(order);
        roSyncService.syncRoFromB2BtoAX(orderId);
        try {
            emailService.sendEmailOrder(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        try {
            emailService.sendEmailInternal(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return viewOrder(orderId, model);
    }

    @RequestMapping(value = "/reject", method = RequestMethod.GET)
    String reject(@RequestParam(name = "orderId", defaultValue = "0", required = true) Long orderId, Model model) {
        OrderDTO order = orderService.findOrder(orderId);
        if (order == null) {
            throw new B2BException("Not found order " + orderId);
        }
        orderService.reject(order);
        try {
            emailService.sendEmailOrder(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return viewOrder(orderId, model);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    String save(@ModelAttribute("approveForm") OrderDecisionForm form, Model model) {
        orderService.updateOrder(form);
        return viewOrder(form.getOrderReport().getOrderId(), model);
    }
}
