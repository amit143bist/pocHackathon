package com.docusign.hackathon.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

import com.docusign.hackathon.db.model.PatientDetails;
import com.docusign.hackathon.model.CompositeTemplate;
import com.docusign.hackathon.model.CompositeTemplateRequest;
import com.docusign.hackathon.model.Document;
import com.docusign.hackathon.model.EmbeddedUrlResponse;
import com.docusign.hackathon.model.EnvelopeResponse;
import com.docusign.hackathon.model.InlineTemplate;
import com.docusign.hackathon.model.RecipientTokenRequest;
import com.docusign.hackathon.model.Recipients;
import com.docusign.hackathon.model.SenderViewRequest;
import com.docusign.hackathon.model.ServerTemplate;
import com.docusign.hackathon.model.Signer;
import com.docusign.hackathon.model.Tabs;
import com.docusign.hackathon.model.TextTab;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class UnitedPOCService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Value("${heroku.server.url}")
	private String herokuServerUrl;

	@Value("${heroku.ds.api.united.accountid}")
	private String herokuDSAccountId;

	@Value("${heroku.ds.api.united.accesstoken}")
	private String herokuDSAccessToken;
	
	@Value("${heroku.ds.united.entresto.pdf}")
	private String entrestoPDF;
	
	@Value("${heroku.ds.united.metaxalone.pdf}")
	private String metaxalonePDF;

	private static final Logger logger = LogManager.getLogger(UnitedPOCService.class);

	public String createRecipientEnvelopes(boolean isEmbeddedTechnician, String medicineName, boolean isSenderView) {

		Document document = new Document();
		document.setDocumentId("1");

		if ("Entresto".equalsIgnoreCase(medicineName)) {

			document.setRemoteUrl(entrestoPDF);
		} else if ("Metaxalone".equalsIgnoreCase(medicineName)) {

			document.setRemoteUrl(metaxalonePDF);
		}

		document.setName("Provider OR Document");
		document.setFileExtension("pdf");

		CompositeTemplate compositeTemplate = new CompositeTemplate();

		compositeTemplate.setCompositeTemplateId("1");
		compositeTemplate.setDocument(document);

		Recipients recipients = createRecipients(isEmbeddedTechnician, medicineName);

		InlineTemplate inlineTemplate = new InlineTemplate();

		inlineTemplate.setRecipients(recipients);
		inlineTemplate.setSequence("1");

		List<InlineTemplate> inlineTemplateList = new ArrayList<InlineTemplate>();
		inlineTemplateList.add(inlineTemplate);

		compositeTemplate.setInlineTemplates(inlineTemplateList);

		ServerTemplate serverTemplate = new ServerTemplate();
		if (isEmbeddedTechnician) {

			serverTemplate.setTemplateId("ebe5dea8-2aaa-4e5f-a64a-79d0921328b8");
		} else {
			serverTemplate.setTemplateId("2830de1d-813b-467f-94e3-164a9c3c4235");
		}
		serverTemplate.setSequence("1");

		List<ServerTemplate> serverTemplateList = new ArrayList<ServerTemplate>();
		serverTemplateList.add(serverTemplate);

		compositeTemplate.setServerTemplates(serverTemplateList);

		List<CompositeTemplate> compositeTemplateList = new ArrayList<CompositeTemplate>();
		compositeTemplateList.add(compositeTemplate);

		CompositeTemplateRequest request = new CompositeTemplateRequest();
		request.setCompositeTemplates(compositeTemplateList);

		if (isSenderView) {

			request.setStatus("created");
		} else {
			request.setStatus("sent");
		}

		request.setEmailSubject("Please fill and sign the required documents");
		request.setEmailBlurb("Please fill and sign the required documents");

		HttpHeaders httpHeaders = getHttpHeaders();

		String envelopeId = null;
		String msgBody = null;
		try {
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

			msgBody = objectMapper.writeValueAsString(request);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			logger.info("requestEntity in UnitedPOCService.createEnvelope()- " + requestEntity);
			ResponseEntity<EnvelopeResponse> envelopeResponseEntity = restTemplate.exchange(
					"https://demo.docusign.net/restapi/v2/accounts/" + herokuDSAccountId + "/envelopes",
					HttpMethod.POST, requestEntity, EnvelopeResponse.class);

			EnvelopeResponse envelopeResponse = envelopeResponseEntity.getBody();
			logger.info("UnitedPOCService.createEnvelope() " + envelopeResponse.getEnvelopeId());

			envelopeId = envelopeResponse.getEnvelopeId();

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (org.springframework.web.client.HttpClientErrorException ex) {

			logger.info(ex.getMessage());
			logger.info(ex.getResponseBodyAsString());
			ex.printStackTrace();
		}
		return envelopeId;
	}

	public String recipientViewUrl(String envelopeId) {

		String embeddedSigningUrl = null;

		HttpHeaders httpHeaders = getHttpHeaders();

		RecipientTokenRequest recipientTokenRequest = new RecipientTokenRequest();
		recipientTokenRequest.setAuthenticationMethod("Password");
		recipientTokenRequest.setClientUserId("12345");
		recipientTokenRequest.setEmail("docusign.sso@gmail.com");
		recipientTokenRequest.setUserName("John Cena");
		recipientTokenRequest.setReturnUrl(herokuServerUrl
				+ "/emeddedUnitedCallback?envelopeId=[[envelopeId]]&recipientEmail=[[recipientEmail]]&recipientName=[[recipientName]]");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		try {

			String msgBody = objectMapper.writeValueAsString(recipientTokenRequest);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			logger.info("UnitedPOCService.recipientUrl() " + requestEntity);

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

	public String senderViewUrl(String envelopeId) {

		String embeddedSigningUrl = null;

		HttpHeaders httpHeaders = getHttpHeaders();

		SenderViewRequest senderViewRequest = new SenderViewRequest();
		senderViewRequest.setReturnUrl(herokuServerUrl
				+ "/emeddedUnitedCallback?envelopeId=[[envelopeId]]&recipientEmail=[[recipientEmail]]&recipientName=[[recipientName]]");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		try {

			String msgBody = objectMapper.writeValueAsString(senderViewRequest);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			logger.info("UnitedPOCService.senderViewUrl() " + requestEntity);

			ResponseEntity<EmbeddedUrlResponse> recipientUrlEntity = restTemplate
					.exchange(
							"https://demo.docusign.net/restapi/v2/accounts/" + herokuDSAccountId + "/envelopes/"
									+ envelopeId + "/views/sender",
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

	private Recipients createRecipients(boolean isEmbeddedTechnician, String medicineName) {

		PatientDetails patientDetails = new PatientDetails();

		Signer signer = new Signer();
		signer.setRecipientId("2");
		signer.setName(patientDetails.getProviderName());
		signer.setEmail(patientDetails.getProviderEmail());
		signer.setRoleName("Provider");

		signer.setTabs(createSignerTabs(patientDetails, medicineName));

		List<Signer> signerList = new ArrayList<Signer>();
		signerList.add(signer);

		if (isEmbeddedTechnician) {

			signer = new Signer();
			signer.setRecipientId("1");
			signer.setName("John Cena");
			signer.setEmail("docusign.sso@gmail.com");
			signer.setRoleName("Technician");
			signer.setClientUserId("12345");
			signerList.add(signer);
		}

		Recipients recipients = new Recipients();
		recipients.setSigners(signerList);

		return recipients;
	}

	private Tabs createSignerTabs(PatientDetails patientDetails, String medicineName) {

		Tabs signerTabs = new Tabs();

		List<TextTab> textTabList = populateExistingData(patientDetails);
		signerTabs.setTextTabs(textTabList);

		return signerTabs;
	}

	private List<TextTab> populateExistingData(PatientDetails patientDetails) {

		List<TextTab> textTabList = new ArrayList<TextTab>();

		TextTab textTab = new TextTab();

		textTab.setTabLabel("MemName");
		textTab.setValue(patientDetails.getMemName());
		textTabList.add(textTab);

		textTab = new TextTab();

		textTab.setTabLabel("MemId");
		textTab.setValue(patientDetails.getMemId());
		textTabList.add(textTab);

		textTab = new TextTab();

		textTab.setTabLabel("MemDOB");
		textTab.setValue(patientDetails.getMemDOB());
		textTabList.add(textTab);

		textTab = new TextTab();

		textTab.setTabLabel("MemHIC");
		textTab.setValue(patientDetails.getMemHIC());
		textTabList.add(textTab);

		textTab = new TextTab();

		textTab.setTabLabel("LetterDate");

		Calendar cal = Calendar.getInstance();
		String pattern = "yyyy-MM-dd";
		DateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		textTab.setValue(simpleDateFormat.format(cal.getTime()));
		textTabList.add(textTab);

		textTab = new TextTab();

		textTab.setTabLabel("MemCaseNo");
		textTab.setValue(patientDetails.getMemCaseNo());
		textTabList.add(textTab);

		textTab = new TextTab();

		textTab.setTabLabel("ProviderName");
		textTab.setValue(patientDetails.getProviderName());
		textTabList.add(textTab);

		textTab = new TextTab();

		textTab.setTabLabel("AppealExpDate");

		cal.add(Calendar.DATE, 1);

		textTab.setValue(simpleDateFormat.format(cal.getTime()));
		textTabList.add(textTab);

		return textTabList;
	}

	private HttpHeaders getHttpHeaders() {

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.add("Authorization", "Bearer " + herokuDSAccessToken);
		httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return httpHeaders;
	}
}