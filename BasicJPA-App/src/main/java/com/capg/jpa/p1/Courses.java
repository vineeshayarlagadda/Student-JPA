package com.capg.jpa.p1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CoursesOneToMany")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int course_id;
	private String coursename;
	
	@ManyToOne
	@JoinColumn(name="RollNumber")
	private Student student;

	public Courses() {
		super();
	}

	public Courses( String coursename) {
		super();
		this.coursename = coursename;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", coursename=" + coursename + "]";
	}
	
	

}
