
package com.starboard.b2b.dto.original;

import java.math.*;
import java.sql.*;
import java.net.URL;
import java.io.Serializable;

public class Employee implements Serializable {
    
    /** Creates a new instance of Employee */
    public Employee() {
    }
    public Employee(
            int emid	
            , String emserial	
            , String emupdate	
            , String emname	
            , String emcontact	
            , double emexperience	
            , String emposition	
            , String emskill	
            , String emskilla	
            , String emskillaa	
            , String emdata	
            , String emlatest	
            , String emcommentation	
            , String present	
            , String emdate	
            , String period	
            , String salary	
            , String ememail	
        ) {
        this.emid = emid;	
        this.emserial = emserial;	
        this.emupdate = emupdate;	
        this.emname = emname;	
        this.emcontact = emcontact;	
        this.emexperience = emexperience;	
        this.emposition = emposition;	
        this.emskill = emskill;	
        this.emskilla = emskilla;	
        this.emskillaa = emskillaa;	
        this.emdata = emdata;	
        this.emlatest = emlatest;	
        this.emcommentation = emcommentation;	
        this.present = present;	
        this.emdate = emdate;	
        this.period = period;	
        this.salary = salary;	
        this.ememail = ememail;	
    }
    private int emid;	
    private String emserial;	
    private String emupdate;	
    private String emname;	
    private String emcontact;	
    private double emexperience;	
    private String emposition;	
    private String emskill;	
    private String emskilla;	
    private String emskillaa;	
    private String emdata;	
    private String emlatest;	
    private String emcommentation;	
    private String present;	
    private String emdate;	
    private String period;	
    private String salary;	
    private String ememail;	



    public int getEmid() {
        return this.emid;
    }		
    public void setEmid(int emid) {
        this.emid = emid;
    }
    public String getEmserial() {
        return this.emserial;
    }		
    public void setEmserial(String emserial) {
        this.emserial = emserial;
    }
    public String getEmupdate() {
        return this.emupdate;
    }		
    public void setEmupdate(String emupdate) {
        this.emupdate = emupdate;
    }
    public String getEmname() {
        return this.emname;
    }		
    public void setEmname(String emname) {
        this.emname = emname;
    }
    public String getEmcontact() {
        return this.emcontact;
    }		
    public void setEmcontact(String emcontact) {
        this.emcontact = emcontact;
    }
    public double getEmexperience() {
        return this.emexperience;
    }		
    public void setEmexperience(double emexperience) {
        this.emexperience = emexperience;
    }
    public String getEmposition() {
        return this.emposition;
    }		
    public void setEmposition(String emposition) {
        this.emposition = emposition;
    }
    public String getEmskill() {
        return this.emskill;
    }		
    public void setEmskill(String emskill) {
        this.emskill = emskill;
    }
    public String getEmskilla() {
        return this.emskilla;
    }		
    public void setEmskilla(String emskilla) {
        this.emskilla = emskilla;
    }
    public String getEmskillaa() {
        return this.emskillaa;
    }		
    public void setEmskillaa(String emskillaa) {
        this.emskillaa = emskillaa;
    }
    public String getEmdata() {
        return this.emdata;
    }		
    public void setEmdata(String emdata) {
        this.emdata = emdata;
    }
    public String getEmlatest() {
        return this.emlatest;
    }		
    public void setEmlatest(String emlatest) {
        this.emlatest = emlatest;
    }
    public String getEmcommentation() {
        return this.emcommentation;
    }		
    public void setEmcommentation(String emcommentation) {
        this.emcommentation = emcommentation;
    }
    public String getPresent() {
        return this.present;
    }		
    public void setPresent(String present) {
        this.present = present;
    }
    public String getEmdate() {
        return this.emdate;
    }		
    public void setEmdate(String emdate) {
        this.emdate = emdate;
    }
    public String getPeriod() {
        return this.period;
    }		
    public void setPeriod(String period) {
        this.period = period;
    }
    public String getSalary() {
        return this.salary;
    }		
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getEmemail() {
        return this.ememail;
    }		
    public void setEmemail(String ememail) {
        this.ememail = ememail;
    }



