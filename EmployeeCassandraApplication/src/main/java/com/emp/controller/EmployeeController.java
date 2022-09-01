package com.emp.controller;

import java.util.List;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@RestController
public class EmployeeController {

	org.slf4j.Logger logger=LoggerFactory.getLogger("EmployeeController.class");

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	@GetMapping("/employee/{employeeId}")
	public Employee getOneEmployee(@PathVariable("employeeId") int id) {
		return employeeService.getOneEmployee(id);
	}
	@PostMapping("/employee")
	public Employee  addEmployee(@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}
	@PutMapping("/employee/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee e,@PathVariable("employeeId") int id) {
		return employeeService.updateEmployee(e, id);
	}
	@DeleteMapping("/employee/{employeeId}")
	public void deleteMapping(@PathVariable("employeeId") int id) {
		employeeService.deleteEmployee(id);
	}
}
