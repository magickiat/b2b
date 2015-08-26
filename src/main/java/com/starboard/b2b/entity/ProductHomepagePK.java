
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductHomepagePK  implements Serializable {
    
    /** Creates a new instance of ProductHomepage */
    public ProductHomepagePK(
            long productHomepageId	
        ) {
        this.productHomepageId = productHomepageId;	
    }
    private long productHomepageId;	

    public long getProductHomepageId() {
        return this.productHomepageId;
    }		
    public void setProductHomepageId(long productHomepageId) {
        this.productHomepageId = productHomepageId;
    }

    public String toString() {
        return super.toString() + " " + productHomepageId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductHomepage)) {
                return false;
        }
        ProductHomepage that = (ProductHomepage) obj;
        if (that.getProductHomepageId() != this.getProductHomepageId()) {
                return false;
        }
    return true;
    }

}
