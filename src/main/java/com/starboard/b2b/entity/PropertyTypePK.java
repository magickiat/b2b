
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PropertyTypePK  implements Serializable {
    
    /** Creates a new instance of PropertyType */
    public PropertyTypePK(
            long propertyTypeId	
        ) {
        this.propertyTypeId = propertyTypeId;	
    }
    private long propertyTypeId;	

    public long getPropertyTypeId() {
        return this.propertyTypeId;
    }		
    public void setPropertyTypeId(long propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public String toString() {
        return super.toString() + " " + propertyTypeId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof PropertyType)) {
                return false;
        }
        PropertyType that = (PropertyType) obj;
        if (that.getPropertyTypeId() != this.getPropertyTypeId()) {
                return false;
        }
    return true;
    }

}
