package com.docusign.hackathon.db.model;

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
	private String workspaceId;

	@Column(name = "recipientname")
	private String recipientName;

	@Column(name = "clientuserid")
	private String clientUserId;
	
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

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getClientUserId() {
		return clientUserId;
	}

	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
	}
	
	public String getEnvelopeSubject() {
		return envelopeSubject;
	}

	public void setEnvelopeSubject(String envelopeSubject) {
		this.envelopeSubject = envelopeSubject;
	}
}