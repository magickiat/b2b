
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class OrdAddressPK  implements Serializable {
    
    /** Creates a new instance of OrdAddress */
    public OrdAddressPK(
            long orderAddressId	
            , long orderId	
        ) {
        this.orderAddressId = orderAddressId;	
        this.orderId = orderId;	
    }
    private long orderAddressId;	
    private long orderId;	

    public long getOrderAddressId() {
        return this.orderAddressId;
    }		
    public void setOrderAddressId(long orderAddressId) {
        this.orderAddressId = orderAddressId;
    }
    public long getOrderId() {
        return this.orderId;
    }		
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String toString() {
        return super.toString() + " " + orderAddressId + " " + orderId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof OrdAddress)) {
                return false;
        }
        OrdAddress that = (OrdAddress) obj;
        if (that.getOrderAddressId() != this.getOrderAddressId()) {
                return false;
        }
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
    return true;
    }

}
