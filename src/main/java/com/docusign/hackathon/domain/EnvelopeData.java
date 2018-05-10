package com.docusign.hackathon.domain;

public class EnvelopeData {

	private String envelopeId;

	private String envelopeSubject;

	private String recipientEmail;

	public String getEnvelopeId() {
		return envelopeId;
	}

	public void setEnvelopeId(String envelopeId) {
		this.envelopeId = envelopeId;
	}

	public String getEnvelopeSubject() {
		return envelopeSubject;
	}

	public void setEnvelopeSubject(String envelopeSubject) {
		this.envelopeSubject = envelopeSubject;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
}