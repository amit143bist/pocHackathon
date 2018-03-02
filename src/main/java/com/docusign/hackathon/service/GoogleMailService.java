package com.docusign.hackathon.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

import com.docusign.hackathon.model.GoogleAccessToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Base64;
import com.google.api.services.gmail.model.Message;

@Service
public class GoogleMailService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	HttpTransport HTTP_TRANSPORT;

	@Autowired
	JsonFactory JSON_FACTORY;

	@Value("${heroku.gmail.oauth.clientid}")
	private String herokuGmailClientId;
	
	@Value("${heroku.gmail.oauth.clientsecret}")
	private String herokuGmailClientSecret;

	private static final Logger logger = LogManager.getLogger(GoogleMailService.class);

	private MimeMessage createEmail(String to, String cc, String from, String subject, String bodyText)
			throws MessagingException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		MimeMessage email = new MimeMessage(session);
		InternetAddress tAddress = new InternetAddress(to);
		InternetAddress cAddress = cc.isEmpty() ? null : new InternetAddress(cc);
		InternetAddress fAddress = new InternetAddress(from);

		email.setFrom(fAddress);
		if (cAddress != null) {
			email.addRecipient(javax.mail.Message.RecipientType.CC, cAddress);
		}
		email.addRecipient(javax.mail.Message.RecipientType.TO, tAddress);
		email.setSubject(subject);
		email.setText(bodyText);
		return email;
	}

	private Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		email.writeTo(baos);
		String encodedEmail = Base64.encodeBase64URLSafeString(baos.toByteArray());

		logger.debug("GoogleMailService.createMessageWithEmail()" + encodedEmail);
		Message message = new Message();
		message.setRaw(encodedEmail);
		return message;
	}

	public void Send(String recipientEmail, String ccEmail, String fromEmail, String title, String message,
			String tokenType, String accessToken) throws IOException, MessagingException {
		Message m = createMessageWithEmail(createEmail(recipientEmail, ccEmail, fromEmail, title, message));

		HttpHeaders httpHeaders = getHttpHeaders(tokenType, accessToken);

		String msgBody = objectMapper.writeValueAsString(m);
		HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

		logger.debug("requestEntity- " + requestEntity);
		ResponseEntity<String> googleResponseEntity = restTemplate.exchange(
				"https://www.googleapis.com/gmail/v1/users/me/messages/send", HttpMethod.POST, requestEntity,
				String.class);

		logger.debug("GoogleMailService.Send()" + googleResponseEntity.getBody());
	}

	public boolean validateAccessToken(String accessToken) {

		boolean accessTokenValid = true;

		try {

			ResponseEntity<String> envelopeResponseEntity = restTemplate.getForEntity(
					"https://www.googleapis.com/oauth2/v3/tokeninfo?access_token=" + accessToken, String.class);

			logger.debug("Body envelopeResponseEntity" + envelopeResponseEntity.getBody());
		} catch (Exception e) {

			accessTokenValid = false;
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.error(exp.getResponseBodyAsString());
				logger.error(exp.getMostSpecificCause());
			}
		}

		return accessTokenValid;
	}

	public String refreshGoogleToken(String refreshToken) {

		String accessToken = null;
		try {

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			String msgBody = "client_secret=" + herokuGmailClientSecret + "&grant_type=refresh_token&refresh_token=" + refreshToken
					+ "&client_id=" + herokuGmailClientId;
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			ResponseEntity<GoogleAccessToken> googleResponseEntity = restTemplate.exchange(
					"https://www.googleapis.com/oauth2/v4/token", HttpMethod.POST, requestEntity,
					GoogleAccessToken.class);

			accessToken = googleResponseEntity.getBody().getAccessToken();

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.error(exp.getResponseBodyAsString());
				logger.error(exp.getMostSpecificCause());
			}
		}

		return accessToken;
	}

	private HttpHeaders getHttpHeaders(String accessTokenType, String accessToken) {

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.add("Authorization", accessTokenType + " " + accessToken);
		httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		return httpHeaders;
	}
}