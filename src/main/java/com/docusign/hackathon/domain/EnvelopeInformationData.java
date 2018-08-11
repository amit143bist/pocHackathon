package com.docusign.hackathon.domain;

import java.util.List;

public class EnvelopeInformationData {

	private String envelopeDataAvailable;

	List<RecipientEnvelopeData> recipientEnvelopeDataList;
	
	public String getEnvelopeDataAvailable() {
		return envelopeDataAvailable;
	}

	public void setEnvelopeDataAvailable(String envelopeDataAvailable) {
		this.envelopeDataAvailable = envelopeDataAvailable;
	}

	public List<RecipientEnvelopeData> getRecipientEnvelopeDataList() {
		return recipientEnvelopeDataList;
	}

	public void setRecipientEnvelopeDataList(List<RecipientEnvelopeData> recipientEnvelopeDataList) {
		this.recipientEnvelopeDataList = recipientEnvelopeDataList;
	}
}