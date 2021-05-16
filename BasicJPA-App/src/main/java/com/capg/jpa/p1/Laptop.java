package com.capg.jpa.p1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int lappyid;
	private String laptopname;
	
	@OneToOne(mappedBy = "laptop")
	private Student student;

	public Laptop() {
		super();
	}

	public Laptop(int id, String laptopname) {
		super();
		this.lappyid = id;
		this.laptopname = laptopname;
	}

	public int getLappyid() {
		return lappyid;
	}

	public void setLappyid(int lappyid) {
		this.lappyid = lappyid;
	}

	public String getLaptopname() {
		return laptopname;
	}

	public void setLaptopname(String laptopname) {
		this.laptopname = laptopname;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + lappyid + ", laptopname=" + laptopname +  "]";
	}

}
