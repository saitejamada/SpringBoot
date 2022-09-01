package com.emp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.emp.model.Employee;
import com.emp.repo.EmployeeRepo;
import com.emp.service.EmployeeServiceimpl;

@SpringBootTest
public class Employeetesting {

	@Mock
	EmployeeRepo er;
	@Mock
	EmployeeServiceimpl es;
	ArrayList al;
	
	@BeforeEach
	void setUp() throws Exception
	{
	MockitoAnnotations.initMocks(this);
	es=new EmployeeServiceimpl(this.er);
	al=new ArrayList();
	al.add(new Employee(1101,"ram",10,15000));
	al.add(new Employee(1102,"kamal",20,10000));
	al.add(new Employee(1103,"mahesh",10,25000));
	al.add(new Employee(1104,"charan",30,15000));
	}
	
	@Test
	void testEmpById()
	{
		when(er.getById(1109)).thenReturn(new Employee(1109,"suresh",10,15000));
		Employee e1=er.getById(1109);
		assertEquals(1109,e1.getEid());
	}
	@Test
	void testUpdateEmp() {
		Employee e=new Employee(1101,"ramesh",10,15000);
		when(es.updateEmp(e, 1101)).thenReturn(e);
		assertEquals(e,e);
	}
	@Test
	void testAddEmp()
	{
		Employee e=new Employee(1201,"karan",10,15000);
		when(es.addNewEmployee(e)).thenReturn(e);
		Employee e1=es.addNewEmployee(e);
		assertNotNull(e1);
	}
	@Test
	void testVerifyFindallEmp() {
	es.getEmployeeDetails();
	verify(this.er).findAll();
	}
	

	
	
}
