package com.docusign.hackathon.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.docusign.hackathon.model.CompositeTemplate;
import com.docusign.hackathon.model.CompositeTemplateRequest;
import com.docusign.hackathon.model.CustomFields;
import com.docusign.hackathon.model.Document;
import com.docusign.hackathon.model.EnvelopeResponse;
import com.docusign.hackathon.model.EstimateRequest;
import com.docusign.hackathon.model.FullNameTab;
import com.docusign.hackathon.model.InlineTemplate;
import com.docusign.hackathon.model.RecipientInfo;
import com.docusign.hackathon.model.Recipients;
import com.docusign.hackathon.model.ServerTemplate;
import com.docusign.hackathon.model.Signer;
import com.docusign.hackathon.model.Tabs;
import com.docusign.hackathon.model.TextCustomField;
import com.docusign.hackathon.model.UsecaseName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class POCService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	private static final Logger logger = LogManager.getLogger(POCService.class);

	public String createPOCService(List<EstimateRequest> estimateRequestList, String emailBlurb, String emailSubject,
			Map<String, String> authHeaderMap) {

		List<CompositeTemplate> compositeTemplateList = new ArrayList<CompositeTemplate>();
		if (null != estimateRequestList && !estimateRequestList.isEmpty()) {
			for (EstimateRequest estimateRequest : estimateRequestList) {

				Recipients recipients = createRecipient(estimateRequest);

				InlineTemplate inlineTemplate = new InlineTemplate();
				inlineTemplate.setRecipients(recipients);
				inlineTemplate.setSequence(estimateRequest.getInlineTemplateSequenceNumber());

				CustomFields customFields = createCustomFields(estimateRequest);
				inlineTemplate.setCustomFields(customFields);

				List<InlineTemplate> inlineTemplateList = new ArrayList<InlineTemplate>();
				inlineTemplateList.add(inlineTemplate);

				List<ServerTemplate> serverTemplateList = null;
				if (!StringUtils.isEmpty(estimateRequest.getTemplateId())) {

					ServerTemplate serverTemplate = new ServerTemplate();
					serverTemplate.setTemplateId(estimateRequest.getTemplateId());
					serverTemplate.setSequence(estimateRequest.getServerTemplateSequenceNumber());

					serverTemplateList = new ArrayList<ServerTemplate>();
					serverTemplateList.add(serverTemplate);
				}

				CompositeTemplate compositeTemplate = new CompositeTemplate();

				if (null != serverTemplateList && !serverTemplateList.isEmpty()) {
					compositeTemplate.setServerTemplates(serverTemplateList);
				}

				List<MultipartFile> multiPartFiles = estimateRequest.getMultiPartFileList();
				if (null != multiPartFiles && !multiPartFiles.isEmpty()) {

					for (MultipartFile multipartFile : multiPartFiles) {

						int i = 1;
						try {

							Document document = new Document();

							if (Base64.isBase64(multipartFile.getBytes())) {

								byte[] decodedBytes = Base64.decodeBase64(multipartFile.getBytes());
								document.setDocumentBase64(Base64.encodeBase64String(decodedBytes));
							} else {
								document.setDocumentBase64(Base64.encodeBase64String(multipartFile.getBytes()));
							}
							document.setDocumentId(String.valueOf(i));
							document.setName(multipartFile.getOriginalFilename());

							compositeTemplate.setDocument(document);

							i++;
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

				compositeTemplate.setInlineTemplates(inlineTemplateList);

				compositeTemplateList.add(compositeTemplate);
			}
		}

		CompositeTemplateRequest request = new CompositeTemplateRequest();
		request.setCompositeTemplates(compositeTemplateList);

		request.setStatus("sent");
		request.setEmailBlurb(emailBlurb);
		request.setEmailSubject(emailSubject);

		HttpHeaders httpHeaders = getHttpHeaders(authHeaderMap);

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		String envelopeId = null;
		try {

			String msgBody = objectMapper.writeValueAsString(request);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			logger.info("POCService.createPOCService() " + requestEntity);

			ResponseEntity<EnvelopeResponse> envelopeResponseEntity = restTemplate.exchange(
					"https://demo.docusign.net/restapi/v2/accounts/4465715/envelopes", HttpMethod.POST, requestEntity,
					EnvelopeResponse.class);

			EnvelopeResponse envelopeResponse = envelopeResponseEntity.getBody();
			logger.info("POCService.createEnvelope() " + envelopeResponse.getEnvelopeId());

			envelopeId = envelopeResponse.getEnvelopeId();

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.error(exp.getResponseBodyAsString());
				logger.error(exp.getMostSpecificCause());
			}
		}

		return envelopeId;
	}

	private HttpHeaders getHttpHeaders(Map<String, String> authHeaderMap) {

		HttpHeaders httpHeaders = new HttpHeaders();

		for (Entry<String, String> mapEntry : authHeaderMap.entrySet()) {

			httpHeaders.add(mapEntry.getKey(), mapEntry.getValue());
		}

		httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return httpHeaders;
	}

	private CustomFields createCustomFields(EstimateRequest estimateRequest) {

		CustomFields customFields = new CustomFields();

		TextCustomField textCustomField = new TextCustomField();
		textCustomField.setName("requestorEmail");
		textCustomField.setValue(estimateRequest.getRequestorEmail());
		textCustomField.setRequired("false");
		textCustomField.setShow("false");

		List<TextCustomField> textCustomFieldList = new ArrayList<TextCustomField>();
		textCustomFieldList.add(textCustomField);

		customFields.setTextCustomFields(textCustomFieldList);

		return customFields;
	}

	/**
	 * @param postMessage
	 * @param submitterName
	 * @return
	 */
	private Recipients createRecipient(EstimateRequest estimateRequest) {

		List<Signer> signerList = new ArrayList<Signer>();
		// List<CertifiedDelivery> needsToViewList = new
		// ArrayList<CertifiedDelivery>();
		for (int i = 0; i < estimateRequest.getRecipientInfoList().size(); i++) {

			RecipientInfo recipientInfo = estimateRequest.getRecipientInfoList().get(i);

			/*
			 * if
			 * (UsecaseName.ESTIMATES.getFlowName().equalsIgnoreCase(usecaseName
			 * )) { CertifiedDelivery certifiedDelivery = new
			 * CertifiedDelivery();
			 * certifiedDelivery.setRecipientId(String.valueOf(i + 1));
			 * certifiedDelivery.setName(recipientInfo.getName());
			 * certifiedDelivery.setEmail(recipientInfo.getEmail());
			 * 
			 * if
			 * (!StringUtils.isEmpty(recipientInfo.getEmbeddedRecipientStartURL(
			 * ))) {
			 * 
			 * certifiedDelivery.setClientUserId(String.valueOf(i + 1));
			 * certifiedDelivery.setEmbeddedRecipientStartURL(recipientInfo.
			 * getEmbeddedRecipientStartURL()); }
			 * 
			 * needsToViewList.add(certifiedDelivery); }
			 */

			Signer signer = new Signer();
			signer.setRecipientId(String.valueOf(i + 1));
			signer.setName(recipientInfo.getName());
			signer.setEmail(recipientInfo.getEmail());

			if (!StringUtils.isEmpty(recipientInfo.getEmbeddedRecipientStartURL())) {

				signer.setClientUserId(String.valueOf(i + 1));
				signer.setEmbeddedRecipientStartURL(recipientInfo.getEmbeddedRecipientStartURL());
			}

			Tabs signerTabs = new Tabs();
			if (UsecaseName.ESTIMATES.getFlowName().equalsIgnoreCase(estimateRequest.getUseCaseName())) {

				FullNameTab fullNameTab = new FullNameTab();
				fullNameTab.setFontColor("white");
				fullNameTab.setXPosition(400);
				fullNameTab.setYPosition(15);
				fullNameTab.setDocumentId("1");
				fullNameTab.setPageNumber(1);

				List<FullNameTab> fullNameTabList = new ArrayList<FullNameTab>();
				fullNameTabList.add(fullNameTab);

				signerTabs.setFullNameTabs(fullNameTabList);
			}
			signer.setTabs(signerTabs);

			signerList.add(signer);

		}

		Recipients recipients = new Recipients();
		recipients.setSigners(signerList);
		// recipients.setCertifiedDeliveries(needsToViewList);

		return recipients;
	}
}