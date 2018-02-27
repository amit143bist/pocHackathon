package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "email", "roleName", "note", "routingOrder", "status", "templateAccessCodeRequired",
		"deliveryMethod", "recipientId" })
public class CertifiedDelivery {

	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("roleName")
	private String roleName;
	@JsonProperty("note")
	private String note;
	@JsonProperty("routingOrder")
	private Integer routingOrder;
	@JsonProperty("status")
	private String status;
	@JsonProperty("templateAccessCodeRequired")
	private Object templateAccessCodeRequired;
	@JsonProperty("deliveryMethod")
	private String deliveryMethod;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("clientUserId")
	private String clientUserId;
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

	@JsonProperty("roleName")
	public String getRoleName() {
		return roleName;
	}

	@JsonProperty("roleName")
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@JsonProperty("note")
	public String getNote() {
		return note;
	}

	@JsonProperty("note")
	public void setNote(String note) {
		this.note = note;
	}

	@JsonProperty("routingOrder")
	public Integer getRoutingOrder() {
		return routingOrder;
	}

	@JsonProperty("routingOrder")
	public void setRoutingOrder(Integer routingOrder) {
		this.routingOrder = routingOrder;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("templateAccessCodeRequired")
	public Object getTemplateAccessCodeRequired() {
		return templateAccessCodeRequired;
	}

	@JsonProperty("templateAccessCodeRequired")
	public void setTemplateAccessCodeRequired(Object templateAccessCodeRequired) {
		this.templateAccessCodeRequired = templateAccessCodeRequired;
	}

	@JsonProperty("deliveryMethod")
	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	@JsonProperty("deliveryMethod")
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	@JsonProperty("recipientId")
	public String getRecipientId() {
		return recipientId;
	}

	@JsonProperty("recipientId")
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	@JsonProperty("clientUserId")
	public String getClientUserId() {
		return clientUserId;
	}

	@JsonProperty("clientUserId")
	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
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