package com.docusign.hackathon.db.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "envelopedetails")
public class EnvelopeDetails {

	@EmbeddedId
	private EnvelopeDetailsPK envelopeDetailsPK;

	@Column(name = "envelopestatus")
	private String envelopeStatus;

	@Column(name = "workspaceid")
	private UUID workspaceId;

	@Column(name = "recipientname")
	private String recipientName;

	@Column(name = "clientuserid")
	private UUID clientUserId;
	
	@Column(name = "envelopesubject")
	private String envelopeSubject;

	public EnvelopeDetailsPK getEnvelopeDetailsPK() {
		return envelopeDetailsPK;
	}

	public void setEnvelopeDetailsPK(EnvelopeDetailsPK envelopeDetailsPK) {
		this.envelopeDetailsPK = envelopeDetailsPK;
	}
	
	public String getEnvelopeStatus() {
		return envelopeStatus;
	}

	public void setEnvelopeStatus(String envelopeStatus) {
		this.envelopeStatus = envelopeStatus;
	}

	public UUID getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(UUID workspaceId) {
		this.workspaceId = workspaceId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public UUID getClientUserId() {
		return clientUserId;
	}

	public void setClientUserId(UUID clientUserId) {
		this.clientUserId = clientUserId;
	}
	
	public String getEnvelopeSubject() {
		return envelopeSubject;
	}

	public void setEnvelopeSubject(String envelopeSubject) {
		this.envelopeSubject = envelopeSubject;
	}
}