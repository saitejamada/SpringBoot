package com.student.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.student.model.Student;

public interface StudentRepository extends  CassandraRepository<Student,Integer>{

}
