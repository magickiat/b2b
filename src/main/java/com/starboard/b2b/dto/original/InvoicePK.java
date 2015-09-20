
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class InvoicePK  implements Serializable {
    
    /** Creates a new instance of Invoice */
    public InvoicePK(
            long invoiceId	
        ) {
        this.invoiceId = invoiceId;	
    }
    private long invoiceId;	

    public long getInvoiceId() {
        return this.invoiceId;
    }		
    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String toString() {
        return super.toString() + " " + invoiceId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Invoice)) {
                return false;
        }
        Invoice that = (Invoice) obj;
        if (that.getInvoiceId() != this.getInvoiceId()) {
                return false;
        }
    return true;
    }

}
