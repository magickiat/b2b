
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class So implements Serializable {
    
    /** Creates a new instance of So */
    public So() {
    }
    public So(
            long soId	
            , long orderId	
            , String shippingId	
            , String paymentTermId	
            , String paymentMethodId	
            , java.sql.Timestamp expectShipmentDate	
            , String soNo	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.soId = soId;	
        this.orderId = orderId;	
        this.shippingId = shippingId;	
        this.paymentTermId = paymentTermId;	
        this.paymentMethodId = paymentMethodId;	
        this.expectShipmentDate = expectShipmentDate;	
        this.soNo = soNo;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long soId;	
    private long orderId;	
    private String shippingId;	
    private String paymentTermId;	
    private String paymentMethodId;	
    private java.sql.Timestamp expectShipmentDate;	
    private String soNo;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getSoId() {
        return this.soId;
    }		
    public void setSoId(long soId) {
        this.soId = soId;
    }
    public long getOrderId() {
        return this.orderId;
    }		
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public String getShippingId() {
        return this.shippingId;
    }		
    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }
    public String getPaymentTermId() {
        return this.paymentTermId;
    }		
    public void setPaymentTermId(String paymentTermId) {
        this.paymentTermId = paymentTermId;
    }
    public String getPaymentMethodId() {
        return this.paymentMethodId;
    }		
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
    public java.sql.Timestamp getExpectShipmentDate() {
        return this.expectShipmentDate;
    }		
    public void setExpectShipmentDate(java.sql.Timestamp expectShipmentDate) {
        this.expectShipmentDate = expectShipmentDate;
    }
    public String getSoNo() {
        return this.soNo;
    }		
    public void setSoNo(String soNo) {
        this.soNo = soNo;
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



    public String toString() {
        return super.toString() + "soId=[" + soId + "]\n" + "orderId=[" + orderId + "]\n" + "shippingId=[" + shippingId + "]\n" + "paymentTermId=[" + paymentTermId + "]\n" + "paymentMethodId=[" + paymentMethodId + "]\n" + "expectShipmentDate=[" + expectShipmentDate + "]\n" + "soNo=[" + soNo + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof So)) {
                return false;
        }
        So that = (So) obj;
        if (that.getSoId() != this.getSoId()) {
                return false;
        }
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
        if (!(that.getShippingId() == null ? this.getShippingId() == null
                        : that.getShippingId().equals(this.getShippingId()))) {
                return false;
        }
        if (!(that.getPaymentTermId() == null ? this.getPaymentTermId() == null
                        : that.getPaymentTermId().equals(this.getPaymentTermId()))) {
                return false;
        }
        if (!(that.getPaymentMethodId() == null ? this.getPaymentMethodId() == null
                        : that.getPaymentMethodId().equals(this.getPaymentMethodId()))) {
                return false;
        }
        if (!(that.getExpectShipmentDate() == null ? this.getExpectShipmentDate() == null
                        : that.getExpectShipmentDate().equals(this.getExpectShipmentDate()))) {
                return false;
        }
        if (!(that.getSoNo() == null ? this.getSoNo() == null
                        : that.getSoNo().equals(this.getSoNo()))) {
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
    return true;
    }

}
