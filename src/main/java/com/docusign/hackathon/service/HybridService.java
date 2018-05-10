package com.docusign.hackathon.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.docusign.hackathon.model.CompositeTemplate;
import com.docusign.hackathon.model.CompositeTemplateRequest;
import com.docusign.hackathon.model.CustomFields;
import com.docusign.hackathon.model.Document;
import com.docusign.hackathon.model.EmbeddedUrlResponse;
import com.docusign.hackathon.model.EnvelopeResponse;
import com.docusign.hackathon.model.InitialHereTab;
import com.docusign.hackathon.model.InlineTemplate;
import com.docusign.hackathon.model.NoteTab;
import com.docusign.hackathon.model.RecipientTokenRequest;
import com.docusign.hackathon.model.Recipients;
import com.docusign.hackathon.model.SignHereTab;
import com.docusign.hackathon.model.Signer;
import com.docusign.hackathon.model.SignerAttachmentTab;
import com.docusign.hackathon.model.Tabs;
import com.docusign.hackathon.model.TextCustomField;
import com.docusign.hackathon.model.WorkspaceRequest;
import com.docusign.hackathon.model.WorkspaceResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class HybridService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Value("${heroku.server.url}")
	private String herokuServerUrl;

	@Value("${heroku.docusign.api.accountid}")
	private String herokuDSAccountId;

	@Value("${heroku.docusign.api.accesstoken}")
	private String herokuDSAccessToken;

	private static final Logger logger = LogManager.getLogger(HybridService.class);

	public String createWorkspace() {

		WorkspaceRequest workspaceRequest = new WorkspaceRequest();
		workspaceRequest.setWorkspaceName("Test Hybrid");
		workspaceRequest.setWorkspaceDescription("Test Hybrid Desc");

		HttpHeaders httpHeaders = getHttpHeaders();

		String msgBody = null;
		String workspaceId = null;
		try {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

			msgBody = objectMapper.writeValueAsString(workspaceRequest);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			ResponseEntity<WorkspaceResponse> envelopeResponseEntity = restTemplate.exchange(
					"https://demo.docusign.net/restapi/v2/accounts/" + herokuDSAccountId + "/workspaces",
					HttpMethod.POST, requestEntity, WorkspaceResponse.class);

			WorkspaceResponse workspaceResponse = envelopeResponseEntity.getBody();
			workspaceId = workspaceResponse.getWorkspaceId();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return workspaceId;
	}

	public String createRecipientEnvelopes(String signerName, String signerEmail, String workspaceId,
			boolean isUploadEnvelope) {

		Document document = new Document();
		document.setDocumentId("1");

		if (isUploadEnvelope) {

			document.setDocumentBase64("UGxlYXNlIHVwbG9hZCB5b3VyIGZpbGUgYmVsb3c=");
			document.setName("Upload Document");
			document.setFileExtension("txt");
		} else {

			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("doc/Policy.pdf").getFile());

			try {
				document.setDocumentBase64(Base64.encodeBase64String(FileUtils.readFileToByteArray(file)));
			} catch (IOException e) {
				e.printStackTrace();
			}

			document.setName("Signature Document");
			document.setFileExtension("pdf");
			document.setTransformPdfFields("true");
		}

		CompositeTemplate compositeTemplate = new CompositeTemplate();

		compositeTemplate.setCompositeTemplateId("1");
		compositeTemplate.setDocument(document);

		InlineTemplate inlineTemplate = new InlineTemplate();

		Recipients recipients = createRecipients(signerName, signerEmail, isUploadEnvelope);

		inlineTemplate.setRecipients(recipients);
		inlineTemplate.setSequence("1");

		CustomFields customFields = createCustomFields(workspaceId);
		inlineTemplate.setCustomFields(customFields);

		List<InlineTemplate> inlineTemplateList = new ArrayList<InlineTemplate>();
		inlineTemplateList.add(inlineTemplate);

		compositeTemplate.setInlineTemplates(inlineTemplateList);

		List<CompositeTemplate> compositeTemplateList = new ArrayList<CompositeTemplate>();
		compositeTemplateList.add(compositeTemplate);

		CompositeTemplateRequest request = new CompositeTemplateRequest();
		request.setCompositeTemplates(compositeTemplateList);

		request.setStatus("sent");

		if (isUploadEnvelope) {

			request.setEmailSubject("Please upload the required documents");
			request.setEmailBlurb("Please upload the required documents");
		} else {

			request.setEmailSubject("Please sign the required documents");
			request.setEmailBlurb("Please sign the required documents");
		}

		HttpHeaders httpHeaders = getHttpHeaders();

		String envelopeId = null;
		String msgBody = null;
		try {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

			msgBody = objectMapper.writeValueAsString(request);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			ResponseEntity<EnvelopeResponse> envelopeResponseEntity = restTemplate.exchange(
					"https://demo.docusign.net/restapi/v2/accounts/" + herokuDSAccountId + "/envelopes",
					HttpMethod.POST, requestEntity, EnvelopeResponse.class);

			EnvelopeResponse envelopeResponse = envelopeResponseEntity.getBody();
			logger.info("HybridService.createEnvelope() " + envelopeResponse.getEnvelopeId());

			envelopeId = envelopeResponse.getEnvelopeId();

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return envelopeId;
	}

	public void changeToEmbeddedRecipient(String envelopeId, String recipientEmail, String clientUserId) {

		HttpHeaders httpHeaders = getHttpHeaders();

		HttpEntity<String> requestEntity = new HttpEntity<String>(httpHeaders);

		ResponseEntity<Recipients> recipientEntity = restTemplate
				.exchange("https://demo.docusign.net/restapi/v2/accounts/" + herokuDSAccountId + "/envelopes/"
						+ envelopeId + "/recipients", HttpMethod.GET, requestEntity, Recipients.class);

		Recipients recipients = recipientEntity.getBody();

		List<Signer> signerList = recipients.getSigners();

		for (Signer signer : signerList) {

			if (recipientEmail.equalsIgnoreCase(signer.getEmail())) {

				signer.setClientUserId(clientUserId);
			}
		}

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		try {
			String msgBody = objectMapper.writeValueAsString(recipients);
			requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			ResponseEntity<String> updateEntity = restTemplate.exchange("https://demo.docusign.net/restapi/v2/accounts/"
					+ herokuDSAccountId + "/envelopes/" + envelopeId + "/recipients", HttpMethod.PUT, requestEntity,
					String.class);

			logger.debug("HybridService.updateRecipient() " + updateEntity);
		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.debug(exp.getResponseBodyAsString());
				logger.debug(exp.getMostSpecificCause());
			}
		}
	}

	public String recipientViewUrl(String envelopeId, String recipientName, String recipientEmail,
			String clientUserId) {

		String embeddedSigningUrl = null;

		HttpHeaders httpHeaders = getHttpHeaders();

		RecipientTokenRequest recipientTokenRequest = new RecipientTokenRequest();
		recipientTokenRequest.setAuthenticationMethod("Password");
		recipientTokenRequest.setClientUserId(clientUserId);
		recipientTokenRequest.setEmail(recipientEmail);
		recipientTokenRequest.setUserName(recipientName);
		recipientTokenRequest.setReturnUrl(herokuServerUrl
				+ "/emeddedCallback?envelopeId=[[envelopeId]]&recipientEmail=[[recipientEmail]]&recipientName=[[recipientName]]");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		try {

			String msgBody = objectMapper.writeValueAsString(recipientTokenRequest);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			logger.debug("HybridService.recipientUrl() " + requestEntity);

			ResponseEntity<EmbeddedUrlResponse> recipientUrlEntity = restTemplate
					.exchange(
							"https://demo.docusign.net/restapi/v2/accounts/" + herokuDSAccountId + "/envelopes/"
									+ envelopeId + "/views/recipient",
							HttpMethod.POST, requestEntity, EmbeddedUrlResponse.class);

			EmbeddedUrlResponse response = recipientUrlEntity.getBody();
			embeddedSigningUrl = response.getUrl();

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.debug(exp.getResponseBodyAsString());
				logger.debug(exp.getMostSpecificCause());
			}
		}

		return embeddedSigningUrl;
	}

	private CustomFields createCustomFields(String workspaceId) {

		CustomFields customFields = new CustomFields();

		TextCustomField textCustomField = new TextCustomField();
		textCustomField.setName("##workspaceId");
		textCustomField.setValue(workspaceId);
		textCustomField.setRequired("false");
		textCustomField.setShow("false");

		List<TextCustomField> textCustomFieldList = new ArrayList<TextCustomField>();
		textCustomFieldList.add(textCustomField);

		customFields.setTextCustomFields(textCustomFieldList);

		return customFields;
	}

	private Recipients createRecipients(String signerName, String signerEmail, boolean isUploadEnvelope) {

		Signer signer = new Signer();
		signer.setRecipientId("1");
		signer.setName(signerName);
		signer.setEmail(signerEmail);
		signer.setRoutingOrder("1");

		Tabs signerTabs = new Tabs();

		if (isUploadEnvelope) {

			signerTabs.setNoteTabs(createNoteTabs());
			signerTabs.setSignerAttachmentTabs(createSignerAttachmentTabs());
		} else {

			signerTabs.setSignHereTabs(createSignHereTabs());
			signerTabs.setInitialHereTabs(createInitialHereTabs());
		}

		signer.setTabs(signerTabs);

		List<Signer> signerList = new ArrayList<Signer>();
		signerList.add(signer);

		Recipients recipients = new Recipients();
		recipients.setSigners(signerList);

		return recipients;
	}

	private List<SignHereTab> createSignHereTabs() {

		SignHereTab signHereTab = new SignHereTab();
		signHereTab.setRecipientId("1");
		signHereTab.setTabLabel("\\*h.DocuSignSignHere\\*");

		List<SignHereTab> signHereTabList = new ArrayList<SignHereTab>();
		signHereTabList.add(signHereTab);

		return signHereTabList;
	}

	private List<InitialHereTab> createInitialHereTabs() {

		InitialHereTab initialHereTab = new InitialHereTab();
		initialHereTab.setRecipientId("1");
		initialHereTab.setTabLabel("\\*h.DocuSignInitialHere\\*");

		List<InitialHereTab> initialHereTabList = new ArrayList<InitialHereTab>();
		initialHereTabList.add(initialHereTab);

		return initialHereTabList;
	}

	private List<SignerAttachmentTab> createSignerAttachmentTabs() {

		SignerAttachmentTab signerAttachmentTab = new SignerAttachmentTab();
		signerAttachmentTab.setTabLabel("SignerAttachmentTab1");
		signerAttachmentTab.setPageNumber(1);
		signerAttachmentTab.setDocumentId("1");
		signerAttachmentTab.setRecipientId("1");
		signerAttachmentTab.setXPosition(30);
		signerAttachmentTab.setYPosition(450);
		signerAttachmentTab.setOptional(false);

		List<SignerAttachmentTab> signerAttachmentTabList = new ArrayList<SignerAttachmentTab>();
		signerAttachmentTabList.add(signerAttachmentTab);

		return signerAttachmentTabList;
	}

	private List<NoteTab> createNoteTabs() {

		NoteTab noteTab = new NoteTab();
		noteTab.setTabLabel("NoteTab1");

		StringBuilder builder = new StringBuilder();
		builder.append("<p>Qualifying documentation for the Home Safety Discount may be satisfied by ");
		builder.append("any ONE of the following types of documentation:\n");
		builder.append("- Proof of Energy Star or EPA certification, or;\n");
		builder.append("- Fortified Home certification, or;\n");
		builder.append("- LEED certification, or;\n");
		builder.append("- Proof of whole house water leak system installation, or;\n");
		builder.append("- Proof of Connected Home: Copy of certificate of installation from ");
		builder.append("pre-approved vendor, and copy of monthly bill for service ");
		builder.append("(depending on date of installation). Please contact your agent for a list of ");
		builder.append("pre-approved vendors. Your agent can also assist with your request to add a ");
		builder.append("new vendor to the list of approved vendors.;\n");
		builder.append("- Proof of automatic gas shut-off valve installation (by licensed contractor)*");
		builder.append("</p>\n");
		builder.append("<p>* Please note: if your home is equipped with an automatic gas shut-off valve, ");
		builder.append("Farmers will attempt to confirm this during an inspection of the premises by ");
		builder.append("a third party vendor. However, if you qualify for the Home Safety Discount ");
		builder.append("because your home is equipped with an automatic gas shut-off valve and you ");
		builder.append("have documentation confirming the installation of an automatic gas shut-off ");
		builder.append("valve, we encourage you to upload this documentation.</p>");

		noteTab.setValue(builder.toString());
		noteTab.setWidth(550);
		noteTab.setHeight(360);
		noteTab.setDocumentId("1");
		noteTab.setPageNumber(1);
		noteTab.setRecipientId("1");
		noteTab.setXPosition(30);
		noteTab.setYPosition(70);

		List<NoteTab> noteTabList = new ArrayList<NoteTab>();
		noteTabList.add(noteTab);

		return noteTabList;
	}

	private HttpHeaders getHttpHeaders() {

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.add("Authorization", "Bearer " + herokuDSAccessToken);
		httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return httpHeaders;
	}
}