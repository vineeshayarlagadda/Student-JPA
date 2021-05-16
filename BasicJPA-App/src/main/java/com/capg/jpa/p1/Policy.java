package com.capg.jpa.p1;

import javax.persistence.Embeddable;

@Embeddable
public class Policy {
	private String policyname;
	
     
	public Policy() {
		super();
	}

	public Policy(String policyname) {
		super();
		this.policyname = policyname;
	}

	public String getPolicyname() {
		return policyname;
	}

	public void setPolicyname(String policyname) {
		this.policyname = policyname;
	}

	@Override
	public String toString() {
		return "Policy [policyname=" + policyname + "]";
	}
	

}
