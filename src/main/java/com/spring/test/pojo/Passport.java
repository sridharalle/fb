package com.spring.test.pojo;

public class Passport {
	
	private int pptId;
	
	private String issueCity;
	
	public Passport() {
		System.out.println("Passport object created");
	}

	public int getPptId() {
		return pptId;
	}

	public void setPptId(int pptId) {
		this.pptId = pptId;
	}

	public String getIssueCity() {
		return issueCity;
	}

	public void setIssueCity(String issueCity) {
		this.issueCity = issueCity;
	}
	
	

}
