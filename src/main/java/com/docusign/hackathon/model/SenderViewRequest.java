package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "returnUrl" })
public class SenderViewRequest {

	@JsonProperty("returnUrl")
	private String returnUrl;

	@JsonProperty("returnUrl")
	public String getReturnUrl() {
		return returnUrl;
	}

	@JsonProperty("returnUrl")
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

}