
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DocumentInvoicePK  implements Serializable {
    
    /** Creates a new instance of DocumentInvoice */
    public DocumentInvoicePK(
            long documentId	
            , long invoiceId	
        ) {
        this.documentId = documentId;	
        this.invoiceId = invoiceId;	
    }
    private long documentId;	
    private long invoiceId;	

    public long getDocumentId() {
        return this.documentId;
    }		
    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }
    public long getInvoiceId() {
        return this.invoiceId;
    }		
    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String toString() {
        return super.toString() + " " + documentId + " " + invoiceId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DocumentInvoice)) {
                return false;
        }
        DocumentInvoice that = (DocumentInvoice) obj;
        if (that.getDocumentId() != this.getDocumentId()) {
                return false;
        }
        if (that.getInvoiceId() != this.getInvoiceId()) {
                return false;
        }
    return true;
    }

}
