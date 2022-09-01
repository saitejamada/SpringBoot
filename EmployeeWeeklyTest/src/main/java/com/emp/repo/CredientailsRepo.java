package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.Credientials;

public interface CredientailsRepo extends JpaRepository<Credientials, String> {

	 public Credientials findByUsername(String username);

	


}
