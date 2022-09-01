package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="emppost")
public class Employee {

	@Id
	@Min(value = 1000,message="should be greater than 1000")
	int eid;
	@Column
	@Size(min=5,message="minimum 8 characters")
	String name;
	@Column
	@Min(value = 10,message="should be Greater than 10")
	@Max(value = 30,message="should be Less than 30")
	int deptid;
	@Column
	@Min(value = 10000,message="should be Greater than 10000")
	@Max(value = 30000,message="should be Less than 30000")
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
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", deptid=" + deptid + ", salary=" + salary + "]";
	}
}
