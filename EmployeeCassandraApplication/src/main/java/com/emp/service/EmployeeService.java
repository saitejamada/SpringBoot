package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteEmployee(int employeeId) {
		employeeRepo.deleteById(employeeId);
	}
	public Employee  updateEmployee(Employee emp,int employeeId) {
		Employee e=employeeRepo.findById(employeeId).get();
		return employeeRepo.save(emp);
	}
	public Employee getOneEmployee(int employeeId) {
		return employeeRepo.findById(employeeId).get();
	}
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
}
