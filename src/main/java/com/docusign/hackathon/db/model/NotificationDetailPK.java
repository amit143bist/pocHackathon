package com.docusign.hackathon.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotificationDetailPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5652343968888902530L;

	@Column(name = "envelopeid")
	private String envelopeId;

	@Column(name = "recipientemail")
	private String recipientEmail;

	public String getEnvelopeId() {
		return envelopeId;
	}

	public void setEnvelopeId(String envelopeId) {
		this.envelopeId = envelopeId;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

}