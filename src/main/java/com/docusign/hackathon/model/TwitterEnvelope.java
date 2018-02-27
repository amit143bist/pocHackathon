package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "postMessage", "submitterName", "accessCode", "approverName", "approverEmail" })
public class TwitterEnvelope {

	@JsonProperty("postMessage")
	private String postMessage;
	@JsonProperty("submitterName")
	private String submitterName;
	@JsonProperty("accessCode")
	private String accessCode;
	@JsonProperty("approverName")
	private String approverName;
	@JsonProperty("approverEmail")
	private String approverEmail;

	@JsonProperty("postMessage")
	public String getPostMessage() {
		return postMessage;
	}

	@JsonProperty("postMessage")
	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	@JsonProperty("submitterName")
	public String getSubmitterName() {
		return submitterName;
	}

	@JsonProperty("submitterName")
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}

	@JsonProperty("accessCode")
	public String getAccessCode() {
		return accessCode;
	}

	@JsonProperty("accessCode")
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@JsonProperty("approverName")
	public String getApproverName() {
		return approverName;
	}

	@JsonProperty("approverName")
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	@JsonProperty("approverEmail")
	public String getApproverEmail() {
		return approverEmail;
	}

	@JsonProperty("approverEmail")
	public void setApproverEmail(String approverEmail) {
		this.approverEmail = approverEmail;
	}

	@Override
	public String toString(){
		
		return "accessCode- " + accessCode + " approverName " + approverName + " approverEmail- " + approverEmail;
	}
}