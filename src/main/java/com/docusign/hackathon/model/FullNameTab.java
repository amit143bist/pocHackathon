package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tabLabel", "conditionalParentLabel", "conditionalParentValue", "fontSize", "underline", "italic",
		"fontColor", "bold", "font", "pageNumber", "documentId", "recipientId", "height", "width", "xPosition",
		"yPosition" })
public class FullNameTab {

	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("conditionalParentLabel")
	private Object conditionalParentLabel;
	@JsonProperty("conditionalParentValue")
	private Object conditionalParentValue;
	@JsonProperty("fontSize")
	private String fontSize;
	@JsonProperty("underline")
	private Boolean underline;
	@JsonProperty("italic")
	private Boolean italic;
	@JsonProperty("fontColor")
	private String fontColor;
	@JsonProperty("bold")
	private Boolean bold;
	@JsonProperty("font")
	private String font;
	@JsonProperty("pageNumber")
	private Integer pageNumber;
	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("height")
	private Integer height;
	@JsonProperty("width")
	private Integer width;
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

	@JsonProperty("conditionalParentLabel")
	public Object getConditionalParentLabel() {
		return conditionalParentLabel;
	}

	@JsonProperty("conditionalParentLabel")
	public void setConditionalParentLabel(Object conditionalParentLabel) {
		this.conditionalParentLabel = conditionalParentLabel;
	}

	@JsonProperty("conditionalParentValue")
	public Object getConditionalParentValue() {
		return conditionalParentValue;
	}

	@JsonProperty("conditionalParentValue")
	public void setConditionalParentValue(Object conditionalParentValue) {
		this.conditionalParentValue = conditionalParentValue;
	}

	@JsonProperty("fontSize")
	public String getFontSize() {
		return fontSize;
	}

	@JsonProperty("fontSize")
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	@JsonProperty("underline")
	public Boolean getUnderline() {
		return underline;
	}

	@JsonProperty("underline")
	public void setUnderline(Boolean underline) {
		this.underline = underline;
	}

	@JsonProperty("italic")
	public Boolean getItalic() {
		return italic;
	}

	@JsonProperty("italic")
	public void setItalic(Boolean italic) {
		this.italic = italic;
	}

	@JsonProperty("fontColor")
	public String getFontColor() {
		return fontColor;
	}

	@JsonProperty("fontColor")
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	@JsonProperty("bold")
	public Boolean getBold() {
		return bold;
	}

	@JsonProperty("bold")
	public void setBold(Boolean bold) {
		this.bold = bold;
	}

	@JsonProperty("font")
	public String getFont() {
		return font;
	}

	@JsonProperty("font")
	public void setFont(String font) {
		this.font = font;
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

	@JsonProperty("height")
	public Integer getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(Integer height) {
		this.height = height;
	}

	@JsonProperty("width")
	public Integer getWidth() {
		return width;
	}

	@JsonProperty("width")
	public void setWidth(Integer width) {
		this.width = width;
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