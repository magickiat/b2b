
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductPrice implements Serializable {
    
    /** Creates a new instance of ProductPrice */
    public ProductPrice() {
    }
    public ProductPrice(
            String productCode	
            , String productPriceGroupId	
            , String productCurrency	
            , java.math.BigDecimal amount	
            , String productUnitId	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
            , double msrePrice	
        ) {
        this.productCode = productCode;	
        this.productPriceGroupId = productPriceGroupId;	
        this.productCurrency = productCurrency;	
        this.amount = amount;	
        this.productUnitId = productUnitId;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
        this.msrePrice = msrePrice;	
    }
    private String productCode;	
    private String productPriceGroupId;	
    private String productCurrency;	
    private java.math.BigDecimal amount;	
    private String productUnitId;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	
    private double msrePrice;	



    public String getProductCode() {
        return this.productCode;
    }		
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductPriceGroupId() {
        return this.productPriceGroupId;
    }		
    public void setProductPriceGroupId(String productPriceGroupId) {
        this.productPriceGroupId = productPriceGroupId;
    }
    public String getProductCurrency() {
        return this.productCurrency;
    }		
    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }
    public java.math.BigDecimal getAmount() {
        return this.amount;
    }		
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }
    public String getProductUnitId() {
        return this.productUnitId;
    }		
    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }
    public String getUserCreate() {
        return this.userCreate;
    }		
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }
    public String getUserUpdate() {
        return this.userUpdate;
    }		
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
    public java.sql.Timestamp getTimeCreate() {
        return this.timeCreate;
    }		
    public void setTimeCreate(java.sql.Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }
    public java.sql.Timestamp getTimeUpdate() {
        return this.timeUpdate;
    }		
    public void setTimeUpdate(java.sql.Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
    public double getMsrePrice() {
        return this.msrePrice;
    }		
    public void setMsrePrice(double msrePrice) {
        this.msrePrice = msrePrice;
    }



    public String toString() {
        return super.toString() + "productCode=[" + productCode + "]\n" + "productPriceGroupId=[" + productPriceGroupId + "]\n" + "productCurrency=[" + productCurrency + "]\n" + "amount=[" + amount + "]\n" + "productUnitId=[" + productUnitId + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n" + "msrePrice=[" + msrePrice + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductPrice)) {
                return false;
        }
        ProductPrice that = (ProductPrice) obj;
        if (!(that.getProductCode() == null ? this.getProductCode() == null
                        : that.getProductCode().equals(this.getProductCode()))) {
                return false;
        }
        if (!(that.getProductPriceGroupId() == null ? this.getProductPriceGroupId() == null
                        : that.getProductPriceGroupId().equals(this.getProductPriceGroupId()))) {
                return false;
        }
        if (!(that.getProductCurrency() == null ? this.getProductCurrency() == null
                        : that.getProductCurrency().equals(this.getProductCurrency()))) {
                return false;
        }
        if (!(that.getAmount() == null ? this.getAmount() == null
                        : 0 == that.getAmount().compareTo(this.getAmount()))) {
                return false;
        }
        if (!(that.getProductUnitId() == null ? this.getProductUnitId() == null
                        : that.getProductUnitId().equals(this.getProductUnitId()))) {
                return false;
        }
        if (!(that.getUserCreate() == null ? this.getUserCreate() == null
                        : that.getUserCreate().equals(this.getUserCreate()))) {
                return false;
        }
        if (!(that.getUserUpdate() == null ? this.getUserUpdate() == null
                        : that.getUserUpdate().equals(this.getUserUpdate()))) {
                return false;
        }
        if (!(that.getTimeCreate() == null ? this.getTimeCreate() == null
                        : that.getTimeCreate().equals(this.getTimeCreate()))) {
                return false;
        }
        if (!(that.getTimeUpdate() == null ? this.getTimeUpdate() == null
                        : that.getTimeUpdate().equals(this.getTimeUpdate()))) {
                return false;
        }
        if (that.getMsrePrice() != this.getMsrePrice()) {
                return false;
        }
    return true;
    }

}
