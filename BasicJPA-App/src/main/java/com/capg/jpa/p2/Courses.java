package com.capg.jpa.p2;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CoursesDone")
public class Courses {
	@Id
	private int CourseId;
	private String coursename;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Courses_Students",
			joinColumns=@JoinColumn(name="Courses_Id"),
			inverseJoinColumns=@JoinColumn(name="Students"))
	private List<Student1> students;

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public List<Student1> getStudents() {
		return students;
	}

	public void setStudents(List<Student1> students) {
		this.students = students;
	}
	
	

}