package com.starboard.b2b.web.form.order;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.starboard.b2b.dto.search.SearchOrderDetailDTO;

public class SplitOrderForm {
	private int splitNum;
	private int totalSplitQty;
	private SearchOrderDetailDTO orderDetail;
	private List<SearchOrderDetailDTO> splitOrderDetails;

	public int getSplitNum() {
		return splitNum;
	}

	public void setSplitNum(int splitNum) {
		this.splitNum = splitNum;
	}

	public SearchOrderDetailDTO getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(SearchOrderDetailDTO orderDetail) {
		this.orderDetail = orderDetail;
	}

	public List<SearchOrderDetailDTO> getSplitOrderDetails() {
		return splitOrderDetails;
	}

	public void setSplitOrderDetails(List<SearchOrderDetailDTO> splitOrderDetails) {
		this.splitOrderDetails = splitOrderDetails;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public int getTotalSplitQty() {
		return totalSplitQty;
	}

	public void setTotalSplitQty(int totalSplitQty) {
		this.totalSplitQty = totalSplitQty;
	}
}
