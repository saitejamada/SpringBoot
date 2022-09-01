package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Department;
import com.emp.model.Employee;
import com.emp.service.Employeeservice;

@RestController
public class EmployeeController {

	@Autowired
	Employeeservice es;
	
	@GetMapping("/emp")
	public List<Department> getAll()
	{
		return es.getAllEmp();
	}
}
