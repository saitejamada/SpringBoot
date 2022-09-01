package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@GetMapping("/")
	public String home()
	{
		return "Welcome to My First Rest Application";
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmp()
	{
		return es.getEmployeeDetails();
	}
	
	@GetMapping("/employee/{eid}")
	public Employee getEmp(@PathVariable int eid)
	{
		return es.getEmployeeById(eid);
		
	}
}
