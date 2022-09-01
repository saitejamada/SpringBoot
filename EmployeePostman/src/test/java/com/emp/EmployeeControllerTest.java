package com.emp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.emp.controller.EmployeeController;
import com.emp.exception.EmployeeNotFoundException;
import com.emp.helper.JwtTokenUtil;
import com.emp.model.Employee;
import com.emp.repo.EmployeeRepo;
import com.emp.repo.UserRepo;
import com.emp.service.EmployeeServiceimpl;
import com.emp.userdetailservice.CustomUserDetailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@MockBean
	EmployeeRepo er;
	@MockBean
	UserRepo ur;
	@Autowired
	EmployeeController ec;
	@MockBean
	CustomUserDetailService cds;
	@MockBean
	JwtTokenUtil ju;
	@Autowired
	MockMvc mvc;
	@MockBean
	EmployeeServiceimpl es;
	
	@Test
	void testString() throws Exception
	{
	mvc.perform(get("/home"))
	.andExpect(content().string(containsString("This Is HomePage Accessed By All")))
	.andDo(print());
	}
	
	@Test
	void testGetAllEmployees() throws Exception
	{
		ArrayList al=new ArrayList();
		al.add(new Employee(1101,"ram",10,15000));
		al.add(new Employee(1102,"kamal",20,10000));
		al.add(new Employee(1103,"mahesh",10,25000));
		al.add(new Employee(1104,"charan",30,15000));
		
		when(es.getEmployeeDetails()).thenReturn(al);
		MvcResult result=mvc.perform(get("/employees")).andExpect(status().isOk()).andReturn();
		String actualResponse=result.getResponse().getContentAsString();
		System.out.println("Actual Response is "+actualResponse);
		String exceptedResult=new ObjectMapper().writeValueAsString(al);
		System.out.println("Expected Response is "+exceptedResult);
		assertThat(actualResponse).isEqualTo(exceptedResult);
		
	}
	@Test
	void testAddEmployee() throws JsonProcessingException, Exception {
		Employee e=new Employee();
		e.setEid(1300);
		e.setName("ramakrishna");
		e.setDeptid(30);
		e.setSalary(20000);
		es.addNewEmployee(e);
		when (es.addNewEmployee(e)).thenReturn(e);
		
		mvc.perform (MockMvcRequestBuilders.post("/addEmp")
		 .content(new ObjectMapper().writeValueAsString(e))
		 .contentType("application/json"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").exists())
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").value(1300))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.name").value ("ramakrishna"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.deptid").value(30))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.salary").value(20000))
		 .andDo (print());
	}
	@Test
	void testvalidEmployee() throws JsonProcessingException, Exception {
		Employee e=new Employee();
		e.setEid(1300);
		e.setName("ramakrishna");
		e.setDeptid(40);
		e.setSalary(20000);
		es.addNewEmployee(e);
		when (es.addNewEmployee(e)).thenReturn(e);
		
		mvc.perform (MockMvcRequestBuilders.post("/addEmp")
		 .content(new ObjectMapper().writeValueAsString(e))
		 .contentType("application/json"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").exists())
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").value(1300))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.name").value ("ramakrishna"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.deptid").value(40))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.salary").value(20000))
		 .andDo (print());
	}
	@Test
	void testUpdateEmployee() throws Exception {
		Employee e=new Employee(1400,"karan",30,25000);
		Employee e1=new Employee(1400,"karunakar",30,25000);
		es.addNewEmployee(e1);
		es.updateEmp(e1, 1400);
		when(es.updateEmp(e1, 1400)).thenReturn(e1);
		
		mvc.perform(MockMvcRequestBuilders.put("/addEmp/1400")
		.content(new ObjectMapper().writeValueAsString(e1))
		 .contentType("application/json"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").exists())
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").value(1400))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.name").value ("karunakar"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.deptid").value(30))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.salary").value(25000))
		 .andDo (print());
	}
	
	 @Test
	 void testDeleteEmployee () throws Exception
	 {
	 Employee e=new Employee ();
	 	e.setEid(1300);
		e.setName("ramakrishna");
		e.setDeptid(40);
		e.setSalary(20000);
	 //ss.deleteStudent (1);
	 Mockito.doNothing().when (es).deleteEmployee(1300);
	 mvc.perform(delete("/employee/1300")).andExpect(status().isOk());
	 Mockito.verify(es,times(1)).deleteEmployee(1300);
	 }
	 @Test
	 void testEmployeeSearchById() throws Exception
	 {
		 Employee e=new Employee(1500,"karan",30,25000);
		 es.addNewEmployee(e);
		 when(es.getEmployeeById(1500)).thenReturn(e);
		
		 mvc.perform(MockMvcRequestBuilders.get("/employee/1500")
		.content(new ObjectMapper().writeValueAsString(e))
		.contentType("application/json"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").exists())
		 .andExpect (MockMvcResultMatchers.jsonPath("$.eid").value(1500))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.name").value ("karan"))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.deptid").value(30))
		 .andExpect (MockMvcResultMatchers.jsonPath("$.salary").value(25000))
		 .andExpect(status().isOk())
		 .andDo(print());
		 System.out.println("Id exists");
	 }
	 @Test
	 void testEmployeeNotFound() throws Exception {
		 when(es.getEmployeeById(12200)).thenThrow(new EmployeeNotFoundException(" No Employee with ID  12200"));
		 mvc.perform(MockMvcRequestBuilders.get("/employee/12200")
					.contentType("application/json"))
					 .andExpect(status().isNotFound())
					 .andDo(print());
					 System.out.println("Id Not exists 12200");
	 	}
	 
}
