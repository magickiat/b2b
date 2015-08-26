
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DocumentReport implements Serializable {
    
    /** Creates a new instance of DocumentReport */
    public DocumentReport() {
    }
    public DocumentReport(
            long documentId	
            , String documentName	
            , String documentPath	
            , long brandGroupId	
            , String brandGroupName	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.documentId = documentId;	
        this.documentName = documentName;	
        this.documentPath = documentPath;	
        this.brandGroupId = brandGroupId;	
        this.brandGroupName = brandGroupName;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long documentId;	
    private String documentName;	
    private String documentPath;	
    private long brandGroupId;	
    private String brandGroupName;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getDocumentId() {
        return this.documentId;
    }		
    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }
    public String getDocumentName() {
        return this.documentName;
    }		
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
    public String getDocumentPath() {
        return this.documentPath;
    }		
    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }
    public long getBrandGroupId() {
        return this.brandGroupId;
    }		
    public void setBrandGroupId(long brandGroupId) {
        this.brandGroupId = brandGroupId;
    }
    public String getBrandGroupName() {
    	return this.brandGroupName;
    }		
    public void setBrandGroupName(String brandGroupName) {
    	this.brandGroupName = brandGroupName;
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
        return super.toString() + "documentId=[" + documentId + "]\n" + "documentName=[" + documentName + "]\n" + "documentPath=[" + documentPath + "]\n" + "brandGroupId=[" + brandGroupId + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof DocumentReport)) {
                return false;
        }
        DocumentReport that = (DocumentReport) obj;
        if (that.getDocumentId() != this.getDocumentId()) {
                return false;
        }
        if (!(that.getDocumentName() == null ? this.getDocumentName() == null
                        : that.getDocumentName().equals(this.getDocumentName()))) {
                return false;
        }
        if (!(that.getDocumentPath() == null ? this.getDocumentPath() == null
                        : that.getDocumentPath().equals(this.getDocumentPath()))) {
                return false;
        }
        if (that.getBrandGroupId() != this.getBrandGroupId()) {
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
