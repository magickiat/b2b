
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpRoPK  implements Serializable {
    
    /** Creates a new instance of TmpRo */
    public TmpRoPK(
            long orderProductId	
        ) {
        this.orderProductId = orderProductId;	
    }
    private long orderProductId;	

    public long getOrderProductId() {
        return this.orderProductId;
    }		
    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String toString() {
        return super.toString() + " " + orderProductId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpRo)) {
                return false;
        }
        TmpRo that = (TmpRo) obj;
        if (that.getOrderProductId() != this.getOrderProductId()) {
                return false;
        }
    return true;
    }

}
