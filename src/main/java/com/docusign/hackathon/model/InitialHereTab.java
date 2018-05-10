package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentId", "pageNumber", "tabLabel", "xPosition", "yPosition", "optional", "recipientId" })
public class InitialHereTab {

	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("pageNumber")
	private String pageNumber;
	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("xPosition")
	private String xPosition;
	@JsonProperty("yPosition")
	private String yPosition;
	@JsonProperty("optional")
	private String optional;
	@JsonProperty("recipientId")
	private String recipientId;

	@JsonProperty("documentId")
	public String getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	@JsonProperty("pageNumber")
	public String getPageNumber() {
		return pageNumber;
	}

	@JsonProperty("pageNumber")
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}

	@JsonProperty("xPosition")
	public String getXPosition() {
		return xPosition;
	}

	@JsonProperty("xPosition")
	public void setXPosition(String xPosition) {
		this.xPosition = xPosition;
	}

	@JsonProperty("yPosition")
	public String getYPosition() {
		return yPosition;
	}

	@JsonProperty("yPosition")
	public void setYPosition(String yPosition) {
		this.yPosition = yPosition;
	}

	@JsonProperty("optional")
	public String getOptional() {
		return optional;
	}

	@JsonProperty("optional")
	public void setOptional(String optional) {
		this.optional = optional;
	}

	@JsonProperty("recipientId")
	public String getRecipientId() {
		return recipientId;
	}

	@JsonProperty("recipientId")
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

}