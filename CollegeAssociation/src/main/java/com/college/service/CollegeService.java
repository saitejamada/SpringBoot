package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.exception.CollegeException;
import com.college.model.Course;
import com.college.model.Faculty;
import com.college.model.Student;
import com.college.repo.CourseRepo;
import com.college.repo.FacultyRepo;
import com.college.repo.StudentRepo;

@Service
public class CollegeService {

	@Autowired
	CourseRepo cr;
	@Autowired
	StudentRepo sr;
	@Autowired
	FacultyRepo fr;
	
	public CourseRepo getCr() {
		return cr;
	}
	public void setCr(CourseRepo cr) {
		this.cr = cr;
	}
	public StudentRepo getSr() {
		return sr;
	}
	public void setSr(StudentRepo sr) {
		this.sr = sr;
	}
	public Course addCourse(Course c)
	{
		return cr.save(c);
	}
	public Student addStudent(Student s)
	{
		return sr.save(s);
	}
	public List<Student> getAllStudent()
	{
		return sr.findAll();
	}
	public List<Course> getAllCourse()
	{
		return  cr.findAll();
	}
	public Student getStudent(int id)
	{
		try {
			return sr.findById(id).get();
		}
		catch(Exception e){
			throw new CollegeException("No Student NotFound Or Exist With"+id);
		}
		
	}
	public Course getCourse(int id)
	{
		try {
			return cr.findById(id).get();
		}
		catch(Exception e){
			throw new CollegeException("No Course NotFound Or Exist With"+id);
		}
	}
	public void deleteCourse(int id)
	{
		try {
			Course c1= cr.findById(id).get();
			cr.delete(c1);
		}
		catch(Exception e){
			throw new CollegeException("No Course NotFound Or Exist With"+id);
		}
	}
	public void deleteStudent(int id)
	{
		try {
			Student s1= sr.findById(id).get();
			sr.delete(s1);
		}
		catch(Exception e){
			throw new CollegeException("No Student NotFound Or Exist With"+id);
		}
	}
	public Student updateStudent(int id,String name)
	{
		try {
			Student s=sr.findById(id).get();
			s.setName(name);
			sr.save(s);
			return s;
		}catch (Exception e) {
			// TODO: handle exception
			throw new CollegeException("No Student NotFound Or Exist With"+id);
		}
	}
	public Course updateCourse(int id,String name)
	{
		try {
			Course c1= cr.findById(id).get();
			c1.setHodname(name);
			cr.save(c1);
			return c1;
		}
		catch(Exception e){
			throw new CollegeException("No Course NotFound Or Exist With"+id);
		}
	}
	public Faculty addFaculty(Faculty f)
	{
		return fr.save(f);
	}
	public List<Faculty> viewAllfaculty()
	{
		return fr.findAll();
	}
	public void deleteFaculty(int id)
	{
		try {
			Faculty f1=fr.findById(id).get();
			fr.delete(f1);
		}catch (Exception e) {
			// TODO: handle exception
			throw new CollegeException("No Faculty NotFound Or Exist With"+id);
		}
	}
	
	public Faculty viewFaculty(int id)
	{
		try {
			Faculty f1=fr.findById(id).get();
			return f1;
		}catch (Exception e) {
			// TODO: handle exception
			throw new CollegeException("No Faculty NotFound Or Exist With"+id);
		}
	}
}
