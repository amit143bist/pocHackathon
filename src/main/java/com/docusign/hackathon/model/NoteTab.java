package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tabLabel", "value", "width", "height", "pageNumber", "documentId", "recipientId", "xPosition",
		"yPosition" })
public class NoteTab {

	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("value")
	private String value;
	@JsonProperty("width")
	private Integer width;
	@JsonProperty("height")
	private Integer height;
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

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("width")
	public Integer getWidth() {
		return width;
	}

	@JsonProperty("width")
	public void setWidth(Integer width) {
		this.width = width;
	}

	@JsonProperty("height")
	public Integer getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(Integer height) {
		this.height = height;
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

}