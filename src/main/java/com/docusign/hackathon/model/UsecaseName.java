package com.docusign.hackathon.model;

public enum UsecaseName {

	ESTIMATES("Estimates");

	private UsecaseName(String flowName) {

		this.flowName = flowName;
	}

	private String flowName;

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
}
