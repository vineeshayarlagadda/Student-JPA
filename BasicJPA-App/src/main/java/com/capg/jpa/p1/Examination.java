package com.capg.jpa.p1;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
		 name = "Examination_Type",
		 discriminatorType =DiscriminatorType.STRING
		)
public class Examination implements Comparable<Examination>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int examId;
	private String examName;
	
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Student student;
	
	public Examination() {
		super();
	}

	public Examination( String examName) {
		super();
		this.examName = examName;
	}


	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
		result = prime * result + ((examName == null) ? 0 : examName.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Examination other = (Examination) obj;
		if (examId != other.examId)
			return false;
		if (examName == null) {
			if (other.examName != null)
				return false;
		} else if (!examName.equals(other.examName))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	
//	@Override
	public int compareTo(Examination o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public String toString() {
		return "Examination [examId=" + examId + ", examName=" + examName + "]";
	}


}
