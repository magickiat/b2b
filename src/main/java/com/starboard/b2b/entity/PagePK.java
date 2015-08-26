
package com.starboard.b2b.entity;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class PagePK  implements Serializable {
    
    /** Creates a new instance of Page */
    public PagePK(
            long pageId	
        ) {
        this.pageId = pageId;	
    }
    private long pageId;	

    public long getPageId() {
        return this.pageId;
    }		
    public void setPageId(long pageId) {
        this.pageId = pageId;
    }

    public String toString() {
        return super.toString() + " " + pageId;
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
    return true;
    }

}
