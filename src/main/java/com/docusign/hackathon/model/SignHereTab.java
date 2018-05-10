package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentId", "pageNumber", "recipientId", "xPosition", "yPosition", "tabLabel" })
public class SignHereTab {

	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("pageNumber")
	private String pageNumber;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("xPosition")
	private String xPosition;
	@JsonProperty("yPosition")
	private String yPosition;
	@JsonProperty("tabLabel")
	private String tabLabel;

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

	@JsonProperty("recipientId")
	public String getRecipientId() {
		return recipientId;
	}

	@JsonProperty("recipientId")
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
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

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}
}