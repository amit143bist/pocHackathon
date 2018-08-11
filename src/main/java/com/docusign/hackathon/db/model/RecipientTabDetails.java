package com.docusign.hackathon.db.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipienttabdetails")
public class RecipientTabDetails {

	@Id
	@Column(name = "tabid")
	private UUID tabId;
	
	@Column(name = "recipientid")
	private UUID recipientId;

	@Column(name = "tabname")
	private String tabName;
	
	@Column(name = "tabvalue")
	private String tabValue;
	
	public UUID getTabId() {
		return tabId;
	}

	public void setTabId(UUID tabId) {
		this.tabId = tabId;
	}

	public UUID getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(UUID recipientId) {
		this.recipientId = recipientId;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getTabValue() {
		return tabValue;
	}

	public void setTabValue(String tabValue) {
		this.tabValue = tabValue;
	}
}