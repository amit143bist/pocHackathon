package com.docusign.hackathon;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.docusign.hackathon.service.AuthorizationCodeApp;
import com.docusign.hackathon.service.ServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.GmailScopes;

public class GoogleAuthQuickstartApplication {

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

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @return an authorized Credential object.
	 * @throws IOException
	 */
	public static void authorizeGmail() throws IOException {
		// Load client secrets.
		InputStream in = GoogleAuthQuickstartApplication.class.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES).setAccessType("offline").build();

		ServerReceiver localServerReceiver = new ServerReceiver.Builder().setHost("localhost").setPort(8080)
				.setLandingPages("/successcallback", "/failcallback").setCallbackPath("/successcallback").build();

		new AuthorizationCodeApp(flow, localServerReceiver).authorize("user");
	}

	public static void main(String[] args) throws IOException {
		// Build a new authorized API client service.
		authorizeGmail();

	}
}