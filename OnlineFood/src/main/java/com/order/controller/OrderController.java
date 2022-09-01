package com.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.model.User;
import com.order.service.OrderService;



@Controller
public class OrderController {

	@Autowired
	OrderService os;
	
	@RequestMapping("/home")
	public String goHome(Model m)
	{
		Order o=new Order();
		m.addAttribute("bk", o);
		return "HomePage";
	}
	@RequestMapping("/insert")
	public String saveBook(@ModelAttribute("bk") Order o,Model m)
	{
		os.addOrder(o);
		return "Operation";
	}
	@RequestMapping("/reg")
	public String logIn(Model m)
	{
		User u=new User();
		m.addAttribute("us", u);
		return "AddUser";
	}
	@RequestMapping("/insertuser")
	public String User(@ModelAttribute("us") User u,Model m)
	{
		os.addUser(u);
		return "login";
	}
	
	@RequestMapping("/validateuser")
	public String validateuser(@ModelAttribute("us") User u,Model m)
	{
		String type=os.validateUser(u.getUsername());
		if(type.equals("ROLE_ADMIN"))
		{
			return "Admin";
		}
		else
		{
			return "Success";
		}
	}
	
	@RequestMapping("/menu")
	public String menu(Model m)
	{
		List<Order> list=os.getAllOrders();
		m.addAttribute("list", list);
		return "Menu";
	}
	
	@RequestMapping("/del")
	public String goDel(Model m)
	{
		Order o=new Order();
		m.addAttribute("bk", o);
		return "DeleteBook";
	}
	@RequestMapping("/delete")
	public String delBook(@ModelAttribute("bk") Order bk,Model m)
	{
		os.deleteOrder(bk.getOid());
		return "Operation";
	}
	@RequestMapping("/deluser")
	public String del(Model m)
	{
		User u=new User();
		m.addAttribute("us", u);
		return "DeleteUser";
	}
	
	@RequestMapping("/deleteuser")
	public String delUser(@ModelAttribute("us") User user,Model m)
	{
		os.deleteUser(user.getUsername());
		return "Operation";
	}
	@RequestMapping("/viewuser")
	public String viewuser(Model m)
	{
		List<User> list=os.getAllUsers();
		m.addAttribute("list", list);
		return "ViewAllUser";
	}
	
	@RequestMapping("/up")
	public String upBook(Model m)
	{
		Order o=new Order();
		m.addAttribute("bk", o);
		return "UpdateBook";
	}
	@RequestMapping("/update")
	public String upBook(@ModelAttribute("bk") Order bk,Model m)
	{
		os.updateOrder(bk);
		return "Operation";
	}
	@RequestMapping("/order")
	public String ord(Model m)
	{
		return "Final";
	}
	@GetMapping("/login")
	public String log(Model m)
	{
		User u=new User();
		m.addAttribute("us", u);
		return "login";
	}
}
