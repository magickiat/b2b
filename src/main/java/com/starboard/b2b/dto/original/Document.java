
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Document implements Serializable {
    
    /** Creates a new instance of Document */
    public Document() {
    }
    public Document(
            long documentId	
            , String documentFilenameOriginal	
            , String documentFilenameRuning	
            , String documentPath	
            , String documentContenttype	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.documentId = documentId;	
        this.documentFilenameOriginal = documentFilenameOriginal;	
        this.documentFilenameRuning = documentFilenameRuning;	
        this.documentPath = documentPath;	
        this.documentContenttype = documentContenttype;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long documentId;	
    private String documentFilenameOriginal;	
    private String documentFilenameRuning;	
    private String documentPath;	
    private String documentContenttype;	
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
    public String getDocumentFilenameOriginal() {
        return this.documentFilenameOriginal;
    }		
    public void setDocumentFilenameOriginal(String documentFilenameOriginal) {
        this.documentFilenameOriginal = documentFilenameOriginal;
    }
    public String getDocumentFilenameRuning() {
        return this.documentFilenameRuning;
    }		
    public void setDocumentFilenameRuning(String documentFilenameRuning) {
        this.documentFilenameRuning = documentFilenameRuning;
    }
    public String getDocumentPath() {
        return this.documentPath;
    }		
    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }
    public String getDocumentContenttype() {
        return this.documentContenttype;
    }		
    public void setDocumentContenttype(String documentContenttype) {
        this.documentContenttype = documentContenttype;
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
        return super.toString() + "documentId=[" + documentId + "]\n" + "documentFilenameOriginal=[" + documentFilenameOriginal + "]\n" + "documentFilenameRuning=[" + documentFilenameRuning + "]\n" + "documentPath=[" + documentPath + "]\n" + "documentContenttype=[" + documentContenttype + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Document)) {
                return false;
        }
        Document that = (Document) obj;
        if (that.getDocumentId() != this.getDocumentId()) {
                return false;
        }
        if (!(that.getDocumentFilenameOriginal() == null ? this.getDocumentFilenameOriginal() == null
                        : that.getDocumentFilenameOriginal().equals(this.getDocumentFilenameOriginal()))) {
                return false;
        }
        if (!(that.getDocumentFilenameRuning() == null ? this.getDocumentFilenameRuning() == null
                        : that.getDocumentFilenameRuning().equals(this.getDocumentFilenameRuning()))) {
                return false;
        }
        if (!(that.getDocumentPath() == null ? this.getDocumentPath() == null
                        : that.getDocumentPath().equals(this.getDocumentPath()))) {
                return false;
        }
        if (!(that.getDocumentContenttype() == null ? this.getDocumentContenttype() == null
                        : that.getDocumentContenttype().equals(this.getDocumentContenttype()))) {
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
