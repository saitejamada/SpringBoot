package com.college.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.college.model.Course;
import com.college.model.Faculty;
import com.college.model.Student;
import com.college.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	CollegeService cs;

	public CollegeService getCs() {
		return cs;
	}

	public void setCs(CollegeService cs) {
		this.cs = cs;
	}
	
	@PostMapping("/course")
	public ResponseEntity<Course> addCourse(@RequestBody Course c)
	{
		Course c1=cs.addCourse(c);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cid}").buildAndExpand(c.getCid()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student s)
	{
		Student s1=cs.addStudent(s);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentid}").buildAndExpand(s.getStudentid()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/course")
	public List<Course> getAllcourse()
	{
		List<Course> c1=cs.getAllCourse();
		return c1;
	}
	@GetMapping("/student")
	public List<Student> getAllStudent()
	{
		List<Student> s1=cs.getAllStudent();
		return s1;
	}
	@GetMapping("/student/{studentid}")
	public Student viewStudent(@PathVariable("studentid") int studid)
	{
		return cs.getStudent(studid);
	}
	@GetMapping("/course/{cid}")
	public Course viewCourse(@PathVariable("cid") int id)
	{
		return cs.getCourse(id);
	}
	@DeleteMapping("/student/{studentid}")
	public void deleteStudent(@PathVariable("studentid") int studid)
	{
		cs.deleteStudent(studid);
	}
	@DeleteMapping("/course/{cid}")
	public void deleteCourse(@PathVariable("cid") int id)
	{
		cs.deleteCourse(id);
	}
	@PutMapping("/course/{cid}")
	public Course updateHod(@RequestBody Course c)
	{
		return cs.updateCourse(c.getCid(),c.getHodname());
	}
	@PutMapping("/student/{studentid}")
	public Student updateStud(@RequestBody Student s)
	{
		return cs.updateStudent(s.getStudentid(), s.getName());
	}
	@PostMapping("/faculty")
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty f)
	{
		Faculty f1=cs.addFaculty(f);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{fid}").buildAndExpand(f.getFid()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/faculty")
	public List<Faculty> getAllfac()
	{
		return cs.viewAllfaculty();
	}
	@DeleteMapping("/faculty/{fid}")
	public void deleteFaculty(@PathVariable("fid") int id)
	{
		cs.deleteFaculty(id);
	}
	@GetMapping("/faculty/{fid}")
	public Faculty viewFaculty(@PathVariable("fid") int id)
	{
		return cs.viewFaculty(id);
	}
}
