package com.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
