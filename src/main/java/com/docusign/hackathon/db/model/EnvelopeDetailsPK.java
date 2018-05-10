package com.docusign.hackathon.db.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnvelopeDetailsPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5199180225199736287L;
	
	@Column(name = "envelopeid")
	private UUID envelopeId;
	
	@Column(name = "recipientemail")
	private String recipientEmail;
	
	@Column(name = "recipientid")
	private BigInteger recipientId;

	public UUID getEnvelopeId() {
		return envelopeId;
	}

	public void setEnvelopeId(UUID envelopeId) {
		this.envelopeId = envelopeId;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	
	public BigInteger getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(BigInteger recipientId) {
		this.recipientId = recipientId;
	}

}