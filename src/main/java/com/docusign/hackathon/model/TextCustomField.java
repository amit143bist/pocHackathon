package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "value", "show", "required" })
public class TextCustomField {

	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private String value;
	@JsonProperty("show")
	private String show;
	@JsonProperty("required")
	private String required;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("show")
	public String getShow() {
		return show;
	}

	@JsonProperty("show")
	public void setShow(String show) {
		this.show = show;
	}

	@JsonProperty("required")
	public String getRequired() {
		return required;
	}

	@JsonProperty("required")
	public void setRequired(String required) {
		this.required = required;
	}

}