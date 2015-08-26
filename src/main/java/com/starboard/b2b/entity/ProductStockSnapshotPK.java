
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class ProductStockSnapshotPK  implements Serializable {
    
    /** Creates a new instance of ProductStockSnapshot */
    public ProductStockSnapshotPK(
            long productStockSnapshotId	
        ) {
        this.productStockSnapshotId = productStockSnapshotId;	
    }
    private long productStockSnapshotId;	

    public long getProductStockSnapshotId() {
        return this.productStockSnapshotId;
    }		
    public void setProductStockSnapshotId(long productStockSnapshotId) {
        this.productStockSnapshotId = productStockSnapshotId;
    }

    public String toString() {
        return super.toString() + " " + productStockSnapshotId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof ProductStockSnapshot)) {
                return false;
        }
        ProductStockSnapshot that = (ProductStockSnapshot) obj;
        if (that.getProductStockSnapshotId() != this.getProductStockSnapshotId()) {
                return false;
        }
    return true;
    }

}
