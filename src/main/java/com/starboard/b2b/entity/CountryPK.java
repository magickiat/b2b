
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class CountryPK  implements Serializable {
    
    /** Creates a new instance of Country */
    public CountryPK(
            String countryCode	
        ) {
        this.countryCode = countryCode;	
    }
    private String countryCode;	

    public String getCountryCode() {
        return this.countryCode;
    }		
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String toString() {
        return super.toString() + " " + countryCode;
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
    return true;
    }

}
