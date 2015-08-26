
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpOrdersPK  implements Serializable {
    
    /** Creates a new instance of TmpOrders */
    public TmpOrdersPK(
            long orderId	
        ) {
        this.orderId = orderId;	
    }
    private long orderId;	

    public long getOrderId() {
        return this.orderId;
    }		
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String toString() {
        return super.toString() + " " + orderId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpOrders)) {
                return false;
        }
        TmpOrders that = (TmpOrders) obj;
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
    return true;
    }

}
