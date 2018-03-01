package com.docusign.hackathon.db.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="notificationdetail")
public class NotificationDetail {

	@EmbeddedId
	private NotificationDetailPK notificationDetailPK;
	
	@Column(name="notificationstatus")
	private String notificationStatus;
	
	@Column(name="senderemail")
	private String senderEmail;
	
	public NotificationDetail() {
		super();
	}

	public NotificationDetailPK getNotificationDetailPK() {
		return notificationDetailPK;
	}

	public void setNotificationDetailPK(NotificationDetailPK notificationDetailPK) {
		this.notificationDetailPK = notificationDetailPK;
	}

	public String getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
}