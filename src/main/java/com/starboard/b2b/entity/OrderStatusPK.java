
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class OrderStatusPK  implements Serializable {
    
    /** Creates a new instance of OrderStatus */
    public OrderStatusPK(
            String orderStatusId	
        ) {
        this.orderStatusId = orderStatusId;	
    }
    private String orderStatusId;	

    public String getOrderStatusId() {
        return this.orderStatusId;
    }		
    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String toString() {
        return super.toString() + " " + orderStatusId;
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
    return true;
    }

}
