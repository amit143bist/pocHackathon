package com.docusign.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "textCustomFields" })
public class CustomFields {

	@JsonProperty("textCustomFields")
	private List<TextCustomField> textCustomFields = null;

	@JsonProperty("textCustomFields")
	public List<TextCustomField> getTextCustomFields() {
		return textCustomFields;
	}

	@JsonProperty("textCustomFields")
	public void setTextCustomFields(List<TextCustomField> textCustomFields) {
		this.textCustomFields = textCustomFields;
	}

}