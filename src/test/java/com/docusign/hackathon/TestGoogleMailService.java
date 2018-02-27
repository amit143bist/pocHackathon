package com.docusign.hackathon;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;

import com.docusign.hackathon.service.GoogleMailService;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

public class TestGoogleMailService {

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/**
	 * Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/gmail-java-quickstart
	 */
	private static final List<String> SCOPES = Arrays.asList(GmailScopes.GMAIL_COMPOSE);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {

		// Build flow and trigger user authorization request.
		InputStream in = GoogleAuthQuickstartApplication.class.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets;
		try {
			clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
			DataStore<StoredCredential> dataStore = getStoredCredentialDataStore();

			GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
					clientSecrets, SCOPES).setCredentialDataStore(dataStore).setAccessType("offline").build();

			Credential credential = flow.loadCredential("docusign.sso@gmail.com");

			Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
					.setApplicationName("Hackathon2018").build();

			GoogleMailService googleMailService = new GoogleMailService();
			googleMailService.Send(service, "docusign.sso+partner1@gmail.com", "", "docusign.sso@gmail.com",
					"Test API from GMAIL Service", "Test API Notification Body from GMAIL Service");
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static DataStore<StoredCredential> getStoredCredentialDataStore() throws IOException {
		File mailimporter = new File("C:\\Softwares\\gmail", ".mailimporter");
		FileDataStoreFactory dataStoreFactory = new FileDataStoreFactory(mailimporter);
		return dataStoreFactory.getDataStore("credentials");
	}
}