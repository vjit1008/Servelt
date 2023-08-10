package com.neebalgurukul.model;

import java.util.Date;

public class Login {
    private int id;
    private String pswd;
    private String uname;
    private Date lastModified;
    private boolean active;

    public int getId() {
	return id;
    }

    public String getPswd() {
	return pswd;
    }

    public void setPswd(String pswd) {
	this.pswd = pswd;
    }

    public String getUname() {
	return uname;
    }

    public void setUname(String uname) {
	this.uname = uname;
    }

    public Date getLastModified() {
	return lastModified;
    }

    public void setLastModified(Date lastModified) {
	this.lastModified = lastModified;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    @Override
    public String toString() {
	return "Login [id=" + id + ", pswd=" + pswd + ", uname=" + uname + ", lastModified=" + lastModified
		+ ", active=" + active + "]";
    }

    public static void main(String[] args) {

    }
}
