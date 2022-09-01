package com.emp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emp.exception.CustomisedEmployeeResponseEntityExceptionHandler;
import com.emp.exception.EmployeeNotFoundException;
import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@RestController

public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	
	@PostMapping("/employee")
	public ResponseEntity<Object> addNewEmp(@Valid @RequestBody Employee e)
	{
		Employee e1= es.addNewEmployee(e);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{eid}").buildAndExpand(e1.getEid()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmp()
	{
		return es.getEmployeeDetails();
	}
	
	@DeleteMapping("/employee/{eid}")
	public void viewEmp(@PathVariable("eid") int eid)
	{
		 es.deleteEmployee(eid);
		
	}
	
	@PutMapping("/employee/{eid}")
	public Employee updateEmp(@RequestBody Employee e,@PathVariable("eid") int eid)
	{
		System.out.println(eid);
		return es.updateEmp(e, eid);			
	}
	
	@GetMapping("/employee/{eid}")
	public Employee getEmp(@PathVariable("eid") int eid)
	{
		Employee e1= es.getEmployeeById(eid);
		if(e1==null)
			throw new EmployeeNotFoundException("given eid "+eid+" Not Found or Not Present");
		else
			return e1;
	}
	@GetMapping("/")
	public String home()
	{
		return "This Is HomePage Accessed By All";
	}
	@PostMapping("/addEmp")
	public 	Employee addEmp(@Valid @RequestBody Employee e)
	{
		System.out.println(e);
		return e;
	}
	@PutMapping("/addEmp/{eid}")
	public Employee upEmp(@RequestBody Employee e,@PathVariable("eid") int eid)
	{
		return e;
	}
}
