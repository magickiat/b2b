
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DocumentType implements Serializable {
    
    /** Creates a new instance of DocumentType */
    public DocumentType() {
    }
    public DocumentType(
            String documentTypeId	
            , String documentTypeName	
            , String documentTypeDescription	
            , long documentTypeFlag	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.documentTypeId = documentTypeId;	
        this.documentTypeName = documentTypeName;	
        this.documentTypeDescription = documentTypeDescription;	
        this.documentTypeFlag = documentTypeFlag;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private String documentTypeId;	
    private String documentTypeName;	
    private String documentTypeDescription;	
    private long documentTypeFlag;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getDocumentTypeId() {
        return this.documentTypeId;
    }		
    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }
    public String getDocumentTypeName() {
        return this.documentTypeName;
    }		
    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }
    public String getDocumentTypeDescription() {
        return this.documentTypeDescription;
    }		
    public void setDocumentTypeDescription(String documentTypeDescription) {
        this.documentTypeDescription = documentTypeDescription;
    }
    public long getDocumentTypeFlag() {
        return this.documentTypeFlag;
    }		
    public void setDocumentTypeFlag(long documentTypeFlag) {
        this.documentTypeFlag = documentTypeFlag;
    }
    public String getUserCreate() {
        return this.userCreate;
    }		
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }
    public String getUserUpdate() {
        return this.userUpdate;
    }		
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
    public java.sql.Timestamp getTimeCreate() {
        return this.timeCreate;
    }		
    public void setTimeCreate(java.sql.Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }
    public java.sql.Timestamp getTimeUpdate() {
        return this.timeUpdate;
    }		
    public void setTimeUpdate(java.sql.Timestamp timeUpdate) {
        this.timeUpdate = timeUpdate;
    }



    public String toString() {
        return super.toString() + "documentTypeId=[" + documentTypeId + "]\n" + "documentTypeName=[" + documentTypeName + "]\n" + "documentTypeDescription=[" + documentTypeDescription + "]\n" + "documentTypeFlag=[" + documentTypeFlag + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
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
        if (!(that.getDocumentTypeName() == null ? this.getDocumentTypeName() == null
                        : that.getDocumentTypeName().equals(this.getDocumentTypeName()))) {
                return false;
        }
        if (!(that.getDocumentTypeDescription() == null ? this.getDocumentTypeDescription() == null
                        : that.getDocumentTypeDescription().equals(this.getDocumentTypeDescription()))) {
                return false;
        }
        if (that.getDocumentTypeFlag() != this.getDocumentTypeFlag()) {
                return false;
        }
        if (!(that.getUserCreate() == null ? this.getUserCreate() == null
                        : that.getUserCreate().equals(this.getUserCreate()))) {
                return false;
        }
        if (!(that.getUserUpdate() == null ? this.getUserUpdate() == null
                        : that.getUserUpdate().equals(this.getUserUpdate()))) {
                return false;
        }
        if (!(that.getTimeCreate() == null ? this.getTimeCreate() == null
                        : that.getTimeCreate().equals(this.getTimeCreate()))) {
                return false;
        }
        if (!(that.getTimeUpdate() == null ? this.getTimeUpdate() == null
                        : that.getTimeUpdate().equals(this.getTimeUpdate()))) {
                return false;
        }
    return true;
    }

}
