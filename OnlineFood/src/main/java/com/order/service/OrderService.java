package com.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.exception.UserNotFoundException;
import com.order.model.Order;
import com.order.model.User;
import com.order.repo.OrderRepo;
import com.order.repo.UserRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo or;
	@Autowired
	UserRepo ur;
	public OrderRepo getOr() {
		return or;
	}
	public void setOr(OrderRepo or) {
		this.or = or;
	}
	public UserRepo getUr() {
		return ur;
	}
	public void setUr(UserRepo ur) {
		this.ur = ur;
	}
	
	public void addUser(User user)
	{
		ur.save(user);
	}
	public void addOrder(Order order)
	{
		or.save(order);
	}
	
	public void deleteUser(String username)
	{
		User u=ur.findByUsername(username);
		if(u==null)
		{
			throw new UserNotFoundException("User Not Found With Username"+username);
		}
		else
		{
			ur.delete(u);
		}
		
	}
	public void deleteOrder(int id)
	{
		or.deleteById(id);
	}
	public User getUser(String username)
	{
		User u=ur.findByUsername(username);
		if(u==null)
		{
			throw new UserNotFoundException("User Not Found With Username"+username);
		}
		else
		{
			return u;
		}
		
	}
	public Order getOrder(int id)
	{
		return or.findById(id).get();
	}
	public List<User> getAllUsers()
	{
		return (List<User>)ur.findAll();
	}
	public List<Order> getAllOrders()
	{
		return (List<Order>) or.findAll();
	}
	public String validateUser(String username)
	{
		User u=ur.findByUsername(username);
		if(u==null)
		{
			throw new UserNotFoundException("User Not Found With Username"+username);
		}
		else
		{
			return u.getUtype();
		}
		
	}
	public void updateOrder(Order o1)
	{
		Order o=or.findById(o1.getOid()).get();
		or.save(o);
	}
}
