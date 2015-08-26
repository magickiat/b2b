
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DocumentTypePK  implements Serializable {
    
    /** Creates a new instance of DocumentType */
    public DocumentTypePK(
            String documentTypeId	
        ) {
        this.documentTypeId = documentTypeId;	
    }
    private String documentTypeId;	

    public String getDocumentTypeId() {
        return this.documentTypeId;
    }		
    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String toString() {
        return super.toString() + " " + documentTypeId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DocumentType)) {
                return false;
        }
        DocumentType that = (DocumentType) obj;
        if (!(that.getDocumentTypeId() == null ? this.getDocumentTypeId() == null
                        : that.getDocumentTypeId().equals(this.getDocumentTypeId()))) {
                return false;
        }
    return true;
    }

}
