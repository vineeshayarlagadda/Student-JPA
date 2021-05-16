package com.capg.jpa.p1;

import javax.persistence.Embeddable;

@Embeddable
public class Course {
	private String coursename;
	private String courseplatform;
	
	
	public Course() {
		super();
	}


	public Course(String coursename, String courseplatform) {
		super();
		this.coursename = coursename;
		this.courseplatform = courseplatform;
	}


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


	public String getCourseplatform() {
		return courseplatform;
	}


	public void setCourseplatform(String courseplatform) {
		this.courseplatform = courseplatform;
	}


	@Override
	public String toString() {
		return "Course [coursename=" + coursename + ", courseplatform=" + courseplatform + "]";
	}
	

}
