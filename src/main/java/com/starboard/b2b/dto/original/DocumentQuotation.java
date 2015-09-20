
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class DocumentQuotation implements Serializable {
    
    /** Creates a new instance of DocumentQuotation */
    public DocumentQuotation() {
    }
    public DocumentQuotation(
            long documentId	
            , String documentName	
            , String documentPath	
            , long brandGroupId	
            , String brandGroupName	
            , String productPriceGroupName	
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
        this.productPriceGroupName = productPriceGroupName;	
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
    private String productPriceGroupName;	
    private String userCreate;	
    private String userUpdate;	
    private java.sql.Timestamp timeCreate;	
    private java.sql.Timestamp timeUpdate;	



    public String getProductPriceGroupName() {
		return productPriceGroupName;
	}
	public void setProductPriceGroupName(String productPriceGroupName) {
		this.productPriceGroupName = productPriceGroupName;
	}
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



    @Override
	public String toString() {
		return "DocumentQuotation [documentId=" + documentId
				+ ", documentName=" + documentName + ", documentPath="
				+ documentPath + ", brandGroupId=" + brandGroupId
				+ ", brandGroupName=" + brandGroupName
				+ ", productPriceGroupName=" + productPriceGroupName
				+ ", userCreate=" + userCreate + ", userUpdate=" + userUpdate
				+ ", timeCreate=" + timeCreate + ", timeUpdate=" + timeUpdate
				+ "]";
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (brandGroupId ^ (brandGroupId >>> 32));
		result = prime * result
				+ ((brandGroupName == null) ? 0 : brandGroupName.hashCode());
		result = prime * result + (int) (documentId ^ (documentId >>> 32));
		result = prime * result
				+ ((documentName == null) ? 0 : documentName.hashCode());
		result = prime * result
				+ ((documentPath == null) ? 0 : documentPath.hashCode());
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
		DocumentQuotation other = (DocumentQuotation) obj;
		if (brandGroupId != other.brandGroupId)
			return false;
		if (brandGroupName == null) {
			if (other.brandGroupName != null)
				return false;
		} else if (!brandGroupName.equals(other.brandGroupName))
			return false;
		if (documentId != other.documentId)
			return false;
		if (documentName == null) {
			if (other.documentName != null)
				return false;
		} else if (!documentName.equals(other.documentName))
			return false;
		if (documentPath == null) {
			if (other.documentPath != null)
				return false;
		} else if (!documentPath.equals(other.documentPath))
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
