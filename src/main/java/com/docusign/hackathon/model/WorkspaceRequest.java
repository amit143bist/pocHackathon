package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "workspaceName", "workspaceDescription" })
public class WorkspaceRequest {

	@JsonProperty("workspaceName")
	private String workspaceName;
	@JsonProperty("workspaceDescription")
	private String workspaceDescription;

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

}