package com.starboard.b2b.web.form.order;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.PaymentTermDTO;
import com.starboard.b2b.dto.ProductPriceGroupDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;

public class OrderDecisionForm {
	private SearchOrderDTO orderReport;

	private boolean editMode;
	private String paymentMethodId;
	private String paymentTermId;
	
	private String remarkCustomer; // Customer remark
	private String remarkOrders; // Staff remark
	private String status;
	private long orderId;

	private List<PaymentMethodDTO> paymentMethodList;
	private List<PaymentTermDTO> paymentTermList;
	private List<SearchOrderDetailDTO> orderDetails;
	private List<ProductPriceGroupDTO> productPriceGroupList;

	public OrderDecisionForm() {
	}

	public SearchOrderDTO getOrderReport() {
		return orderReport;
	}

	public void setOrderReport(SearchOrderDTO orderReport) {
		this.orderReport = orderReport;
	}

	public List<PaymentMethodDTO> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<PaymentMethodDTO> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public List<PaymentTermDTO> getPaymentTermList() {
		return paymentTermList;
	}

	public void setPaymentTermList(List<PaymentTermDTO> paymentTermList) {
		this.paymentTermList = paymentTermList;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public List<SearchOrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<SearchOrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<ProductPriceGroupDTO> getProductPriceGroupList() {
		return productPriceGroupList;
	}

	public void setProductPriceGroupList(List<ProductPriceGroupDTO> productPriceGroupList) {
		this.productPriceGroupList = productPriceGroupList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getRemarkCustomer() {
		return remarkCustomer;
	}

	public void setRemarkCustomer(String remarkCustomer) {
		this.remarkCustomer = remarkCustomer;
	}

	public String getRemarkOrders() {
		return remarkOrders;
	}

	public void setRemarkOrders(String remarkOrders) {
		this.remarkOrders = remarkOrders;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
}
