package com.docusign.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "compositeTemplates", "status", "emailBlurb", "emailSubject" })
public class CompositeTemplateRequest {

	@JsonProperty("compositeTemplates")
	private List<CompositeTemplate> compositeTemplates = null;
	@JsonProperty("status")
	private String status;
	@JsonProperty("emailBlurb")
	private String emailBlurb;
	@JsonProperty("emailSubject")
	private String emailSubject;

	@JsonProperty("compositeTemplates")
	public List<CompositeTemplate> getCompositeTemplates() {
		return compositeTemplates;
	}

	@JsonProperty("compositeTemplates")
	public void setCompositeTemplates(List<CompositeTemplate> compositeTemplates) {
		this.compositeTemplates = compositeTemplates;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("emailBlurb")
	public String getEmailBlurb() {
		return emailBlurb;
	}

	@JsonProperty("emailBlurb")
	public void setEmailBlurb(String emailBlurb) {
		this.emailBlurb = emailBlurb;
	}

	@JsonProperty("emailSubject")
	public String getEmailSubject() {
		return emailSubject;
	}

	@JsonProperty("emailSubject")
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

}