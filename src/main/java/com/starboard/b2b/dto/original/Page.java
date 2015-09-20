
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Page implements Serializable {
    
    /** Creates a new instance of Page */
    public Page() {
    }
    public Page(
            long pageId	
            , String pageName	
            , String pageNameTh	
            , String pageHead	
            , String pageBody	
            , String pagePicture	
            , String pageThumbnail	
            , java.sql.Timestamp pageDateStart	
            , double pagePriority	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.pageId = pageId;	
        this.pageName = pageName;	
        this.pageNameTh = pageNameTh;	
        this.pageHead = pageHead;	
        this.pageBody = pageBody;	
        this.pagePicture = pagePicture;	
        this.pageThumbnail = pageThumbnail;	
        this.pageDateStart = pageDateStart;	
        this.pagePriority = pagePriority;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long pageId;	
    private String pageName;	
    private String pageNameTh;	
    private String pageHead;	
    private String pageBody;	
    private String pagePicture;	
    private String pageThumbnail;	
    private java.sql.Timestamp pageDateStart;	
    private double pagePriority;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getPageId() {
        return this.pageId;
    }		
    public void setPageId(long pageId) {
        this.pageId = pageId;
    }
    public String getPageName() {
        return this.pageName;
    }		
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    public String getPageNameTh() {
        return this.pageNameTh;
    }		
    public void setPageNameTh(String pageNameTh) {
        this.pageNameTh = pageNameTh;
    }
    public String getPageHead() {
        return this.pageHead;
    }		
    public void setPageHead(String pageHead) {
        this.pageHead = pageHead;
    }
    public String getPageBody() {
        return this.pageBody;
    }		
    public void setPageBody(String pageBody) {
        this.pageBody = pageBody;
    }
    public String getPagePicture() {
        return this.pagePicture;
    }		
    public void setPagePicture(String pagePicture) {
        this.pagePicture = pagePicture;
    }
    public String getPageThumbnail() {
        return this.pageThumbnail;
    }		
    public void setPageThumbnail(String pageThumbnail) {
        this.pageThumbnail = pageThumbnail;
    }
    public java.sql.Timestamp getPageDateStart() {
        return this.pageDateStart;
    }		
    public void setPageDateStart(java.sql.Timestamp pageDateStart) {
        this.pageDateStart = pageDateStart;
    }
    public double getPagePriority() {
        return this.pagePriority;
    }		
    public void setPagePriority(double pagePriority) {
        this.pagePriority = pagePriority;
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
        return super.toString() + "pageId=[" + pageId + "]\n" + "pageName=[" + pageName + "]\n" + "pageNameTh=[" + pageNameTh + "]\n" + "pageHead=[" + pageHead + "]\n" + "pageBody=[" + pageBody + "]\n" + "pagePicture=[" + pagePicture + "]\n" + "pageThumbnail=[" + pageThumbnail + "]\n" + "pageDateStart=[" + pageDateStart + "]\n" + "pagePriority=[" + pagePriority + "]\n" + "userCreate=[" + userCreate + "]\n" + "userUpdate=[" + userUpdate + "]\n" + "timeCreate=[" + timeCreate + "]\n" + "timeUpdate=[" + timeUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Page)) {
                return false;
        }
        Page that = (Page) obj;
        if (that.getPageId() != this.getPageId()) {
                return false;
        }
        if (!(that.getPageName() == null ? this.getPageName() == null
                        : that.getPageName().equals(this.getPageName()))) {
                return false;
        }
        if (!(that.getPageNameTh() == null ? this.getPageNameTh() == null
                        : that.getPageNameTh().equals(this.getPageNameTh()))) {
                return false;
        }
        if (!(that.getPageHead() == null ? this.getPageHead() == null
                        : that.getPageHead().equals(this.getPageHead()))) {
                return false;
        }
        if (!(that.getPageBody() == null ? this.getPageBody() == null
                        : that.getPageBody().equals(this.getPageBody()))) {
                return false;
        }
        if (!(that.getPagePicture() == null ? this.getPagePicture() == null
                        : that.getPagePicture().equals(this.getPagePicture()))) {
                return false;
        }
        if (!(that.getPageThumbnail() == null ? this.getPageThumbnail() == null
                        : that.getPageThumbnail().equals(this.getPageThumbnail()))) {
                return false;
        }
        if (!(that.getPageDateStart() == null ? this.getPageDateStart() == null
                        : that.getPageDateStart().equals(this.getPageDateStart()))) {
                return false;
        }
        if (that.getPagePriority() != this.getPagePriority()) {
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
