package com.docusign.hackathon.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EstimateRequest {

	private String templateId;
	private String useCaseName;
	private String serverTemplateSequenceNumber;
	private String inlineTemplateSequenceNumber;
	private List<MultipartFile> multiPartFileList;
	private List<RecipientInfo> recipientInfoList;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUseCaseName() {
		return useCaseName;
	}

	public void setUseCaseName(String useCaseName) {
		this.useCaseName = useCaseName;
	}

	public String getServerTemplateSequenceNumber() {
		return serverTemplateSequenceNumber;
	}

	public void setServerTemplateSequenceNumber(String serverTemplateSequenceNumber) {
		this.serverTemplateSequenceNumber = serverTemplateSequenceNumber;
	}

	public String getInlineTemplateSequenceNumber() {
		return inlineTemplateSequenceNumber;
	}

	public void setInlineTemplateSequenceNumber(String inlineTemplateSequenceNumber) {
		this.inlineTemplateSequenceNumber = inlineTemplateSequenceNumber;
	}

	public List<MultipartFile> getMultiPartFileList() {
		return multiPartFileList;
	}

	public void setMultiPartFileList(List<MultipartFile> multiPartFileList) {
		this.multiPartFileList = multiPartFileList;
	}

	public List<RecipientInfo> getRecipientInfoList() {
		return recipientInfoList;
	}

	public void setRecipientInfoList(List<RecipientInfo> recipientInfoList) {
		this.recipientInfoList = recipientInfoList;
	}
}