package com.emp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emp.model.Department;
import com.emp.model.Employee;
import com.emp.service.Employeeservice;

@SpringBootApplication
public class EmployeeAssociationApplication implements CommandLineRunner {

	@Autowired
	Employeeservice es;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeAssociationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Employee e=new Employee(100,"sai",2500);
		Employee e1=new Employee(101,"ram",4500);
		Employee e2=new Employee(102,"krishna",3500);
		 List<Employee> al=new ArrayList<Employee>();
		 al.add(e);al.add(e1);al.add(e2);
		 
		 Department d1=new Department(10,"it",al);
		 es.saveDept(d1);
		 
		 Employee e3=new Employee(103,"ravi",25500);
			Employee e4=new Employee(104,"suji",42500);
			Employee e5=new Employee(105,"vijay",32500);
			 List<Employee> al1=new ArrayList<Employee>();
			 al1.add(e3);al1.add(e4);al1.add(e5);
			 
			 Department d2=new Department(11,"developer",al1);
			 es.saveDept(d2);
 	}

}
