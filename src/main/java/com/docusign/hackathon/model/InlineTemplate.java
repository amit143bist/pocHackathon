package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "recipients", "sequence", "customFields" })
public class InlineTemplate {

	@JsonProperty("recipients")
	private Recipients recipients;
	@JsonProperty("sequence")
	private String sequence;
	@JsonProperty("customFields")
	private CustomFields customFields;

	@JsonProperty("recipients")
	public Recipients getRecipients() {
		return recipients;
	}

	@JsonProperty("recipients")
	public void setRecipients(Recipients recipients) {
		this.recipients = recipients;
	}

	@JsonProperty("sequence")
	public String getSequence() {
		return sequence;
	}

	@JsonProperty("sequence")
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@JsonProperty("customFields")
	public CustomFields getCustomFields() {
		return customFields;
	}

	@JsonProperty("customFields")
	public void setCustomFields(CustomFields customFields) {
		this.customFields = customFields;
	}

}