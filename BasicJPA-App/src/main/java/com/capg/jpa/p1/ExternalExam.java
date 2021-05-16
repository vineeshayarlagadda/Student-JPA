package com.capg.jpa.p1;

import javax.persistence.Entity;

@Entity
public class ExternalExam extends Examination{
	private int totalMarkes;
	private int passMarks;
	private int marksobtained;
	
	public ExternalExam() {
		super();
	}

	public ExternalExam(int totalMarkes, int passMarks, int marksobtained) {
		super();
		this.totalMarkes = totalMarkes;
		this.passMarks = passMarks;
		this.marksobtained = marksobtained;
	}
	public ExternalExam(String subjectname,int totalMarkes, int passMarks, int marksobtained) {
		super(subjectname);
		this.totalMarkes = totalMarkes;
		this.passMarks = passMarks;
		this.marksobtained = marksobtained;
	}

	public int getTotalMarkes() {
		return totalMarkes;
	}


	public void setTotalMarkes(int totalMarkes) {
		this.totalMarkes = totalMarkes;
	}


	public int getPassMarks() {
		return passMarks;
	}


	public void setPassMarks(int passMarks) {
		this.passMarks = passMarks;
	}


	public int getMarksobtained() {
		return marksobtained;
	}

	public void setMarksobtained(int marksobtained) {
		this.marksobtained = marksobtained;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + marksobtained;
		result = prime * result + passMarks;
		result = prime * result + totalMarkes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExternalExam other = (ExternalExam) obj;
		if (marksobtained != other.marksobtained)
			return false;
		if (passMarks != other.passMarks)
			return false;
		if (totalMarkes != other.totalMarkes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExternalExam [totalMarkes=" + totalMarkes + ", passMarks=" + passMarks + ", marksobtained="
				+ marksobtained + "]";
	}


}
