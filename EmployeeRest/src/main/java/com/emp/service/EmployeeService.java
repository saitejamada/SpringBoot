package com.emp.service;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployeeDetails();
	Employee getEmployeeById(int id);
}
