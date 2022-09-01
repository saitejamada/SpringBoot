package com.emp.model;

public class Employee {

	int eid;
	String name;
	int deptid;
	int salary;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public Employee(int eid, String name, int deptid, int salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.deptid = deptid;
		this.salary = salary;
	}
}
