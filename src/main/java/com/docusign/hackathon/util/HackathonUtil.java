package com.docusign.hackathon.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

@Service
public class HackathonUtil {

	@Autowired
	HttpTransport HTTP_TRANSPORT;

	@Autowired
	JsonFactory JSON_FACTORY;

	@Value("${heroku.gmail.oauth.clientid}")
	private String herokuGmailClientId;

	@Value("${heroku.gmail.oauth.clientsecret}")
	private String herokuGmailClientSecret;

	@Value("${heroku.gmail.sender.username}")
	private String gmailSenderUsername;

	@Value("${heroku.gmail.application.name}")
	private String gmailApplicationName;

	private static final Logger logger = LogManager.getLogger(HackathonUtil.class);

	private static final List<String> SCOPES = Arrays.asList(GmailScopes.GMAIL_COMPOSE);

	public GoogleAuthorizationCodeFlow getGoogleAuthFlow() {

		logger.debug("herokuGmailClientId in getGoogleAuthFlow()- " + herokuGmailClientId);

		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				herokuGmailClientId, herokuGmailClientSecret, SCOPES).setAccessType("offline").build();

		return flow;
	}

	public Gmail createGmailService() throws IOException {

		GoogleAuthorizationCodeFlow flow = getGoogleAuthFlow();
		Credential credential = flow.loadCredential(gmailSenderUsername);

		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(gmailApplicationName).build();

		return service;
	}

	public String createRedirectUri(HttpServletRequest request, String callbackUri) {
		logger.debug("ServerName- " + request.getServerName() + " Port- " + request.getServerPort() + " Path- "
				+ request.getServletPath() + " isSecure " + request.isSecure() + " ContextPath "
				+ request.getContextPath() + " ServletPath " + request.getServletPath() + " RequestUrl "
				+ request.getRequestURL());

		StringBuilder redirectUriBuilder = new StringBuilder();

		if (request.isSecure()) {
			redirectUriBuilder.append("https://");
		} else {
			redirectUriBuilder.append("http://");
		}

		redirectUriBuilder.append(request.getServerName());
		if (request.getServerPort() > 0) {
			redirectUriBuilder.append(":" + request.getServerPort());
		}

		redirectUriBuilder.append(callbackUri);

		String redirectUri = redirectUriBuilder.toString();

		logger.info("RedirectUri in HackathonUtil.createRedirectUri()" + redirectUri);

		return redirectUri;
	}

	public String convertXMLGregStrToDate(Date date) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(date);

		return dateStr;
	}

	public String convertXMLGregStrToTimestamp(Date date) {

		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String dateStr = df.format(date);

		return dateStr;
	}

	/**
	 * @param plainCreds
	 * @return string
	 */
	public String getEncodedBase64Data(String plainCreds) {

		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
		return new String(base64CredsBytes);
	}

	public String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public String getFileExtension(String fileName) {
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}
}