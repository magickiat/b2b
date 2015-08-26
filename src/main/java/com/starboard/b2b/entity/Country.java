
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Country implements Serializable {
    
    /** Creates a new instance of Country */
    public Country() {
    }
    public Country(
            String countryCode	
            , String countryName	
        ) {
        this.countryCode = countryCode;	
        this.countryName = countryName;	
    }
    private String countryCode;	
    private String countryName;	



    public String getCountryCode() {
        return this.countryCode;
    }		
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCountryName() {
        return this.countryName;
    }		
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }



    public String toString() {
        return super.toString() + "countryCode=[" + countryCode + "]\n" + "countryName=[" + countryName + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Country)) {
                return false;
        }
        Country that = (Country) obj;
        if (!(that.getCountryCode() == null ? this.getCountryCode() == null
                        : that.getCountryCode().equals(this.getCountryCode()))) {
                return false;
        }
        if (!(that.getCountryName() == null ? this.getCountryName() == null
                        : that.getCountryName().equals(this.getCountryName()))) {
                return false;
        }
    return true;
    }

}
