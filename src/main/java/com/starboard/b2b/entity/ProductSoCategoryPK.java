
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductSoCategoryPK  implements Serializable {
    
    /** Creates a new instance of ProductSoCategory */
    public ProductSoCategoryPK(
            String soCategory	
        ) {
        this.soCategory = soCategory;	
    }
    private String soCategory;	

    public String getSoCategory() {
        return this.soCategory;
    }		
    public void setSoCategory(String soCategory) {
        this.soCategory = soCategory;
    }

    public String toString() {
        return super.toString() + " " + soCategory;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductSoCategory)) {
                return false;
        }
        ProductSoCategory that = (ProductSoCategory) obj;
        if (!(that.getSoCategory() == null ? this.getSoCategory() == null
                        : that.getSoCategory().equals(this.getSoCategory()))) {
                return false;
        }
    return true;
    }

}
