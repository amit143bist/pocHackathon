package com.docusign.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "approveTabs", "declineTabs", "textTabs" })
public class Tabs {

	@JsonProperty("approveTabs")
	private List<ApproveTab> approveTabs = null;
	@JsonProperty("declineTabs")
	private List<DeclineTab> declineTabs = null;
	@JsonProperty("textTabs")
	private List<TextTab> textTabs = null;
	@JsonProperty("fullNameTabs")
	private List<FullNameTab> fullNameTabs = null;

	@JsonProperty("approveTabs")
	public List<ApproveTab> getApproveTabs() {
		return approveTabs;
	}

	@JsonProperty("approveTabs")
	public void setApproveTabs(List<ApproveTab> approveTabs) {
		this.approveTabs = approveTabs;
	}

	@JsonProperty("declineTabs")
	public List<DeclineTab> getDeclineTabs() {
		return declineTabs;
	}

	@JsonProperty("declineTabs")
	public void setDeclineTabs(List<DeclineTab> declineTabs) {
		this.declineTabs = declineTabs;
	}

	@JsonProperty("textTabs")
	public List<TextTab> getTextTabs() {
		return textTabs;
	}

	@JsonProperty("textTabs")
	public void setTextTabs(List<TextTab> textTabs) {
		this.textTabs = textTabs;
	}
	
	@JsonProperty("fullNameTabs")
	public List<FullNameTab> getFullNameTabs() {
		return fullNameTabs;
	}

	@JsonProperty("fullNameTabs")
	public void setFullNameTabs(List<FullNameTab> fullNameTabs) {
		this.fullNameTabs = fullNameTabs;
	}

}