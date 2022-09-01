package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.User;

public interface UserRepo extends JpaRepository<User, String>{

	public User findByUsername(String username);
}
