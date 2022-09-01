package com.emp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="emp_credientails")
public class Employee {

	@Id
	@Min(value = 5000,message="Should BE 5  Digits")
	int employeeid;
	@NotNull
	@Size(min =4,message="Should Be Atleast 6 characters")
	String username;
	String name;
	String address;
	@Pattern(regexp="(0|91)?[7-9][0-9]{9}",message="mobile should be 10 digits")
	String mobileno;
	@Pattern(regexp="[a-z][._a-z0-9]+@[a-z]+.[c][o][m]+$",message = "Email Should start with lowercase character and end with com")
	String email;
	@Min(value=10000,message="greater than 10000")
	int salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	Credientials cs;
	
	public Credientials getCs() {
		return cs;
	}
	public void setCs(Credientials cs) {
		this.cs = cs;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", username=" + username + ", name=" + name + ", address="
				+ address + ", mobileno=" + mobileno + ", email=" + email + ", salary=" + salary + "]";
	}
	
}
