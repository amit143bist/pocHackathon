package com.docusign.hackathon.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.docusign.hackathon.GoogleAuthQuickstartApplication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

@Service
public class HackathonUtil {

	@Autowired
	HttpTransport HTTP_TRANSPORT;

	@Autowired
	JsonFactory JSON_FACTORY;

	@Value("${heroku.poc.credential.file.path}")
	private String herokuPOCCredentialFilePath;

	@Value("${heroku.client.secret.json.path}")
	private String herokuClientSecretPath;

	@Value("${heroku.gmail.sender.username}")
	private String gmailSenderUsername;

	@Value("${heroku.gmail.application.name}")
	private String gmailApplicationName;

	private static final List<String> SCOPES = Arrays.asList(GmailScopes.GMAIL_COMPOSE);

	public GoogleAuthorizationCodeFlow getGoogleAuthFlow() {

		GoogleAuthorizationCodeFlow flow = null;
		// Build flow and trigger user authorization request.
		InputStream in = GoogleAuthQuickstartApplication.class.getResourceAsStream(herokuClientSecretPath);
		GoogleClientSecrets clientSecrets;
		try {

			clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
			DataStore<StoredCredential> dataStore = getStoredCredentialDataStore();

			flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
					.setCredentialDataStore(dataStore).setAccessType("offline").build();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return flow;
	}

	public Gmail createGmailService() throws IOException {

		GoogleAuthorizationCodeFlow flow = getGoogleAuthFlow();
		Credential credential = flow.loadCredential(gmailSenderUsername);

		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(gmailApplicationName).build();

		return service;
	}

	private DataStore<StoredCredential> getStoredCredentialDataStore() throws IOException {
		File mailimporter = new File(herokuPOCCredentialFilePath, ".mailimporter");
		FileDataStoreFactory dataStoreFactory = new FileDataStoreFactory(mailimporter);
		return dataStoreFactory.getDataStore("credentials");
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
}