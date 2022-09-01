package com.emp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="department")
public class Department {

	@Id
	int deptId;
	@Column
	String name;
	@OneToMany(cascade = CascadeType.ALL)
	
	List<Employee> emp;
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + ", emp=" + emp + "]";
	}
	public Department() {
		super();
	}
	public Department(int deptId, String name, List<Employee> emp) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.emp = emp;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
}
