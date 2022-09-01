package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.Department;


public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
