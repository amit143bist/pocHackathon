package com.docusign.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "document", "inlineTemplates", "serverTemplates", "compositeTemplateId" })
public class CompositeTemplate {

	@JsonProperty("document")
	private Document document;
	@JsonProperty("inlineTemplates")
	private List<InlineTemplate> inlineTemplates = null;
	@JsonProperty("serverTemplates")
	private List<ServerTemplate> serverTemplates = null;
	@JsonProperty("compositeTemplateId")
	private String compositeTemplateId;

	@JsonProperty("document")
	public Document getDocument() {
		return document;
	}

	@JsonProperty("document")
	public void setDocument(Document document) {
		this.document = document;
	}

	@JsonProperty("inlineTemplates")
	public List<InlineTemplate> getInlineTemplates() {
		return inlineTemplates;
	}

	@JsonProperty("inlineTemplates")
	public void setInlineTemplates(List<InlineTemplate> inlineTemplates) {
		this.inlineTemplates = inlineTemplates;
	}

	@JsonProperty("serverTemplates")
	public List<ServerTemplate> getServerTemplates() {
		return serverTemplates;
	}

	@JsonProperty("serverTemplates")
	public void setServerTemplates(List<ServerTemplate> serverTemplates) {
		this.serverTemplates = serverTemplates;
	}

	@JsonProperty("compositeTemplateId")
	public String getCompositeTemplateId() {
		return compositeTemplateId;
	}

	@JsonProperty("compositeTemplateId")
	public void setCompositeTemplateId(String compositeTemplateId) {
		this.compositeTemplateId = compositeTemplateId;
	}

}