package com.capg.jpa.p1;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.capg.jpa.p3.Insurance;



@Entity   

@Table(name = "BVRITHStudents")
public class Student {
	@Id
	@Column(name = "RollNumber")
	private int Id;
	
	@Column(name=" StudentName")
	private String name;
	
	private int age;
	private int marks;
	
	
	@Embedded
	private Course technicalCourse;
		
		@Embedded
		@AttributeOverrides({
			@AttributeOverride(name = "coursename",column = @Column(name="nontechnical_coursename")),
			@AttributeOverride(name = "courseplatform",column = @Column(name="nontechnical_courseplatform")),
		})
		private Course nontechnical_course;
		
		@ElementCollection
		@CollectionTable(name="CertificateInfo",joinColumns = @JoinColumn(name="Id"))
		Set<Certificate> certificate;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "Laptop_Id",referencedColumnName = "lappyid")
		private Laptop laptop;
		
	//   one to many 
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="RollNumber")
		private List<Courses> courses;
	
	//-------------------------------
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="StudnetId")
		private List<Examination> examList;
		
	public Student() {
		super();
	}


	public Student(int id, String name, int age, int marks, Course technicalCourse, Course nontechnical_course,
			Set<Certificate> certificate, Laptop laptop) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.technicalCourse = technicalCourse;
		this.nontechnical_course = nontechnical_course;
		this.certificate = certificate;
		this.laptop = laptop;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public Course getTechnicalCourse() {
		return technicalCourse;
	}


	public void setTechnicalCourse(Course technicalCourse) {
		this.technicalCourse = technicalCourse;
	}


	public Course getNontechnical_course() {
		return nontechnical_course;
	}


	public void setNontechnical_course(Course nontechnical_course) {
		this.nontechnical_course = nontechnical_course;
	}


	public Set<Certificate> getCertificate() {
		return certificate;
	}


	public void setCertificate(Set<Certificate> certificate) {
		this.certificate = certificate;
	}


	public Laptop getLaptop() {
		return laptop;
	}


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	public List<Courses> getCourses() {
		return courses;
	}


	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	

	public List<Examination> getExamList() {
		return examList;
	}


	public void setExamList(List<Examination> examList) {
		this.examList = examList;
	}


	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", age=" + age + ", marks=" + marks + ", technicalCourse="
				+ technicalCourse + ", nontechnical_course=" + nontechnical_course + ", certificate=" + certificate+"]";
	}


}
