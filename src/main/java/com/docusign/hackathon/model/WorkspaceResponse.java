package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "workspaceId", "siteId", "workspaceName", "workspaceDescription", "status", "workspaceUri",
		"billableAccountId", "created", "createdByInformation", "lastModified", "lastModifiedByInformation" })
public class WorkspaceResponse {

	@JsonProperty("workspaceId")
	private String workspaceId;
	@JsonProperty("siteId")
	private String siteId;
	@JsonProperty("workspaceName")
	private String workspaceName;
	@JsonProperty("workspaceDescription")
	private String workspaceDescription;
	@JsonProperty("status")
	private String status;
	@JsonProperty("workspaceUri")
	private String workspaceUri;
	@JsonProperty("billableAccountId")
	private String billableAccountId;
	@JsonProperty("created")
	private String created;
	@JsonProperty("createdByInformation")
	private UserInformation createdByInformation;
	@JsonProperty("lastModified")
	private String lastModified;
	@JsonProperty("lastModifiedByInformation")
	private UserInformation lastModifiedByInformation;

	@JsonProperty("workspaceId")
	public String getWorkspaceId() {
		return workspaceId;
	}

	@JsonProperty("workspaceId")
	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}

	@JsonProperty("siteId")
	public String getSiteId() {
		return siteId;
	}

	@JsonProperty("siteId")
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@JsonProperty("workspaceName")
	public String getWorkspaceName() {
		return workspaceName;
	}

	@JsonProperty("workspaceName")
	public void setWorkspaceName(String workspaceName) {
		this.workspaceName = workspaceName;
	}

	@JsonProperty("workspaceDescription")
	public String getWorkspaceDescription() {
		return workspaceDescription;
	}

	@JsonProperty("workspaceDescription")
	public void setWorkspaceDescription(String workspaceDescription) {
		this.workspaceDescription = workspaceDescription;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("workspaceUri")
	public String getWorkspaceUri() {
		return workspaceUri;
	}

	@JsonProperty("workspaceUri")
	public void setWorkspaceUri(String workspaceUri) {
		this.workspaceUri = workspaceUri;
	}

	@JsonProperty("billableAccountId")
	public String getBillableAccountId() {
		return billableAccountId;
	}

	@JsonProperty("billableAccountId")
	public void setBillableAccountId(String billableAccountId) {
		this.billableAccountId = billableAccountId;
	}

	@JsonProperty("created")
	public String getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(String created) {
		this.created = created;
	}

	@JsonProperty("createdByInformation")
	public UserInformation getCreatedByInformation() {
		return createdByInformation;
	}

	@JsonProperty("createdByInformation")
	public void setCreatedByInformation(UserInformation createdByInformation) {
		this.createdByInformation = createdByInformation;
	}

	@JsonProperty("lastModified")
	public String getLastModified() {
		return lastModified;
	}

	@JsonProperty("lastModified")
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	@JsonProperty("lastModifiedByInformation")
	public UserInformation getLastModifiedByInformation() {
		return lastModifiedByInformation;
	}

	@JsonProperty("lastModifiedByInformation")
	public void setLastModifiedByInformation(UserInformation lastModifiedByInformation) {
		this.lastModifiedByInformation = lastModifiedByInformation;
	}

}