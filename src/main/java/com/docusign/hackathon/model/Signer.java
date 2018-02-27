package com.docusign.hackathon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tabs", "creationReason", "isBulkRecipient", "name", "email", "recipientId", "recipientIdGuid",
		"accessCode", "requireIdLookup", "userId", "clientUserId", "routingOrder", "note", "roleName", "status",
		"deliveryMethod", "totalTabCount", "embeddedRecipientStartURL" })
public class Signer {

	@JsonProperty("tabs")
	private Tabs tabs;
	@JsonProperty("creationReason")
	private String creationReason;
	@JsonProperty("isBulkRecipient")
	private String isBulkRecipient;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("recipientIdGuid")
	private String recipientIdGuid;
	@JsonProperty("accessCode")
	private String accessCode;
	@JsonProperty("requireIdLookup")
	private String requireIdLookup;
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("clientUserId")
	private String clientUserId;
	@JsonProperty("routingOrder")
	private String routingOrder;
	@JsonProperty("note")
	private String note;
	@JsonProperty("roleName")
	private String roleName;
	@JsonProperty("status")
	private String status;
	@JsonProperty("deliveryMethod")
	private String deliveryMethod;
	@JsonProperty("totalTabCount")
	private String totalTabCount;
	@JsonProperty("embeddedRecipientStartURL")
	private String embeddedRecipientStartURL;

	@JsonProperty("tabs")
	public Tabs getTabs() {
		return tabs;
	}

	@JsonProperty("tabs")
	public void setTabs(Tabs tabs) {
		this.tabs = tabs;
	}

	@JsonProperty("creationReason")
	public String getCreationReason() {
		return creationReason;
	}

	@JsonProperty("creationReason")
	public void setCreationReason(String creationReason) {
		this.creationReason = creationReason;
	}

	@JsonProperty("isBulkRecipient")
	public String getIsBulkRecipient() {
		return isBulkRecipient;
	}

	@JsonProperty("isBulkRecipient")
	public void setIsBulkRecipient(String isBulkRecipient) {
		this.isBulkRecipient = isBulkRecipient;
	}

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

	@JsonProperty("recipientId")
	public String getRecipientId() {
		return recipientId;
	}

	@JsonProperty("recipientId")
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	@JsonProperty("recipientIdGuid")
	public String getRecipientIdGuid() {
		return recipientIdGuid;
	}

	@JsonProperty("recipientIdGuid")
	public void setRecipientIdGuid(String recipientIdGuid) {
		this.recipientIdGuid = recipientIdGuid;
	}

	@JsonProperty("accessCode")
	public String getAccessCode() {
		return accessCode;
	}

	@JsonProperty("accessCode")
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@JsonProperty("requireIdLookup")
	public String getRequireIdLookup() {
		return requireIdLookup;
	}

	@JsonProperty("requireIdLookup")
	public void setRequireIdLookup(String requireIdLookup) {
		this.requireIdLookup = requireIdLookup;
	}

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("clientUserId")
	public String getClientUserId() {
		return clientUserId;
	}

	@JsonProperty("clientUserId")
	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
	}

	@JsonProperty("routingOrder")
	public String getRoutingOrder() {
		return routingOrder;
	}

	@JsonProperty("routingOrder")
	public void setRoutingOrder(String routingOrder) {
		this.routingOrder = routingOrder;
	}

	@JsonProperty("note")
	public String getNote() {
		return note;
	}

	@JsonProperty("note")
	public void setNote(String note) {
		this.note = note;
	}

	@JsonProperty("roleName")
	public String getRoleName() {
		return roleName;
	}

	@JsonProperty("roleName")
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("deliveryMethod")
	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	@JsonProperty("deliveryMethod")
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	@JsonProperty("totalTabCount")
	public String getTotalTabCount() {
		return totalTabCount;
	}

	@JsonProperty("totalTabCount")
	public void setTotalTabCount(String totalTabCount) {
		this.totalTabCount = totalTabCount;
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