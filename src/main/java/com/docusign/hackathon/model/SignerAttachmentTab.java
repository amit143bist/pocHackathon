package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tabLabel", "pageNumber", "documentId", "recipientId", "xPosition", "yPosition", "scaleValue",
		"optional" })
public class SignerAttachmentTab {

	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("pageNumber")
	private Integer pageNumber;
	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("xPosition")
	private Integer xPosition;
	@JsonProperty("yPosition")
	private Integer yPosition;
	@JsonProperty("scaleValue")
	private Integer scaleValue;
	@JsonProperty("optional")
	private Boolean optional;

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}

	@JsonProperty("pageNumber")
	public Integer getPageNumber() {
		return pageNumber;
	}

	@JsonProperty("pageNumber")
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@JsonProperty("documentId")
	public String getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
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
	public Integer getXPosition() {
		return xPosition;
	}

	@JsonProperty("xPosition")
	public void setXPosition(Integer xPosition) {
		this.xPosition = xPosition;
	}

	@JsonProperty("yPosition")
	public Integer getYPosition() {
		return yPosition;
	}

	@JsonProperty("yPosition")
	public void setYPosition(Integer yPosition) {
		this.yPosition = yPosition;
	}

	@JsonProperty("scaleValue")
	public Integer getScaleValue() {
		return scaleValue;
	}

	@JsonProperty("scaleValue")
	public void setScaleValue(Integer scaleValue) {
		this.scaleValue = scaleValue;
	}

	@JsonProperty("optional")
	public Boolean getOptional() {
		return optional;
	}

	@JsonProperty("optional")
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

}