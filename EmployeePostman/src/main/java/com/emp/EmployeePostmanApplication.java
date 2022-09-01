package com.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.emp.model.Employee;
import com.emp.model.User;
import com.emp.repo.EmployeeRepo;
import com.emp.repo.UserRepo;

@SpringBootApplication
public class EmployeePostmanApplication implements CommandLineRunner{

	@Autowired
	UserRepo ur;
	@Autowired
	EmployeeRepo er;
	
	@Autowired
	BCryptPasswordEncoder bpc;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeePostmanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUsername("sai");
		u.setPassword(this.bpc.encode("abc"));
		u.setRole("ROLE_NORMAL");
		ur.save(u);
		
		User u1=new User();
		u1.setUsername("admin");
		u1.setPassword(this.bpc.encode("admin"));
		u1.setRole("ROLE_ADMIN");
		ur.save(u1);
		
		Employee e=new Employee();
		e.setEid(1001);
		e.setName("saitejamada");
		e.setDeptid(10);
		e.setSalary(25000);
		er.save(e);
		
		Employee e1=new Employee();
		e1.setEid(1002);
		e1.setName("begariprashanth");
		e1.setDeptid(20);
		e1.setSalary(25000);
		er.save(e1);
		
		Employee e2=new Employee();
		e2.setEid(1003);
		e2.setName("begaripraveen");
		e2.setDeptid(10);
		e2.setSalary(25000);
		er.save(e2);
		
	}

}
