package com.capg.jpa.p1;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
      private String certificatename;
      private String certifiedcourse;
      private String platform;
      
      
	public Certificate() {
		super();
	}


	public Certificate(String certificatename, String certifiedcourse, String platform) {
		super();
		this.certificatename = certificatename;
		this.certifiedcourse = certifiedcourse;
		this.platform = platform;
	}



	public String getCertificatename() {
		return certificatename;
	}


	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}


	public String getCertifiedcourse() {
		return certifiedcourse;
	}


	public void setCertifiedcourse(String certifiedcourse) {
		this.certifiedcourse = certifiedcourse;
	}


	public String getPlatform() {
		return platform;
	}


	public void setPlatform(String platform) {
		this.platform = platform;
	}


	@Override
	public String toString() {
		return "Certificate [certificatename=" + certificatename + ", certifiedcourse=" + certifiedcourse
				+ ", platform=" + platform + "]";
	}


      
}