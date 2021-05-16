package com.capg.jpa.p1;

import javax.persistence.Entity;

@Entity
public class InternalExam extends Examination{
	
	private int totalmarks;
	private int passmarks;
	private int marksobtaines;
	
	
	public InternalExam() {
		super();
	}
	
	public InternalExam(int totalmarks, int passmarks, int marksobtaines) {
		super();
		this.totalmarks = totalmarks;
		this.passmarks = passmarks;
		this.marksobtaines = marksobtaines;
	}



	public InternalExam(String subjectname,int totalmarks, int passmarks, int marksobtaines) {
		super(subjectname);
		this.totalmarks = totalmarks;
		this.passmarks = passmarks;
		this.marksobtaines = marksobtaines;
	}



	public int getTotalmarks() {
		return totalmarks;
	}



	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}



	public int getPassmarks() {
		return passmarks;
	}



	public void setPassmarks(int passmarks) {
		this.passmarks = passmarks;
	}



	public int getMarksobtaines() {
		return marksobtaines;
	}



	public void setMarksobtaines(int marksobtaines) {
		this.marksobtaines = marksobtaines;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + marksobtaines;
		result = prime * result + passmarks;
		result = prime * result + totalmarks;
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
		InternalExam other = (InternalExam) obj;
		if (marksobtaines != other.marksobtaines)
			return false;
		if (passmarks != other.passmarks)
			return false;
		if (totalmarks != other.totalmarks)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "InternalExam [totalmarks=" + totalmarks + ", passmarks=" + passmarks + ", marksobtaines="
				+ marksobtaines + "]";
	}

}