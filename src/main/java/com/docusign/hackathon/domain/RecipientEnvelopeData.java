package com.docusign.hackathon.domain;

import java.util.List;

public class RecipientEnvelopeData {

	private String envelopeId;

	private String usecaseName;

	private String recipientId;

	private String recipientName;

	private String recipientEmail;

	private List<RecipientTabData> recipientTabDataList;

	public String getEnvelopeId() {
		return envelopeId;
	}

	public void setEnvelopeId(String envelopeId) {
		this.envelopeId = envelopeId;
	}

	public String getUsecaseName() {
		return usecaseName;
	}

	public void setUsecaseName(String usecaseName) {
		this.usecaseName = usecaseName;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public List<RecipientTabData> getRecipientTabDataList() {
		return recipientTabDataList;
	}

	public void setRecipientTabDataList(List<RecipientTabData> recipientTabDataList) {
		this.recipientTabDataList = recipientTabDataList;
	}

}