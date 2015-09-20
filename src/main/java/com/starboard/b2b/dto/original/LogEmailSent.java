
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class LogEmailSent implements Serializable {
    
    /** Creates a new instance of LogEmailSent */
    public LogEmailSent() {
    }
    public LogEmailSent(
            long logEmailSentId	
            , String emailFrom	
            , String emailTo	
            , String emailCc	
            , String emailBcc	
            , String emailSubject	
            , String emailContent	
            , String attachment	
            , String sentStatus	
            , String sentDesc	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.logEmailSentId = logEmailSentId;	
        this.emailFrom = emailFrom;	
        this.emailTo = emailTo;	
        this.emailCc = emailCc;	
        this.emailBcc = emailBcc;	
        this.emailSubject = emailSubject;	
        this.emailContent = emailContent;	
        this.attachment = attachment;	
        this.sentStatus = sentStatus;	
        this.sentDesc = sentDesc;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long logEmailSentId;	
    private String emailFrom;	
    private String emailTo;	
    private String emailCc;	
    private String emailBcc;	
    private String emailSubject;	
    private String emailContent;	
    private String attachment;	
    private String sentStatus;	
    private String sentDesc;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getLogEmailSentId() {
        return this.logEmailSentId;
    }		
    public void setLogEmailSentId(long logEmailSentId) {
        this.logEmailSentId = logEmailSentId;
    }
    public String getEmailFrom() {
        return this.emailFrom;
    }		
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
    public String getEmailTo() {
        return this.emailTo;
    }		
    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }
    public String getEmailCc() {
        return this.emailCc;
    }		
    public void setEmailCc(String emailCc) {
        this.emailCc = emailCc;
    }
    public String getEmailBcc() {
        return this.emailBcc;
    }		
    public void setEmailBcc(String emailBcc) {
        this.emailBcc = emailBcc;
    }
    public String getEmailSubject() {
        return this.emailSubject;
    }		
    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }
    public String getEmailContent() {
        return this.emailContent;
    }		
    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }
    public String getAttachment() {
        return this.attachment;
    }		
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    public String getSentStatus() {
        return this.sentStatus;
    }		
    public void setSentStatus(String sentStatus) {
        this.sentStatus = sentStatus;
    }
    public String getSentDesc() {
        return this.sentDesc;
    }		
    public void setSentDesc(String sentDesc) {
        this.sentDesc = sentDesc;
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
        return super.toString() + "logEmailSentId=[" + logEmailSentId + "]\n" + "emailFrom=[" + emailFrom + "]\n" + "emailTo=[" + emailTo + "]\n" + "emailCc=[" + emailCc + "]\n" + "emailBcc=[" + emailBcc + "]\n" + "emailSubject=[" + emailSubject + "]\n" + "emailContent=[" + emailContent + "]\n" + "attachment=[" + attachment + "]\n" + "sentStatus=[" + sentStatus + "]\n" + "sentDesc=[" + sentDesc + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof LogEmailSent)) {
                return false;
        }
        LogEmailSent that = (LogEmailSent) obj;
        if (that.getLogEmailSentId() != this.getLogEmailSentId()) {
                return false;
        }
        if (!(that.getEmailFrom() == null ? this.getEmailFrom() == null
                        : that.getEmailFrom().equals(this.getEmailFrom()))) {
                return false;
        }
        if (!(that.getEmailTo() == null ? this.getEmailTo() == null
                        : that.getEmailTo().equals(this.getEmailTo()))) {
                return false;
        }
        if (!(that.getEmailCc() == null ? this.getEmailCc() == null
                        : that.getEmailCc().equals(this.getEmailCc()))) {
                return false;
        }
        if (!(that.getEmailBcc() == null ? this.getEmailBcc() == null
                        : that.getEmailBcc().equals(this.getEmailBcc()))) {
                return false;
        }
        if (!(that.getEmailSubject() == null ? this.getEmailSubject() == null
                        : that.getEmailSubject().equals(this.getEmailSubject()))) {
                return false;
        }
        if (!(that.getEmailContent() == null ? this.getEmailContent() == null
                        : that.getEmailContent().equals(this.getEmailContent()))) {
                return false;
        }
        if (!(that.getAttachment() == null ? this.getAttachment() == null
                        : that.getAttachment().equals(this.getAttachment()))) {
                return false;
        }
        if (!(that.getSentStatus() == null ? this.getSentStatus() == null
                        : that.getSentStatus().equals(this.getSentStatus()))) {
                return false;
        }
        if (!(that.getSentDesc() == null ? this.getSentDesc() == null
                        : that.getSentDesc().equals(this.getSentDesc()))) {
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
