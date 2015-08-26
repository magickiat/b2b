
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpOrderStatusPK  implements Serializable {
    
    /** Creates a new instance of TmpOrderStatus */
    public TmpOrderStatusPK(
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
        if (!(obj instanceof TmpOrderStatus)) {
                return false;
        }
        TmpOrderStatus that = (TmpOrderStatus) obj;
        if (!(that.getOrderStatusId() == null ? this.getOrderStatusId() == null
                        : that.getOrderStatusId().equals(this.getOrderStatusId()))) {
                return false;
        }
    return true;
    }

}
