package com.starboard.b2b.dto.search;

import com.starboard.b2b.dto.OrdAddressDTO;
import com.starboard.b2b.dto.SoDTO;

import java.util.Date;
import java.util.List;

public class SearchOrderDTO {

	private long orderId;
	private String orderCode;
	private String customerName;
	private String productTypeName;
	private Date orderDate;
	private Date expectShipmentDate;
	private String orderStatus;
	private String orderStatusId;
	private String paymentMethod;
	private String shippingType;

	private String paymentTermId;

	private String paymentTermDescription;
	private String remarkCustomer; // Customer remark
	private String remarkOrders; // Staff remark
	private String custCode;

	private OrdAddressDTO dispatchToAddress;
	private OrdAddressDTO invoiceToAddress;

	private List<SearchOrderDetailDTO> orderDetails;
	private List<SoDTO> salesOrders;
	private List<String> documents;

	public SearchOrderDTO() {
	}

	public SearchOrderDTO(String orderCode, String customerName, String productTypeName, Date orderDate, Date expectShipmentDate, String orderStatus,
			String paymentMethod, String shippingType, String paymentTermDescription, String remarkCustomer, String paymentTermId, String orderStatusId) {
		this.orderCode = orderCode;
		this.customerName = customerName;
		this.productTypeName = productTypeName;
		this.orderDate = orderDate;
		this.expectShipmentDate = expectShipmentDate;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.shippingType = shippingType;
		this.paymentTermDescription = paymentTermDescription;
		this.remarkCustomer = remarkCustomer;
		this.paymentTermId = paymentTermId;
		this.orderStatusId = orderStatusId;
	}

	public SearchOrderDTO(long orderId, String orderCode, String customerName, String productTypeName, Date orderDate, Date expectShipmentDate,
			String orderStatus, String paymentMethod, String shippingType, String paymentTermDescription, String remarkCustomer,
			String paymentTermId, String orderStatusId, String remarkOrders, String custCode) {
		this.orderId = orderId;
		this.orderCode = orderCode;
		this.customerName = customerName;
		this.productTypeName = productTypeName;
		this.orderDate = orderDate;
		this.expectShipmentDate = expectShipmentDate;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.shippingType = shippingType;
		this.paymentTermDescription = paymentTermDescription;
		this.remarkCustomer = remarkCustomer;
		this.paymentTermId = paymentTermId;
		this.orderStatusId = orderStatusId;
		this.remarkOrders = remarkOrders;
		this.custCode = custCode;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getExpectShipmentDate() {
		return expectShipmentDate;
	}

	public void setExpectShipmentDate(Date expectShipmentDate) {
		this.expectShipmentDate = expectShipmentDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public OrdAddressDTO getDispatchToAddress() {
		return dispatchToAddress;
	}

	public void setDispatchToAddress(OrdAddressDTO dispatchToAddress) {
		this.dispatchToAddress = dispatchToAddress;
	}

	public OrdAddressDTO getInvoiceToAddress() {
		return invoiceToAddress;
	}

	public void setInvoiceToAddress(OrdAddressDTO invoiceToAddress) {
		this.invoiceToAddress = invoiceToAddress;
	}

	public String getShippingType() {
		return shippingType;
	}

	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}

	public List<SearchOrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<SearchOrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<SoDTO> getSalesOrders() {
		return salesOrders;
	}

	public void setSalesOrders(List<SoDTO> salesOrders) {
		this.salesOrders = salesOrders;
	}

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}

	public String getPaymentTermDescription() {
		return paymentTermDescription;
	}

	public void setPaymentTermDescription(String paymentTermDescription) {
		this.paymentTermDescription = paymentTermDescription;
	}

	public String getRemarkCustomer() {
		return remarkCustomer;
	}

	public void setRemarkCustomer(String remarkCustomer) {
		this.remarkCustomer = remarkCustomer;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getRemarkOrders() {
		return remarkOrders;
	}

	public void setRemarkOrders(String remarkOrders) {
		this.remarkOrders = remarkOrders;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
}
