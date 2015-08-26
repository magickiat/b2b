
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DownloadImages implements Serializable {
    
    /** Creates a new instance of DownloadImages */
    public DownloadImages() {
    }
    public DownloadImages(
            long downloadImagesId	
            , String downloadImagesName	
            , String productPriceGroupName	
            , String downloadImagesUrl
            , String downloadImagesPath	
            , String downloadImagesFilename	
            , String userCreate	
            , String userUpdate	
            , java.sql.Timestamp timeCreate	
            , java.sql.Timestamp timeUpdate	
        ) {
        this.downloadImagesId = downloadImagesId;	
        this.downloadImagesName = downloadImagesName;	
        this.productPriceGroupName	 = productPriceGroupName;
        this.downloadImagesUrl	 = downloadImagesUrl;
        this.downloadImagesPath = downloadImagesPath;	
        this.downloadImagesFilename = downloadImagesFilename;	
        this.userCreate = userCreate;	
        this.userUpdate = userUpdate;	
        this.timeCreate = timeCreate;	
        this.timeUpdate = timeUpdate;	
    }
    private long downloadImagesId;	
    private String downloadImagesName;	
    private String productPriceGroupName;
    private String downloadImagesUrl;
    private String downloadImagesPath;	
    private String downloadImagesFilename;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public long getDownloadImagesId() {
        return this.downloadImagesId;
    }		
    public void setDownloadImagesId(long downloadImagesId) {
        this.downloadImagesId = downloadImagesId;
    }
    public String getDownloadImagesName() {
        return this.downloadImagesName;
    }		
    public void setDownloadImagesName(String downloadImagesName) {
        this.downloadImagesName = downloadImagesName;
    }
    
    public String getProductPriceGroupName() {
		return productPriceGroupName;
	}
	public void setProductPriceGroupName(String productPriceGroupName) {
		this.productPriceGroupName = productPriceGroupName;
	}
	
	public String getDownloadImagesUrl() {
		return downloadImagesUrl;
	}
	public void setDownloadImagesUrl(String downloadImagesUrl) {
		this.downloadImagesUrl = downloadImagesUrl;
	}
	public String getDownloadImagesPath() {
        return this.downloadImagesPath;
    }		
    public void setDownloadImagesPath(String downloadImagesPath) {
        this.downloadImagesPath = downloadImagesPath;
    }
    public String getDownloadImagesFilename() {
        return this.downloadImagesFilename;
    }		
    public void setDownloadImagesFilename(String downloadImagesFilename) {
        this.downloadImagesFilename = downloadImagesFilename;
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



    @Override
	public String toString() {
		return "DownloadImages [downloadImagesId=" + downloadImagesId
				+ ", downloadImagesName=" + downloadImagesName
				+ ", productPriceGroupName=" + productPriceGroupName
				+ ", downloadImagesUrl=" + downloadImagesUrl
				+ ", downloadImagesPath=" + downloadImagesPath
				+ ", downloadImagesFilename=" + downloadImagesFilename
				+ ", userCreate=" + userCreate + ", userUpdate=" + userUpdate
				+ ", timeCreate=" + timeCreate + ", timeUpdate=" + timeUpdate
				+ "]";
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((downloadImagesFilename == null) ? 0
						: downloadImagesFilename.hashCode());
		result = prime * result
				+ (int) (downloadImagesId ^ (downloadImagesId >>> 32));
		result = prime
				* result
				+ ((downloadImagesName == null) ? 0 : downloadImagesName
						.hashCode());
		result = prime
				* result
				+ ((downloadImagesPath == null) ? 0 : downloadImagesPath
						.hashCode());
		result = prime
				* result
				+ ((downloadImagesUrl == null) ? 0 : downloadImagesUrl
						.hashCode());
		result = prime
				* result
				+ ((productPriceGroupName == null) ? 0 : productPriceGroupName
						.hashCode());
		result = prime * result
				+ ((timeCreate == null) ? 0 : timeCreate.hashCode());
		result = prime * result
				+ ((timeUpdate == null) ? 0 : timeUpdate.hashCode());
		result = prime * result
				+ ((userCreate == null) ? 0 : userCreate.hashCode());
		result = prime * result
				+ ((userUpdate == null) ? 0 : userUpdate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DownloadImages other = (DownloadImages) obj;
		if (downloadImagesFilename == null) {
			if (other.downloadImagesFilename != null)
				return false;
		} else if (!downloadImagesFilename.equals(other.downloadImagesFilename))
			return false;
		if (downloadImagesId != other.downloadImagesId)
			return false;
		if (downloadImagesName == null) {
			if (other.downloadImagesName != null)
				return false;
		} else if (!downloadImagesName.equals(other.downloadImagesName))
			return false;
		if (downloadImagesPath == null) {
			if (other.downloadImagesPath != null)
				return false;
		} else if (!downloadImagesPath.equals(other.downloadImagesPath))
			return false;
		if (downloadImagesUrl == null) {
			if (other.downloadImagesUrl != null)
				return false;
		} else if (!downloadImagesUrl.equals(other.downloadImagesUrl))
			return false;
		if (productPriceGroupName == null) {
			if (other.productPriceGroupName != null)
				return false;
		} else if (!productPriceGroupName.equals(other.productPriceGroupName))
			return false;
		if (timeCreate == null) {
			if (other.timeCreate != null)
				return false;
		} else if (!timeCreate.equals(other.timeCreate))
			return false;
		if (timeUpdate == null) {
			if (other.timeUpdate != null)
				return false;
		} else if (!timeUpdate.equals(other.timeUpdate))
			return false;
		if (userCreate == null) {
			if (other.userCreate != null)
				return false;
		} else if (!userCreate.equals(other.userCreate))
			return false;
		if (userUpdate == null) {
			if (other.userUpdate != null)
				return false;
		} else if (!userUpdate.equals(other.userUpdate))
			return false;
		return true;
	}

}