    public String toString() {
        return super.toString() + "emid=[" + emid + "]\n" + "emserial=[" + emserial + "]\n" + "emupdate=[" + emupdate + "]\n" + "emname=[" + emname + "]\n" + "emcontact=[" + emcontact + "]\n" + "emexperience=[" + emexperience + "]\n" + "emposition=[" + emposition + "]\n" + "emskill=[" + emskill + "]\n" + "emskilla=[" + emskilla + "]\n" + "emskillaa=[" + emskillaa + "]\n" + "emdata=[" + emdata + "]\n" + "emlatest=[" + emlatest + "]\n" + "emcommentation=[" + emcommentation + "]\n" + "present=[" + present + "]\n" + "emdate=[" + emdate + "]\n" + "period=[" + period + "]\n" + "salary=[" + salary + "]\n" + "ememail=[" + ememail + "]\n";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
                return true;
        }
        if (!(obj instanceof Employee)) {
                return false;
        }
        Employee that = (Employee) obj;
        if (that.getEmid() != this.getEmid()) {
                return false;
        }
        if (!(that.getEmserial() == null ? this.getEmserial() == null
                        : that.getEmserial().equals(this.getEmserial()))) {
                return false;
        }
        if (!(that.getEmupdate() == null ? this.getEmupdate() == null
                        : that.getEmupdate().equals(this.getEmupdate()))) {
                return false;
        }
        if (!(that.getEmname() == null ? this.getEmname() == null
                        : that.getEmname().equals(this.getEmname()))) {
                return false;
        }
        if (!(that.getEmcontact() == null ? this.getEmcontact() == null
                        : that.getEmcontact().equals(this.getEmcontact()))) {
                return false;
        }
        if (that.getEmexperience() != this.getEmexperience()) {
                return false;
        }
        if (!(that.getEmposition() == null ? this.getEmposition() == null
                        : that.getEmposition().equals(this.getEmposition()))) {
                return false;
        }
        if (!(that.getEmskill() == null ? this.getEmskill() == null
                        : that.getEmskill().equals(this.getEmskill()))) {
                return false;
        }
        if (!(that.getEmskilla() == null ? this.getEmskilla() == null
                        : that.getEmskilla().equals(this.getEmskilla()))) {
                return false;
        }
        if (!(that.getEmskillaa() == null ? this.getEmskillaa() == null
                        : that.getEmskillaa().equals(this.getEmskillaa()))) {
                return false;
        }
        if (!(that.getEmdata() == null ? this.getEmdata() == null
                        : that.getEmdata().equals(this.getEmdata()))) {
                return false;
        }
        if (!(that.getEmlatest() == null ? this.getEmlatest() == null
                        : that.getEmlatest().equals(this.getEmlatest()))) {
                return false;
        }
        if (!(that.getEmcommentation() == null ? this.getEmcommentation() == null
                        : that.getEmcommentation().equals(this.getEmcommentation()))) {
                return false;
        }
        if (!(that.getPresent() == null ? this.getPresent() == null
                        : that.getPresent().equals(this.getPresent()))) {
                return false;
        }
        if (!(that.getEmdate() == null ? this.getEmdate() == null
                        : that.getEmdate().equals(this.getEmdate()))) {
                return false;
        }
        if (!(that.getPeriod() == null ? this.getPeriod() == null
                        : that.getPeriod().equals(this.getPeriod()))) {
                return false;
        }
        if (!(that.getSalary() == null ? this.getSalary() == null
                        : that.getSalary().equals(this.getSalary()))) {
                return false;
        }
        if (!(that.getEmemail() == null ? this.getEmemail() == null
                        : that.getEmemail().equals(this.getEmemail()))) {
                return false;
        }
    return true;
    }

}
