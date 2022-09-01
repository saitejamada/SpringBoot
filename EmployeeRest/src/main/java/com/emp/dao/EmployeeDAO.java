package com.emp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.emp.model.Employee;

@Component
public class EmployeeDAO {

	static List<Employee> list=new ArrayList<Employee>();
	
	public List<Employee> showEmployees()
	{
		list.add(new Employee(112,"Saiteja",10,25000));
		list.add(new Employee(113,"Teja",20,15000));
		list.add(new Employee(114,"Pavan",10,35000));
		list.add(new Employee(116,"Ram",10,18000));
		list.add(new Employee(117,"Krishna",20,25000));
		return list;
	}
	
	public Employee getEmployeeById(int id)
	{
		for (Employee employee : list) {		
			if(employee.getEid()==id)
			{
				System.out.println("found");
				return employee;
			}		
		}
		return null;
	}
	
}
