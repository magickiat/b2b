
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class HomePagePK  implements Serializable {
    
    /** Creates a new instance of HomePage */
    public HomePagePK(
            long homePageId	
        ) {
        this.homePageId = homePageId;	
    }
    private long homePageId;	

    public long getHomePageId() {
        return this.homePageId;
    }		
    public void setHomePageId(long homePageId) {
        this.homePageId = homePageId;
    }

    public String toString() {
        return super.toString() + " " + homePageId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof HomePage)) {
                return false;
        }
        HomePage that = (HomePage) obj;
        if (that.getHomePageId() != this.getHomePageId()) {
                return false;
        }
    return true;
    }

}
