package com.docusign.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "recipientInfoList", "emailBlurb", "emailSubject", "useCaseName", "inlineTemplateSequenceNumber" })
public class EstimateInfo {

	@JsonProperty("recipientInfoList")
	List<RecipientInfo> recipientInfoList;

	@JsonProperty("emailBlurb")
	private String emailBlurb;

	@JsonProperty("emailSubject")
	private String emailSubject;

	@JsonProperty("useCaseName")
	private String useCaseName;
	
	@JsonProperty("requestorEmail")
	private String requestorEmail;

	@JsonProperty("inlineTemplateSequenceNumber")
	private String inlineTemplateSequenceNumber;

	@JsonProperty("recipientInfoList")
	public List<RecipientInfo> getRecipientInfoList() {
		return recipientInfoList;
	}

	@JsonProperty("recipientInfoList")
	public void setRecipientInfoList(List<RecipientInfo> recipientInfoList) {
		this.recipientInfoList = recipientInfoList;
	}

	@JsonProperty("emailBlurb")
	public String getEmailBlurb() {
		return emailBlurb;
	}

	@JsonProperty("emailBlurb")
	public void setEmailBlurb(String emailBlurb) {
		this.emailBlurb = emailBlurb;
	}

	@JsonProperty("emailSubject")
	public String getEmailSubject() {
		return emailSubject;
	}

	@JsonProperty("emailSubject")
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	@JsonProperty("useCaseName")
	public String getUseCaseName() {
		return useCaseName;
	}

	@JsonProperty("useCaseName")
	public void setUseCaseName(String useCaseName) {
		this.useCaseName = useCaseName;
	}
	
	@JsonProperty("requestorEmail")
	public String getRequestorEmail() {
		return requestorEmail;
	}

	@JsonProperty("requestorEmail")
	public void setRequestorEmail(String requestorEmail) {
		this.requestorEmail = requestorEmail;
	}

	@JsonProperty("inlineTemplateSequenceNumber")
	public String getInlineTemplateSequenceNumber() {
		return inlineTemplateSequenceNumber;
	}

	@JsonProperty("inlineTemplateSequenceNumber")
	public void setInlineTemplateSequenceNumber(String inlineTemplateSequenceNumber) {
		this.inlineTemplateSequenceNumber = inlineTemplateSequenceNumber;
	}

	@Override
	public String toString() {
		return "EstimateInfo [recipientInfoList=" + recipientInfoList + ", emailBlurb=" + emailBlurb + ", emailSubject="
				+ emailSubject + ", inlineTemplateSequenceNumber=" + inlineTemplateSequenceNumber + "]";
	}

}