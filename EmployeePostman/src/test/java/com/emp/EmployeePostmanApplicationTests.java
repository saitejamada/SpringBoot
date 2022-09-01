package com.emp;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.emp.model.Employee;
import com.emp.model.User;
import com.emp.repo.EmployeeRepo;
import com.emp.repo.UserRepo;
import com.emp.service.EmployeeServiceimpl;
import net.bytebuddy.asm.Advice.This;

@SpringBootTest
class EmployeePostmanApplicationTests {
	
	@Mock
	EmployeeRepo er;
	@Autowired
	EmployeeServiceimpl es;
	@Mock
	UserRepo ur;

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
	void testVerifyFindallEmp() {
	es.getEmployeeDetails();
	verify(this.er).findAll();
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
//	@Test
//	void testDelete() {
//		Employee e=es.deleteEmployee(1101);
//		assertNull(e);
//	}
	@Test
	void testAddEmp()
	{
		Employee e=new Employee(1201,"karan",10,15000);
		when(es.addNewEmployee(e)).thenReturn(e);
		Employee e1=es.addNewEmployee(e);
		assertNotNull(e1);
	}
	
	@Test 
	void testValidAddEmp()
	{
		Employee e=new Employee(101,"karan",10,15000);
		Employee e1=es.addNewEmployee(e);
		assertNull(e1);
	}
	@Test
	void testGetEmployee() {
		Employee e=es.getEmployeeById(1221);
		assertNull(e);
	}
	@Test
	void testAddUser() {
		User u1=ur.save(new User("saitejamada","sai","ROLE_NORMAL"));
		assertNull(u1);
	}
	@Test
	void testFindUser() {
		User u1=new User("saiteja","sai","ROLE_NORMAL");
		when(ur.findByUsername("saiteja")).thenReturn(u1);
		User u=ur.findByUsername("saiteja");
		assertEquals(u, u1);
	}
}