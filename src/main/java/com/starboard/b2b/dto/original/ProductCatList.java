
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductCatList implements Serializable {
    
    /** Creates a new instance of ProductCatList */
    public ProductCatList() {
    }
    public ProductCatList(
            long productId	
            , long productCatId	
        ) {
        this.productId = productId;	
        this.productCatId = productCatId;	
    }
    private long productId;	
    private long productCatId;	



    public long getProductId() {
        return this.productId;
    }		
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public long getProductCatId() {
        return this.productCatId;
    }		
    public void setProductCatId(long productCatId) {
        this.productCatId = productCatId;
    }



    public String toString() {
        return super.toString() + "productId=[" + productId + "]\n" + "productCatId=[" + productCatId + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductCatList)) {
                return false;
        }
        ProductCatList that = (ProductCatList) obj;
        if (that.getProductId() != this.getProductId()) {
                return false;
        }
        if (that.getProductCatId() != this.getProductCatId()) {
                return false;
        }
    return true;
    }

}
