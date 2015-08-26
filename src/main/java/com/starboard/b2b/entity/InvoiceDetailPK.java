
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class InvoiceDetailPK  implements Serializable {
    
    /** Creates a new instance of InvoiceDetail */
    public InvoiceDetailPK(
            long invoiceProductId	
        ) {
        this.invoiceProductId = invoiceProductId;	
    }
    private long invoiceProductId;	

    public long getInvoiceProductId() {
        return this.invoiceProductId;
    }		
    public void setInvoiceProductId(long invoiceProductId) {
        this.invoiceProductId = invoiceProductId;
    }

    public String toString() {
        return super.toString() + " " + invoiceProductId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof InvoiceDetail)) {
                return false;
        }
        InvoiceDetail that = (InvoiceDetail) obj;
        if (that.getInvoiceProductId() != this.getInvoiceProductId()) {
                return false;
        }
    return true;
    }

}
