
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class TmpOrdAddress implements Serializable {
    
    /** Creates a new instance of TmpOrdAddress */
    public TmpOrdAddress() {
    }
    public TmpOrdAddress(
            long orderAddressId	
            , long orderId	
            , String orderFname	
            , String orderLname	
            , String orderAddr	
            , String subdistrict	
            , String district	
            , String orderCountryId	
            , String orderProvince	
            , String orderZipcode	
            , String orderTel	
            , String orderMobile	
            , String fax	
            , String email	
            , String description	
            , long type	
            , long importStatus	
            , String dtsSystem	
            , java.sql.Timestamp dtsUpdate	
        ) {
        this.orderAddressId = orderAddressId;	
        this.orderId = orderId;	
        this.orderFname = orderFname;	
        this.orderLname = orderLname;	
        this.orderAddr = orderAddr;	
        this.subdistrict = subdistrict;	
        this.district = district;	
        this.orderCountryId = orderCountryId;	
        this.orderProvince = orderProvince;	
        this.orderZipcode = orderZipcode;	
        this.orderTel = orderTel;	
        this.orderMobile = orderMobile;	
        this.fax = fax;	
        this.email = email;	
        this.description = description;	
        this.type = type;	
        this.importStatus = importStatus;	
        this.dtsSystem = dtsSystem;	
        this.dtsUpdate = dtsUpdate;	
    }
    private long orderAddressId;	
    private long orderId;	
    private String orderFname;	
    private String orderLname;	
    private String orderAddr;	
    private String subdistrict;	
    private String district;	
    private String orderCountryId;	
    private String orderProvince;	
    private String orderZipcode;	
    private String orderTel;	
    private String orderMobile;	
    private String fax;	
    private String email;	
    private String description;	
    private long type;	
    private long importStatus;	
    private String dtsSystem;	
    private java.sql.Timestamp dtsUpdate;	



    public long getOrderAddressId() {
        return this.orderAddressId;
    }		
    public void setOrderAddressId(long orderAddressId) {
        this.orderAddressId = orderAddressId;
    }
    public long getOrderId() {
        return this.orderId;
    }		
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public String getOrderFname() {
        return this.orderFname;
    }		
    public void setOrderFname(String orderFname) {
        this.orderFname = orderFname;
    }
    public String getOrderLname() {
        return this.orderLname;
    }		
    public void setOrderLname(String orderLname) {
        this.orderLname = orderLname;
    }
    public String getOrderAddr() {
        return this.orderAddr;
    }		
    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }
    public String getSubdistrict() {
        return this.subdistrict;
    }		
    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }
    public String getDistrict() {
        return this.district;
    }		
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getOrderCountryId() {
        return this.orderCountryId;
    }		
    public void setOrderCountryId(String orderCountryId) {
        this.orderCountryId = orderCountryId;
    }
    public String getOrderProvince() {
        return this.orderProvince;
    }		
    public void setOrderProvince(String orderProvince) {
        this.orderProvince = orderProvince;
    }
    public String getOrderZipcode() {
        return this.orderZipcode;
    }		
    public void setOrderZipcode(String orderZipcode) {
        this.orderZipcode = orderZipcode;
    }
    public String getOrderTel() {
        return this.orderTel;
    }		
    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }
    public String getOrderMobile() {
        return this.orderMobile;
    }		
    public void setOrderMobile(String orderMobile) {
        this.orderMobile = orderMobile;
    }
    public String getFax() {
        return this.fax;
    }		
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return this.email;
    }		
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescription() {
        return this.description;
    }		
    public void setDescription(String description) {
        this.description = description;
    }
    public long getType() {
        return this.type;
    }		
    public void setType(long type) {
        this.type = type;
    }
    public long getImportStatus() {
        return this.importStatus;
    }		
    public void setImportStatus(long importStatus) {
        this.importStatus = importStatus;
    }
    public String getDtsSystem() {
        return this.dtsSystem;
    }		
    public void setDtsSystem(String dtsSystem) {
        this.dtsSystem = dtsSystem;
    }
    public java.sql.Timestamp getDtsUpdate() {
        return this.dtsUpdate;
    }		
    public void setDtsUpdate(java.sql.Timestamp dtsUpdate) {
        this.dtsUpdate = dtsUpdate;
    }



    public String toString() {
        return super.toString() + "orderAddressId=[" + orderAddressId + "]\n" + "orderId=[" + orderId + "]\n" + "orderFname=[" + orderFname + "]\n" + "orderLname=[" + orderLname + "]\n" + "orderAddr=[" + orderAddr + "]\n" + "subdistrict=[" + subdistrict + "]\n" + "district=[" + district + "]\n" + "orderCountryId=[" + orderCountryId + "]\n" + "orderProvince=[" + orderProvince + "]\n" + "orderZipcode=[" + orderZipcode + "]\n" + "orderTel=[" + orderTel + "]\n" + "orderMobile=[" + orderMobile + "]\n" + "fax=[" + fax + "]\n" + "email=[" + email + "]\n" + "description=[" + description + "]\n" + "type=[" + type + "]\n" + "importStatus=[" + importStatus + "]\n" + "dtsSystem=[" + dtsSystem + "]\n" + "dtsUpdate=[" + dtsUpdate + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof TmpOrdAddress)) {
                return false;
        }
        TmpOrdAddress that = (TmpOrdAddress) obj;
        if (that.getOrderAddressId() != this.getOrderAddressId()) {
                return false;
        }
        if (that.getOrderId() != this.getOrderId()) {
                return false;
        }
        if (!(that.getOrderFname() == null ? this.getOrderFname() == null
                        : that.getOrderFname().equals(this.getOrderFname()))) {
                return false;
        }
        if (!(that.getOrderLname() == null ? this.getOrderLname() == null
                        : that.getOrderLname().equals(this.getOrderLname()))) {
                return false;
        }
        if (!(that.getOrderAddr() == null ? this.getOrderAddr() == null
                        : that.getOrderAddr().equals(this.getOrderAddr()))) {
                return false;
        }
        if (!(that.getSubdistrict() == null ? this.getSubdistrict() == null
                        : that.getSubdistrict().equals(this.getSubdistrict()))) {
                return false;
        }
        if (!(that.getDistrict() == null ? this.getDistrict() == null
                        : that.getDistrict().equals(this.getDistrict()))) {
                return false;
        }
        if (!(that.getOrderCountryId() == null ? this.getOrderCountryId() == null
                        : that.getOrderCountryId().equals(this.getOrderCountryId()))) {
                return false;
        }
        if (!(that.getOrderProvince() == null ? this.getOrderProvince() == null
                        : that.getOrderProvince().equals(this.getOrderProvince()))) {
                return false;
        }
        if (!(that.getOrderZipcode() == null ? this.getOrderZipcode() == null
                        : that.getOrderZipcode().equals(this.getOrderZipcode()))) {
                return false;
        }
        if (!(that.getOrderTel() == null ? this.getOrderTel() == null
                        : that.getOrderTel().equals(this.getOrderTel()))) {
                return false;
        }
        if (!(that.getOrderMobile() == null ? this.getOrderMobile() == null
                        : that.getOrderMobile().equals(this.getOrderMobile()))) {
                return false;
        }
        if (!(that.getFax() == null ? this.getFax() == null
                        : that.getFax().equals(this.getFax()))) {
                return false;
        }
        if (!(that.getEmail() == null ? this.getEmail() == null
                        : that.getEmail().equals(this.getEmail()))) {
                return false;
        }
        if (!(that.getDescription() == null ? this.getDescription() == null
                        : that.getDescription().equals(this.getDescription()))) {
                return false;
        }
        if (that.getType() != this.getType()) {
                return false;
        }
        if (that.getImportStatus() != this.getImportStatus()) {
                return false;
        }
        if (!(that.getDtsSystem() == null ? this.getDtsSystem() == null
                        : that.getDtsSystem().equals(this.getDtsSystem()))) {
                return false;
        }
        if (!(that.getDtsUpdate() == null ? this.getDtsUpdate() == null
                        : that.getDtsUpdate().equals(this.getDtsUpdate()))) {
                return false;
        }
    return true;
    }

}
