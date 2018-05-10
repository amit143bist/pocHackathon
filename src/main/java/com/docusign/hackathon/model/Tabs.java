package com.docusign.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "approveTabs", "declineTabs", "textTabs", "noteTabs", "signerAttachmentTabs", "signHereTabs",
		"initialHereTabs" })
public class Tabs {

	@JsonProperty("approveTabs")
	private List<ApproveTab> approveTabs = null;
	@JsonProperty("declineTabs")
	private List<DeclineTab> declineTabs = null;
	@JsonProperty("textTabs")
	private List<TextTab> textTabs = null;
	@JsonProperty("fullNameTabs")
	private List<FullNameTab> fullNameTabs = null;
	@JsonProperty("noteTabs")
	private List<NoteTab> noteTabs = null;
	@JsonProperty("signerAttachmentTabs")
	private List<SignerAttachmentTab> signerAttachmentTabs = null;
	@JsonProperty("signHereTabs")
	private List<SignHereTab> signHereTabs = null;
	@JsonProperty("initialHereTabs")
	private List<InitialHereTab> initialHereTabs = null;

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

	@JsonProperty("noteTabs")
	public List<NoteTab> getNoteTabs() {
		return noteTabs;
	}

	@JsonProperty("noteTabs")
	public void setNoteTabs(List<NoteTab> noteTabs) {
		this.noteTabs = noteTabs;
	}

	@JsonProperty("signerAttachmentTabs")
	public List<SignerAttachmentTab> getSignerAttachmentTabs() {
		return signerAttachmentTabs;
	}

	@JsonProperty("signerAttachmentTabs")
	public void setSignerAttachmentTabs(List<SignerAttachmentTab> signerAttachmentTabs) {
		this.signerAttachmentTabs = signerAttachmentTabs;
	}

	@JsonProperty("signHereTabs")
	public List<SignHereTab> getSignHereTabs() {
		return signHereTabs;
	}

	@JsonProperty("signHereTabs")
	public void setSignHereTabs(List<SignHereTab> signHereTabs) {
		this.signHereTabs = signHereTabs;
	}

	@JsonProperty("initialHereTabs")
	public List<InitialHereTab> getInitialHereTabs() {
		return initialHereTabs;
	}

	@JsonProperty("initialHereTabs")
	public void setInitialHereTabs(List<InitialHereTab> initialHereTabs) {
		this.initialHereTabs = initialHereTabs;
	}
}