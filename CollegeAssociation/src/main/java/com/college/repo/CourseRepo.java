package com.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
