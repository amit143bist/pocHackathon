package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "email", "embeddedRecipientStartURL" })
public class RecipientInfo {

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("embeddedRecipientStartURL")
	private String embeddedRecipientStartURL;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty("embeddedRecipientStartURL")
	public String getEmbeddedRecipientStartURL() {
		return embeddedRecipientStartURL;
	}

	@JsonProperty("embeddedRecipientStartURL")
	public void setEmbeddedRecipientStartURL(String embeddedRecipientStartURL) {
		this.embeddedRecipientStartURL = embeddedRecipientStartURL;
	}

}