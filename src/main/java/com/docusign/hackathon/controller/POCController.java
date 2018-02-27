package com.docusign.hackathon.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.docusign.hackathon.connect.model.DocuSignEnvelopeInformation;
import com.docusign.hackathon.connect.model.RecipientStatus;
import com.docusign.hackathon.connect.model.RecipientStatusCode;
import com.docusign.hackathon.model.EstimateInfo;
import com.docusign.hackathon.model.EstimateRequest;
import com.docusign.hackathon.model.EstimateResponse;
import com.docusign.hackathon.service.GoogleMailService;
import com.docusign.hackathon.service.POCService;
import com.docusign.hackathon.transformer.EstimateRequestTransformer;
import com.docusign.hackathon.util.HackathonUtil;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.services.gmail.Gmail;

@Controller
public class POCController {

	@Autowired
	POCService pocService;

	@Autowired
	EstimateRequestTransformer estimateRequestTransformer;

	@Autowired
	HackathonUtil hackathonUtil;

	@Autowired
	GoogleMailService googleMailService;

	@Value("${heroku.poc.oauth.redirecturi}")
	private String herokuOAuthRedirectUri;

	@Value("${heroku.gmail.sender.username}")
	private String gmailSenderUsername;

	@Value("${heroku.gmail.notification.email.title}")
	private String gmailNotificationEmailTitle;

	@Value("${heroku.gmail.notification.email.body}")
	private String gmailNotificationEmailBody;

	@RequestMapping(value = "/estimates", method = RequestMethod.GET)
	public String estimates(ModelMap model) {

		System.out.println("POCController.estimates()");

		return "estimates";
	}

	@RequestMapping(value = "/gmailauth", method = RequestMethod.GET)
	public String gmailauth(ModelMap model) {

		System.out.println("POCController.gmailauth()");

		GoogleAuthorizationCodeFlow flow = hackathonUtil.getGoogleAuthFlow();

		AuthorizationCodeRequestUrl authorizationUrl = flow.newAuthorizationUrl()
				.setRedirectUri(herokuOAuthRedirectUri);

		String googleOAuthUrl = authorizationUrl.build();
		model.put("googleOAuthUrl", googleOAuthUrl);

		return "gmailauth";
	}

	@RequestMapping(value = "/successcallback", method = RequestMethod.GET)
	public String successcallback(ModelMap model) {

		System.out.println("POCController.successcallback()");

		return "successcallback";
	}

	@RequestMapping(value = "/failcallback", method = RequestMethod.GET)
	public String failcallback(ModelMap model) {

		System.out.println("POCController.failcallback()");

		return "failcallback";
	}

	@RequestMapping(value = "/fetchGoogleToken", method = RequestMethod.GET)
	public String fetchGoogleToken(@RequestParam("authCode") String authCode, HttpServletRequest request,
			ModelMap model) {

		System.out.println("POCController.fetchGoogleToken()");

		String accessToken = null;

		try {

			GoogleAuthorizationCodeFlow flow = hackathonUtil.getGoogleAuthFlow();

			TokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(herokuOAuthRedirectUri).execute();

			System.out.println("TokenType- " + response.getTokenType() + " AccessToken- " + response.getAccessToken()
					+ " RefreshToken- " + response.getRefreshToken());
			accessToken = response.getAccessToken();

			flow.createAndStoreCredential(response, gmailSenderUsername);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return accessToken;
	}

	@RequestMapping(value = "/createEstimates", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@ResponseBody
	public EstimateResponse createEstimates(HttpServletRequest request,
			@RequestPart("estimateInfo") EstimateInfo estimateInfo, @RequestPart("file") MultipartFile... files) {

		Map<String, String> authHeaderMap = new HashMap<String, String>();

		String authHeader = request.getHeader("X-DocuSign-Authentication");

		if (!StringUtils.isEmpty(authHeader)) {
			authHeaderMap.put("X-DocuSign-Authentication", authHeader);
		} else {
			authHeaderMap.put("Authorization", request.getHeader("Authorization"));
		}

		System.out.println("POCController.createEstimates() " + files + " RecipientInfoList size "
				+ estimateInfo.getRecipientInfoList().size() + " estimateInfo- " + estimateInfo + " authHeaderMap- "
				+ authHeaderMap);

		List<EstimateRequest> estimateRequestList = estimateRequestTransformer.transformToEstimateRequest(estimateInfo,
				files);

		String envelopeId = pocService.createPOCService(estimateRequestList, estimateInfo.getEmailBlurb(),
				estimateInfo.getEmailSubject(), authHeaderMap);

		System.out.println("envelopeId in POCController.createEstimates()- " + envelopeId);

		EstimateResponse estimateResponse = new EstimateResponse();
		estimateResponse.setEnvelopeId(envelopeId);

		return estimateResponse;
	}

	@RequestMapping(value = "/notifySender", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> notifySender(HttpServletRequest request,
			@RequestBody DocuSignEnvelopeInformation docuSignEnvelopeInformation) {

		if (null != docuSignEnvelopeInformation && null != docuSignEnvelopeInformation.getEnvelopeStatus()) {

			String envelopeId = docuSignEnvelopeInformation.getEnvelopeStatus().getEnvelopeID();
			System.out.println("EnvelopeId in POCController.notifySender()- " + envelopeId);

			String senderEmail = docuSignEnvelopeInformation.getEnvelopeStatus().getEmail();

			List<RecipientStatus> recipientStatusList = docuSignEnvelopeInformation.getEnvelopeStatus()
					.getRecipientStatuses().getRecipientStatus();

			for (RecipientStatus recipient : recipientStatusList) {

				if (RecipientStatusCode.DELIVERED == recipient.getStatus()) {

					String recipientName = recipient.getUserName();
					String recipientEmail = recipient.getEmail();
					XMLGregorianCalendar viewedTimeCalendar = recipient.getDelivered();

					Date viewedDateTime = viewedTimeCalendar.toGregorianCalendar().getTime();

					String viewedDate = hackathonUtil.convertXMLGregStrToDate(viewedDateTime);
					String viewedTime = hackathonUtil.convertXMLGregStrToTimestamp(viewedDateTime);

					try {
						Gmail service = hackathonUtil.createGmailService();

						String emailSubject = MessageFormat.format(gmailNotificationEmailTitle, recipientName,
								envelopeId);

						String emailBody = MessageFormat.format(gmailNotificationEmailBody, recipientName,
								recipientEmail, envelopeId, viewedDate, viewedTime);
						googleMailService.Send(service, senderEmail, "", gmailSenderUsername, emailSubject, emailBody);

					} catch (IOException e) {
						e.printStackTrace();
					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}