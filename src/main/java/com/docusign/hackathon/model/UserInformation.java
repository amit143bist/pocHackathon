package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "workspaceUserId", "siteId", "status", "type", "workspaceId", "accountId", "userId", "accountName",
		"userName", "email", "created", "createdById", "lastModified", "lastModifiedById", "activeSince" })
public class UserInformation {

	@JsonProperty("workspaceUserId")
	private String workspaceUserId;
	@JsonProperty("siteId")
	private String siteId;
	@JsonProperty("status")
	private String status;
	@JsonProperty("type")
	private String type;
	@JsonProperty("workspaceId")
	private String workspaceId;
	@JsonProperty("accountId")
	private String accountId;
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("accountName")
	private String accountName;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("created")
	private String created;
	@JsonProperty("createdById")
	private String createdById;
	@JsonProperty("lastModified")
	private String lastModified;
	@JsonProperty("lastModifiedById")
	private String lastModifiedById;
	@JsonProperty("activeSince")
	private String activeSince;

	@JsonProperty("workspaceUserId")
	public String getWorkspaceUserId() {
		return workspaceUserId;
	}

	@JsonProperty("workspaceUserId")
	public void setWorkspaceUserId(String workspaceUserId) {
		this.workspaceUserId = workspaceUserId;
	}

	@JsonProperty("siteId")
	public String getSiteId() {
		return siteId;
	}

	@JsonProperty("siteId")
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("workspaceId")
	public String getWorkspaceId() {
		return workspaceId;
	}

	@JsonProperty("workspaceId")
	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}

	@JsonProperty("accountId")
	public String getAccountId() {
		return accountId;
	}

	@JsonProperty("accountId")
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("accountName")
	public String getAccountName() {
		return accountName;
	}

	@JsonProperty("accountName")
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	@JsonProperty("userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("created")
	public String getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(String created) {
		this.created = created;
	}

	@JsonProperty("createdById")
	public String getCreatedById() {
		return createdById;
	}

	@JsonProperty("createdById")
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	@JsonProperty("lastModified")
	public String getLastModified() {
		return lastModified;
	}

	@JsonProperty("lastModified")
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	@JsonProperty("lastModifiedById")
	public String getLastModifiedById() {
		return lastModifiedById;
	}

	@JsonProperty("lastModifiedById")
	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	@JsonProperty("activeSince")
	public String getActiveSince() {
		return activeSince;
	}

	@JsonProperty("activeSince")
	public void setActiveSince(String activeSince) {
		this.activeSince = activeSince;
	}

}