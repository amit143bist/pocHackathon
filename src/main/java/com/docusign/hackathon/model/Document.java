package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentBase64", "documentId", "remoteUrl", "fileExtension", "name", "transformPdfFields" })
public class Document {

	@JsonProperty("documentBase64")
	private String documentBase64;
	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("remoteUrl")
	private String remoteUrl;
	@JsonProperty("fileExtension")
	private String fileExtension;
	@JsonProperty("name")
	private String name;
	@JsonProperty("transformPdfFields")
	private String transformPdfFields;

	@JsonProperty("documentBase64")
	public String getDocumentBase64() {
		return documentBase64;
	}

	@JsonProperty("documentBase64")
	public void setDocumentBase64(String documentBase64) {
		this.documentBase64 = documentBase64;
	}

	@JsonProperty("documentId")
	public String getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	
	@JsonProperty("remoteUrl")
	public String getRemoteUrl() {
		return remoteUrl;
	}

	@JsonProperty("remoteUrl")
	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	@JsonProperty("fileExtension")
	public String getFileExtension() {
		return fileExtension;
	}

	@JsonProperty("fileExtension")
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("transformPdfFields")
	public String getTransformPdfFields() {
		return transformPdfFields;
	}

	@JsonProperty("transformPdfFields")
	public void setTransformPdfFields(String transformPdfFields) {
		this.transformPdfFields = transformPdfFields;
	}
}