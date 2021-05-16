package com.capg.jpa.p2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity   
@Table(name = "Students")
public class Student1 {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int Id;
		
		@Column(name=" StudentName")
		private String name;
		
		private int age;
		private int marks;
		
		@ManyToMany(cascade=CascadeType.ALL)
		@JoinTable(
				name="Courses_Students",
				joinColumns=@JoinColumn(name="Student_Id"),
				inverseJoinColumns=@JoinColumn(name="Courses_Id"))
		private List<Courses> Course;

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

		public List<Courses> getCourse() {
			return Course;
		}

		public void setCourse(List<Courses> course) {
			Course = course;
		}
		

}