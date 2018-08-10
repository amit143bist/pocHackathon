package com.docusign.hackathon.db.model;

public class PatientDetails {

	private String memName = "John Doe";
	
	private String memId = "987654";
	
	private String memDOB = "09/10/1980";
	
	private String memHIC = "ABC123456";
	
	private String memCaseNo = "CS995566";
	
	private String providerName = "Tim,";
	
	private String providerEmail = "docusign.sso+provider@gmail.com";
	
	private String technicianName = "Charles Smith";

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemDOB() {
		return memDOB;
	}

	public void setMemDOB(String memDOB) {
		this.memDOB = memDOB;
	}

	public String getMemHIC() {
		return memHIC;
	}

	public void setMemHIC(String memHIC) {
		this.memHIC = memHIC;
	}

	public String getMemCaseNo() {
		return memCaseNo;
	}

	public void setMemCaseNo(String memCaseNo) {
		this.memCaseNo = memCaseNo;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getTechnicianName() {
		return technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}
}