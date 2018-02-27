package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "buttonText", "width", "height", "declineReason", "tabLabel", "font", "fontColor", "fontSize",
		"documentId", "recipientId", "pageNumber", "xPosition", "yPosition", "tabId", "templateLocked",
		"templateRequired" })
public class DeclineTab {

	@JsonProperty("buttonText")
	private String buttonText;
	@JsonProperty("width")
	private Integer width;
	@JsonProperty("height")
	private Integer height;
	@JsonProperty("declineReason")
	private String declineReason;
	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("font")
	private String font;
	@JsonProperty("fontColor")
	private String fontColor;
	@JsonProperty("fontSize")
	private String fontSize;
	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("pageNumber")
	private String pageNumber;
	@JsonProperty("xPosition")
	private String xPosition;
	@JsonProperty("yPosition")
	private String yPosition;
	@JsonProperty("tabId")
	private String tabId;
	@JsonProperty("templateLocked")
	private String templateLocked;
	@JsonProperty("templateRequired")
	private String templateRequired;

	@JsonProperty("buttonText")
	public String getButtonText() {
		return buttonText;
	}

	@JsonProperty("buttonText")
	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
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

	@JsonProperty("declineReason")
	public String getDeclineReason() {
		return declineReason;
	}

	@JsonProperty("declineReason")
	public void setDeclineReason(String declineReason) {
		this.declineReason = declineReason;
	}

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}

	@JsonProperty("font")
	public String getFont() {
		return font;
	}

	@JsonProperty("font")
	public void setFont(String font) {
		this.font = font;
	}

	@JsonProperty("fontColor")
	public String getFontColor() {
		return fontColor;
	}

	@JsonProperty("fontColor")
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	@JsonProperty("fontSize")
	public String getFontSize() {
		return fontSize;
	}

	@JsonProperty("fontSize")
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
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

	@JsonProperty("pageNumber")
	public String getPageNumber() {
		return pageNumber;
	}

	@JsonProperty("pageNumber")
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
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

	@JsonProperty("tabId")
	public String getTabId() {
		return tabId;
	}

	@JsonProperty("tabId")
	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	@JsonProperty("templateLocked")
	public String getTemplateLocked() {
		return templateLocked;
	}

	@JsonProperty("templateLocked")
	public void setTemplateLocked(String templateLocked) {
		this.templateLocked = templateLocked;
	}

	@JsonProperty("templateRequired")
	public String getTemplateRequired() {
		return templateRequired;
	}

	@JsonProperty("templateRequired")
	public void setTemplateRequired(String templateRequired) {
		this.templateRequired = templateRequired;
	}

}