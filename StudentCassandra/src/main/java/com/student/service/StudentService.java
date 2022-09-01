package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	public Student addStudent(Student s) {
		return studentRepository.save(s);
	}
	public Student getOneStudent(int id) {
		return studentRepository.findById(id).get();
	}
	public Student updateStudent(Student s,int id) {
		Student s1=studentRepository.findById(id).get();
		return studentRepository.save(s);
	}
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
}
