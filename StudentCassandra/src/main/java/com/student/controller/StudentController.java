package com.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.model.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired	
	private StudentService studentService;

	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return studentService.getAllStudents();
	}
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student s) {
		return studentService.addStudent(s);	
	}
	@PutMapping("/student/{studentId}")
	public Student updateStudent(@RequestBody Student s,@PathVariable("studentId") int id) {
		return studentService.updateStudent(s, id);
	}
	@GetMapping("/student/{studentId}")
	public Student getOneStudent(@PathVariable("studentId") int id) {
		return studentService.getOneStudent(id);
	}
	@DeleteMapping("/student/{studentId}")
	public void deleteOneStudent(@PathVariable("studentId") int id) {
		 studentService.deleteStudent(id);
	}
}
