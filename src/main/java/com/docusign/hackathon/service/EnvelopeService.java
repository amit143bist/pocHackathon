package com.docusign.hackathon.service;

import java.util.ArrayList;
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

import com.docusign.hackathon.model.CompositeTemplate;
import com.docusign.hackathon.model.CompositeTemplateRequest;
import com.docusign.hackathon.model.EmbeddedUrlResponse;
import com.docusign.hackathon.model.EnvelopeResponse;
import com.docusign.hackathon.model.InlineTemplate;
import com.docusign.hackathon.model.RecipientTokenRequest;
import com.docusign.hackathon.model.Recipients;
import com.docusign.hackathon.model.ServerTemplate;
import com.docusign.hackathon.model.Signer;
import com.docusign.hackathon.model.Tabs;
import com.docusign.hackathon.model.TextTab;
import com.docusign.hackathon.model.TwitterEnvelope;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class EnvelopeService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Value("${heroku.server.url}")
	private String herokuServerUrl;
	
	private static final Logger logger = LogManager.getLogger(EnvelopeService.class);

	public String createEnvelope(TwitterEnvelope twitterEnvelope) {

		logger.debug("EnvelopeService.createEnvelope()");
		Recipients recipients = createRecipient(twitterEnvelope.getPostMessage(), twitterEnvelope.getSubmitterName(),
				twitterEnvelope.getAccessCode(), twitterEnvelope.getApproverName(), twitterEnvelope.getApproverEmail());

		InlineTemplate inlineTemplate = new InlineTemplate();
		inlineTemplate.setRecipients(recipients);
		inlineTemplate.setSequence("2");

		ServerTemplate serverTemplate = new ServerTemplate();
		serverTemplate.setTemplateId("0be9ba40-e43a-487e-8cb2-30efd2a67bc1");
		serverTemplate.setSequence("1");

		List<ServerTemplate> serverTemplateList = new ArrayList<ServerTemplate>();
		serverTemplateList.add(serverTemplate);

		List<InlineTemplate> inlineTemplateList = new ArrayList<InlineTemplate>();
		inlineTemplateList.add(inlineTemplate);

		CompositeTemplate compositeTemplate = new CompositeTemplate();
		compositeTemplate.setServerTemplates(serverTemplateList);
		compositeTemplate.setInlineTemplates(inlineTemplateList);

		CompositeTemplateRequest request = new CompositeTemplateRequest();
		List<CompositeTemplate> compositeTemplateList = new ArrayList<CompositeTemplate>();
		compositeTemplateList.add(compositeTemplate);

		request.setCompositeTemplates(compositeTemplateList);
		request.setStatus("sent");

		HttpHeaders httpHeaders = getHttpHeaders();

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		String envelopeId = null;
		try {

			String msgBody = objectMapper.writeValueAsString(request);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			logger.debug("EnvelopeService.createEnvelope() " + requestEntity);

			ResponseEntity<EnvelopeResponse> envelopeResponseEntity = restTemplate.exchange(
					"https://demo.docusign.net/restapi/v2/accounts/1764240/envelopes", HttpMethod.POST, requestEntity,
					EnvelopeResponse.class);

			EnvelopeResponse envelopeResponse = envelopeResponseEntity.getBody();
			logger.info("EnvelopeService.createEnvelope() " + envelopeResponse.getEnvelopeId());

			envelopeId = envelopeResponse.getEnvelopeId();

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.debug(exp.getResponseBodyAsString());
				logger.debug(exp.getMostSpecificCause());
			}
		}

		return envelopeId;
	}

	public String recipientUrl(String envelopeId, String clientUserId, String email, String userName) {

		String recipientUrl = null;
		HttpHeaders httpHeaders = getHttpHeaders();

		RecipientTokenRequest recipientTokenRequest = new RecipientTokenRequest();
		recipientTokenRequest.setAuthenticationMethod("Password");
		recipientTokenRequest.setClientUserId(clientUserId);
		recipientTokenRequest.setEmail(email);
		recipientTokenRequest.setUserName(userName);
		recipientTokenRequest.setReturnUrl("https://polar-earth-93130.herokuapp.com/images/complete.png");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		try {

			String msgBody = objectMapper.writeValueAsString(recipientTokenRequest);
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			logger.debug("EnvelopeService.recipientUrl() " + requestEntity);

			ResponseEntity<EmbeddedUrlResponse> recipientUrlEntity = restTemplate
					.exchange("https://demo.docusign.net/restapi/v2/accounts/1764240/envelopes/" + envelopeId
							+ "/views/recipient", HttpMethod.POST, requestEntity, EmbeddedUrlResponse.class);

			logger.debug("EnvelopeService.createEnvelope() " + recipientUrlEntity);

			EmbeddedUrlResponse response = recipientUrlEntity.getBody();
			recipientUrl = response.getUrl();

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.debug(exp.getResponseBodyAsString());
				logger.debug(exp.getMostSpecificCause());
			}
		}

		return recipientUrl;
	}

	public Recipients fetchRecipients(String envelopeId) {

		HttpHeaders httpHeaders = getHttpHeaders();

		HttpEntity<String> requestEntity = new HttpEntity<String>(httpHeaders);

		logger.debug("EnvelopeService.fetchRecipients() " + requestEntity);

		ResponseEntity<Recipients> recipientEntity = restTemplate.exchange(
				"https://demo.docusign.net/restapi/v2/accounts/1764240/envelopes/" + envelopeId + "/recipients",
				HttpMethod.GET, requestEntity, Recipients.class);

		Recipients recipients = recipientEntity.getBody();

		return recipients;
	}

	public void updateRecipient(String envelopeId) {

		HttpHeaders httpHeaders = getHttpHeaders();

		HttpEntity<String> requestEntity = new HttpEntity<String>(httpHeaders);

		ResponseEntity<Recipients> recipientEntity = restTemplate.exchange(
				"https://demo.docusign.net/restapi/v2/accounts/1764240/envelopes/" + envelopeId + "/recipients",
				HttpMethod.GET, requestEntity, Recipients.class);

		Recipients recipients = recipientEntity.getBody();

		List<Signer> signerList = recipients.getSigners();

		for (Signer signer : signerList) {

			signer.setAccessCode("");
		}

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		try {
			String msgBody = objectMapper.writeValueAsString(recipients);
			requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			ResponseEntity<String> updateEntity = restTemplate.exchange(
					"https://demo.docusign.net/restapi/v2/accounts/1764240/envelopes/" + envelopeId + "/recipients",
					HttpMethod.PUT, requestEntity, String.class);

			logger.debug("EnvelopeService.updateRecipient() " + updateEntity);
		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.debug(exp.getResponseBodyAsString());
				logger.debug(exp.getMostSpecificCause());
			}
		}

	}

	private HttpHeaders getHttpHeaders() {

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.add("Authorization", "Bearer pvcqJmlK6Kbucx4TyVm4NT5OcUA=");
		httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return httpHeaders;
	}

	/**
	 * @param postMessage
	 * @param submitterName
	 * @return
	 */
	private Recipients createRecipient(String postMessage, String submitterName, String accessCode, String approverName,
			String approverEmail) {

		Recipients recipients = new Recipients();
		Signer signer = new Signer();
		signer.setAccessCode(accessCode);
		signer.setRecipientId("1");
		signer.setRoleName("Approver");
		signer.setClientUserId("1111");
		signer.setName(approverName);
		signer.setEmail(approverEmail);
		signer.setEmbeddedRecipientStartURL(herokuServerUrl + "/hackathon/portal?envelopeId=[[envelopeId]]");

		TextTab postMessageTab = new TextTab();
		postMessageTab.setTabLabel("postMessage");
		postMessageTab.setValue(postMessage);

		TextTab submitterNameTab = new TextTab();
		submitterNameTab.setTabLabel("submitterName");
		submitterNameTab.setValue(submitterName);

		List<TextTab> textTabList = new ArrayList<TextTab>();
		textTabList.add(submitterNameTab);
		textTabList.add(postMessageTab);

		Tabs signerTabs = new Tabs();
		signerTabs.setTextTabs(textTabList);

		signer.setTabs(signerTabs);

		List<Signer> signerList = new ArrayList<Signer>();
		signerList.add(signer);

		recipients.setSigners(signerList);
		return recipients;
	}

}