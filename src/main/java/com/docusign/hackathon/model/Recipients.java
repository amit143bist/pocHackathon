package com.docusign.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "signers", "certifiedDeliveries", "recipientCount", "currentRoutingOrder" })
public class Recipients {

	@JsonProperty("signers")
	private List<Signer> signers = null;
	@JsonProperty("certifiedDeliveries")
	private List<CertifiedDelivery> certifiedDeliveries = null;
	@JsonProperty("recipientCount")
	private String recipientCount;
	@JsonProperty("currentRoutingOrder")
	private String currentRoutingOrder;

	@JsonProperty("signers")
	public List<Signer> getSigners() {
		return signers;
	}

	@JsonProperty("signers")
	public void setSigners(List<Signer> signers) {
		this.signers = signers;
	}
	
	@JsonProperty("certifiedDeliveries")
	public List<CertifiedDelivery> getCertifiedDeliveries() {
	return certifiedDeliveries;
	}

	@JsonProperty("certifiedDeliveries")
	public void setCertifiedDeliveries(List<CertifiedDelivery> certifiedDeliveries) {
	this.certifiedDeliveries = certifiedDeliveries;
	}

	@JsonProperty("recipientCount")
	public String getRecipientCount() {
		return recipientCount;
	}

	@JsonProperty("recipientCount")
	public void setRecipientCount(String recipientCount) {
		this.recipientCount = recipientCount;
	}

	@JsonProperty("currentRoutingOrder")
	public String getCurrentRoutingOrder() {
		return currentRoutingOrder;
	}

	@JsonProperty("currentRoutingOrder")
	public void setCurrentRoutingOrder(String currentRoutingOrder) {
		this.currentRoutingOrder = currentRoutingOrder;
	}

}