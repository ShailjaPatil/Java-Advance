package com.rays.bean;

import java.util.Date;

public class UserBean {
	
	private int id;
	private String firstname;
	private String lastname;
	private String loginid;
	private String password;
	private Date dob;
	private String address;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname( String firstname) {
		this.firstname= firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname= lastname;
	}
	
	public String getLoginid() {
		return loginid;
	}
	
	public void setLoginid(String loginid) {
		this.loginid= loginid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob= dob;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String adr) {
		this.address= adr;
	}

}
