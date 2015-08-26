
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ShippingTypePK  implements Serializable {
    
    /** Creates a new instance of ShippingType */
    public ShippingTypePK(
            String shippingTypeId	
        ) {
        this.shippingTypeId = shippingTypeId;	
    }
    private String shippingTypeId;	

    public String getShippingTypeId() {
        return this.shippingTypeId;
    }		
    public void setShippingTypeId(String shippingTypeId) {
        this.shippingTypeId = shippingTypeId;
    }

    public String toString() {
        return super.toString() + " " + shippingTypeId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ShippingType)) {
                return false;
        }
        ShippingType that = (ShippingType) obj;
        if (!(that.getShippingTypeId() == null ? this.getShippingTypeId() == null
                        : that.getShippingTypeId().equals(this.getShippingTypeId()))) {
                return false;
        }
    return true;
    }

}
