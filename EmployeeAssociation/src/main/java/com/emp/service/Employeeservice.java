package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Department;
import com.emp.model.Employee;
import com.emp.repo.DepartmentRepo;
import com.emp.repo.EmployeeRepo;

@Service
public class Employeeservice {

	@Autowired
	DepartmentRepo dr;
	@Autowired
	EmployeeRepo er;
	public DepartmentRepo getDr() {
		return dr;
	}
	public void setDr(DepartmentRepo dr) {
		this.dr = dr;
	}
	public EmployeeRepo getEr() {
		return er;
	}
	public void setEr(EmployeeRepo er) {
		this.er = er;
	}
	public void saveDept(Department d)
	{
		dr.save(d);
	}
	public void saveEmp(Employee e )
	{
		er.save(e);
	}
	public List<Department> getAllEmp()
	{
		return dr.findAll();
	}
	
}
