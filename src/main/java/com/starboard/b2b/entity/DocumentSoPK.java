
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DocumentSoPK  implements Serializable {
    
    /** Creates a new instance of DocumentSo */
    public DocumentSoPK(
            long documentId	
            , long soId	
        ) {
        this.documentId = documentId;	
        this.soId = soId;	
    }
    private long documentId;	
    private long soId;	

    public long getDocumentId() {
        return this.documentId;
    }		
    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }
    public long getSoId() {
        return this.soId;
    }		
    public void setSoId(long soId) {
        this.soId = soId;
    }

    public String toString() {
        return super.toString() + " " + documentId + " " + soId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DocumentSo)) {
                return false;
        }
        DocumentSo that = (DocumentSo) obj;
        if (that.getDocumentId() != this.getDocumentId()) {
                return false;
        }
        if (that.getSoId() != this.getSoId()) {
                return false;
        }
    return true;
    }

}
