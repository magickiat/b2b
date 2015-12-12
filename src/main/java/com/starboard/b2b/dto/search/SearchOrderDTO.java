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
	private String paymentMethod;
	private String shippingType;
	
	private OrdAddressDTO dispatchToAddress;
	private OrdAddressDTO invoiceToAddress;
	
	private List<SearchOrderDetailDTO> orderDetails;
	private List<SoDTO> salesOrders;
	private List<String> documents;

	public SearchOrderDTO() {
	}

	public SearchOrderDTO(String orderCode, String customerName, String productTypeName, Date orderDate, Date expectShipmentDate,
			String orderStatus, String paymentMethod, String shippingType) {
		super();
		this.orderCode = orderCode;
		this.customerName = customerName;
		this.productTypeName = productTypeName;
		this.orderDate = orderDate;
		this.expectShipmentDate = expectShipmentDate;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.shippingType = shippingType;
	}

	public SearchOrderDTO(long orderId, String orderCode, String customerName, String productTypeName, Date orderDate, Date expectShipmentDate,
						  String orderStatus, String paymentMethod, String shippingType) {
		this.orderId = orderId;
		this.orderCode = orderCode;
		this.customerName = customerName;
		this.productTypeName = productTypeName;
		this.orderDate = orderDate;
		this.expectShipmentDate = expectShipmentDate;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.shippingType = shippingType;
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
}
