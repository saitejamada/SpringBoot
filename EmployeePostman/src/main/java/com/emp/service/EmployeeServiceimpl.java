package com.emp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emp.model.Employee;
import com.emp.repo.EmployeeRepo;
import com.emp.repo.UserRepo;

@Component
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeRepo er;
	@Autowired
	UserRepo ur;
	
	public EmployeeServiceimpl(EmployeeRepo er2) {
		// TODO Auto-generated constructor stub
		this.er=er2;
	}

	@Override
	public List<Employee> getEmployeeDetails() {
		
		return (List<Employee>) er.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		try {
			Employee e1= er.findById(id).get();
			return e1;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Employee addNewEmployee(Employee e) {
		// TODO Auto-generated method stub
		return er.save(e);		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee e=getEmployeeById(id);
		er.delete(e);
	}

	@Override
	public Employee updateEmp(Employee e, int sid) {
		// TODO Auto-generated method stub
		Employee e1=getEmployeeById(sid);
		return er.save(e);
	}

	public EmployeeServiceimpl() {
		super();
	}

}
