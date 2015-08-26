
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DocumentProductGuidePK  implements Serializable {
    
    /** Creates a new instance of DocumentProductGuide */
    public DocumentProductGuidePK(
            long documentId	
        ) {
        this.documentId = documentId;	
    }
    private long documentId;	

    public long getDocumentId() {
        return this.documentId;
    }		
    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public String toString() {
        return super.toString() + " " + documentId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DocumentProductGuide)) {
                return false;
        }
        DocumentProductGuide that = (DocumentProductGuide) obj;
        if (that.getDocumentId() != this.getDocumentId()) {
                return false;
        }
    return true;
    }

}
