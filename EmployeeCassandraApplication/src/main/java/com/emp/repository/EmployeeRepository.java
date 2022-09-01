package com.emp.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import com.emp.model.Employee;

public interface EmployeeRepository extends  CassandraRepository<Employee,Integer> {

}
