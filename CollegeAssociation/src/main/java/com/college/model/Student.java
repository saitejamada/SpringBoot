package com.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student_college1")
public class Student {

	@Id
	int studentid;
	@Column
	String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	Course course;
	
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student(int studentid, String name, Course course) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.course = course;
	}
	public Student() {
		super();
	}
	
	
}
