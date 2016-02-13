package com.starboard.b2b.web.form.order;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.starboard.b2b.dto.PaymentMethodDTO;
import com.starboard.b2b.dto.PaymentTermDTO;
import com.starboard.b2b.dto.ProductPriceGroupDTO;
import com.starboard.b2b.dto.search.SearchOrderDTO;

public class OrderDecisionForm {

    private boolean editMode;
    private String splitItems;
    private SearchOrderDTO orderReport;
    private List<PaymentMethodDTO> paymentMethodList;
    private List<PaymentTermDTO> paymentTermList;
    private List<ProductPriceGroupDTO> productPriceGroupList;

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public String getSplitItems() {
        return splitItems;
    }

    public void setSplitItems(String splitItems) {
        this.splitItems = splitItems;
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

    public List<ProductPriceGroupDTO> getProductPriceGroupList() {
        return productPriceGroupList;
    }

    public void setProductPriceGroupList(List<ProductPriceGroupDTO> productPriceGroupList) {
        this.productPriceGroupList = productPriceGroupList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
