
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class OrderStatus implements Serializable {
    
    /** Creates a new instance of OrderStatus */
    public OrderStatus() {
    }
    public OrderStatus(
            String orderStatusId	
            , String orderStatusName	
            , String orderStatusDescription	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.orderStatusId = orderStatusId;	
        this.orderStatusName = orderStatusName;	
        this.orderStatusDescription = orderStatusDescription;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String orderStatusId;	
    private String orderStatusName;	
    private String orderStatusDescription;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getOrderStatusId() {
        return this.orderStatusId;
    }		
    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
    public String getOrderStatusName() {
        return this.orderStatusName;
    }		
    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
    public String getOrderStatusDescription() {
        return this.orderStatusDescription;
    }		
    public void setOrderStatusDescription(String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
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
        return super.toString() + "orderStatusId=[" + orderStatusId + "]\n" + "orderStatusName=[" + orderStatusName + "]\n" + "orderStatusDescription=[" + orderStatusDescription + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof OrderStatus)) {
                return false;
        }
        OrderStatus that = (OrderStatus) obj;
        if (!(that.getOrderStatusId() == null ? this.getOrderStatusId() == null
                        : that.getOrderStatusId().equals(this.getOrderStatusId()))) {
                return false;
        }
        if (!(that.getOrderStatusName() == null ? this.getOrderStatusName() == null
                        : that.getOrderStatusName().equals(this.getOrderStatusName()))) {
                return false;
        }
        if (!(that.getOrderStatusDescription() == null ? this.getOrderStatusDescription() == null
                        : that.getOrderStatusDescription().equals(this.getOrderStatusDescription()))) {
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
