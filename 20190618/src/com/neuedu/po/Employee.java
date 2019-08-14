package com.neuedu.po;

import java.sql.Date;

public class Employee {
	
	private String lname;
	private String lpass;
	
	private int empid;
	private int empnum;	
	private String ename;
	private int sex;
	private String department;
	private Date etime;
	private int bedid;
	private String bedty;
	
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLpass() {
		return lpass;
	}
	public void setLpass(String lpass) {
		this.lpass = lpass;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getEmpnum() {
		return empnum;
	}
	public void setEmpnum(int empnum) {
		this.empnum = empnum;
	}	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
	public int getBedid() {
		return bedid;
	}
	public void setBedid(int bedid) {
		this.bedid = bedid;
	}
	public String getBedty() {
		return bedty;
	}
	public void setBedty(String bedty) {
		this.bedty = bedty;
	}
}
