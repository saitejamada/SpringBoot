package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Credientials;
import com.emp.model.Employee;
import com.emp.repo.CredientailsRepo;
import com.emp.repo.EmployeeRepo;



@Service
public class EmployeeService {

	@Autowired
	CredientailsRepo cr;
	@Autowired
	EmployeeRepo er;
	public CredientailsRepo getCr() {
		return cr;
	}
	public void setCr(CredientailsRepo cr) {
		this.cr = cr;
	}
	public EmployeeRepo getEr() {
		return er;
	}
	public void setEr(EmployeeRepo er) {
		this.er = er;
	}
	public void saveEmp(Employee e)
	{
		er.save(e);
	}
	public void saveCrediantials(Credientials c)
	{
		cr.save(c);
	}
	public String validateUser(Credientials c1)
	{
		Credientials c=cr.findByUsername(c1.getUsername());
		if(c==null)
			return null;
		else
		return c.getRole();
	}
	public Employee findEmp(String name)
	{
		return er.findByusername(name);
	}
	public Employee updateEmp(Employee e)
	{
		Employee e1=er.findByusername(e.getUsername());
		e1.setEmployeeid(e.getEmployeeid());
		e1.setEmail(e1.getEmail());
		e1.setAddress(e.getAddress());
		e1.setMobileno(e.getMobileno());
		e1.setName(e.getName());
		e1.setSalary(e.getSalary());
		return er.save(e);
	}
	public List<Employee> allEmp()
	{
		return er.findAll();
	}
	public List<Credientials> allUser()
	{
		return cr.findAll();
	}
	public  void deleteUser(Credientials c1)
	{
		cr.delete(c1);
	}
}
