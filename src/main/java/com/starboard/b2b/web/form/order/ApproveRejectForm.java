package com.starboard.b2b.web.form.order;

import java.util.List;

import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.PaymentTermDTO;
import com.starboard.b2b.dto.ProductPriceGroupDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;
import com.starboard.b2b.dto.search.SearchOrderDetailDTO;

public class ApproveRejectForm {
	private SearchOrderDTO orderReport;

	private boolean editMode;
	private String paymentMethodId;
	private String paymentTermId;

	private List<PaymentMethodDTO> paymentMethodList;
	private List<PaymentTermDTO> paymentTermList;
	private List<SearchOrderDetailDTO> orderDetails;
	private List<ProductPriceGroupDTO> productPriceGroupList;

	public ApproveRejectForm() {
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
}
