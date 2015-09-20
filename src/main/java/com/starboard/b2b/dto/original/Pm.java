
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Pm implements Serializable {
    
    /** Creates a new instance of Pm */
    public Pm() {
    }
    public Pm(
            long pmId	
            , long replyPmId	
            , long contactId	
            , long resumeId	
            , String jobId	
            , String qtId	
            , String content	
            , String detail	
            , String pmStatus	
            , String pmType	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timePm	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.pmId = pmId;	
        this.replyPmId = replyPmId;	
        this.contactId = contactId;	
        this.resumeId = resumeId;	
        this.jobId = jobId;	
        this.qtId = qtId;	
        this.content = content;	
        this.detail = detail;	
        this.pmStatus = pmStatus;	
        this.pmType = pmType;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timePm = timePm;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long pmId;	
    private long replyPmId;	
    private long contactId;	
    private long resumeId;	
    private String jobId;	
    private String qtId;	
    private String content;	
    private String detail;	
    private String pmStatus;	
    private String pmType;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timePm;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getPmId() {
        return this.pmId;
    }		
    public void setPmId(long pmId) {
        this.pmId = pmId;
    }
    public long getReplyPmId() {
        return this.replyPmId;
    }		
    public void setReplyPmId(long replyPmId) {
        this.replyPmId = replyPmId;
    }
    public long getContactId() {
        return this.contactId;
    }		
    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
    public long getResumeId() {
        return this.resumeId;
    }		
    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }
    public String getJobId() {
        return this.jobId;
    }		
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getQtId() {
        return this.qtId;
    }		
    public void setQtId(String qtId) {
        this.qtId = qtId;
    }
    public String getContent() {
        return this.content;
    }		
    public void setContent(String content) {
        this.content = content;
    }
    public String getDetail() {
        return this.detail;
    }		
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getPmStatus() {
        return this.pmStatus;
    }		
    public void setPmStatus(String pmStatus) {
        this.pmStatus = pmStatus;
    }
    public String getPmType() {
        return this.pmType;
    }		
    public void setPmType(String pmType) {
        this.pmType = pmType;
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
    public java.sql.Timestamp getTimePm() {
        return this.timePm;
    }		
    public void setTimePm(java.sql.Timestamp timePm) {
        this.timePm = timePm;
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
        return super.toString() + "pmId=[" + pmId + "]\n" + "replyPmId=[" + replyPmId + "]\n" + "contactId=[" + contactId + "]\n" + "resumeId=[" + resumeId + "]\n" + "jobId=[" + jobId + "]\n" + "qtId=[" + qtId + "]\n" + "content=[" + content + "]\n" + "detail=[" + detail + "]\n" + "pmStatus=[" + pmStatus + "]\n" + "pmType=[" + pmType + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timePm=[" + timePm + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Pm)) {
                return false;
        }
        Pm that = (Pm) obj;
        if (that.getPmId() != this.getPmId()) {
                return false;
        }
        if (that.getReplyPmId() != this.getReplyPmId()) {
                return false;
        }
        if (that.getContactId() != this.getContactId()) {
                return false;
        }
        if (that.getResumeId() != this.getResumeId()) {
                return false;
        }
        if (!(that.getJobId() == null ? this.getJobId() == null
                        : that.getJobId().equals(this.getJobId()))) {
                return false;
        }
        if (!(that.getQtId() == null ? this.getQtId() == null
                        : that.getQtId().equals(this.getQtId()))) {
                return false;
        }
        if (!(that.getContent() == null ? this.getContent() == null
                        : that.getContent().equals(this.getContent()))) {
                return false;
        }
        if (!(that.getDetail() == null ? this.getDetail() == null
                        : that.getDetail().equals(this.getDetail()))) {
                return false;
        }
        if (!(that.getPmStatus() == null ? this.getPmStatus() == null
                        : that.getPmStatus().equals(this.getPmStatus()))) {
                return false;
        }
        if (!(that.getPmType() == null ? this.getPmType() == null
                        : that.getPmType().equals(this.getPmType()))) {
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
        if (!(that.getTimePm() == null ? this.getTimePm() == null
                        : that.getTimePm().equals(this.getTimePm()))) {
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
