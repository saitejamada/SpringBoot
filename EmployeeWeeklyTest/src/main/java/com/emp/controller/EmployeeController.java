package com.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.emp.model.Credientials;
import com.emp.model.Employee;
import com.emp.service.EmployeeService;



@Controller
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@RequestMapping(path="/reg")
	public String validateUser(Model m)
	{
		Employee emp=new Employee();
		m.addAttribute("reg", emp);
		return "login1";
	}
	
	
	@RequestMapping("/register")
	public String register(@Valid  @ModelAttribute("reg") Employee emp,BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			return "login1";
			} else {
				es.saveEmp(emp);
				return "Success";
			}
	}
	
	@RequestMapping("/validateuser")
	public String validateuser(@ModelAttribute("us")Credientials c,Model m)
	{
		String type=es.validateUser(c);	
		if(type==null)
		{
			Employee emp1=new Employee();
			m.addAttribute("reg", emp1);
			return "login1";
		}
		else if(type.equals("user"))
		{
			Employee emp=es.findEmp(c.getUsername());
			if(emp==null)
			{
				Employee emp1=new Employee();
				m.addAttribute("reg", emp1);
				return "login1";
			}
			else
			{
				m.addAttribute("reg", emp);
				return "HomePage";
			}
			
		}
		else
		{
			return "Admin";

		}
	}
	@RequestMapping("/update/{username}")
	public String updateEmp(@Valid @PathVariable("username") String name,@ModelAttribute("reg") Employee e,Model m,BindingResult bindingResult)
	{
		
		Employee emp=es.findEmp(name);
		m.addAttribute("reg", emp);
		System.out.println("in upadte before return");
		return "Update"; 
		
	}
	@RequestMapping("/updateEmp")
	public String update(@Valid @ModelAttribute("reg")Employee e,Model m,BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			return "Update";
		}
		else
		{
			Employee emp=es.updateEmp(e);
			m.addAttribute("reg", emp);
			return "HomePage";
		}
		
	}
	@RequestMapping("/viewall")
	public String viewAlEmp(Model m)
	{
		List<Employee> list=es.allEmp();
		m.addAttribute("list", list);
		return "ViewAll";
	}
	@RequestMapping("/viewUsers")
	public String viewAllUsers(Model m)
	{
		List<Credientials> l=es.allUser();
		m.addAttribute("list", l);
		return "View";
	}
	
	@RequestMapping("/reguser")
	public String adminlogin(Model m) {
		Credientials c=new Credientials();
		m.addAttribute("credential",c);
		return"loginregister";
	}
	@RequestMapping("/save")
	public String insert(@Valid @ModelAttribute("credential") Credientials credential ,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "loginregister";
		}
		else {
		es.saveCrediantials(credential);
		m.addAttribute("us",credential);
			return "login";
		}
	}
	@RequestMapping("/delete")
	public String del(Model m)
	{
		Credientials c=new Credientials();
		m.addAttribute("cs",c);
		return "Delete";
	}
	@RequestMapping("/del")
	public String deleteUser(@ModelAttribute("credential") Credientials credential,Model m)
	{
		es.deleteUser(credential);
		return "View";
	}
	@RequestMapping("/login")
	public String login(Model m)
	{
		Credientials c=new Credientials();
		m.addAttribute("us",c);
		return "login";
	}
}
