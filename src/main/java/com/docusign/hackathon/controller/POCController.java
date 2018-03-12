package com.docusign.hackathon.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.docusign.hackathon.connect.model.ArrayOfCustomField;
import com.docusign.hackathon.connect.model.CustomField;
import com.docusign.hackathon.connect.model.DocuSignEnvelopeInformation;
import com.docusign.hackathon.connect.model.RecipientStatus;
import com.docusign.hackathon.connect.model.RecipientStatusCode;
import com.docusign.hackathon.db.model.GoogleCredential;
import com.docusign.hackathon.db.model.GoogleCredentialPK;
import com.docusign.hackathon.db.model.NotificationDetail;
import com.docusign.hackathon.db.model.NotificationDetailPK;
import com.docusign.hackathon.model.EstimateInfo;
import com.docusign.hackathon.model.EstimateRequest;
import com.docusign.hackathon.model.EstimateResponse;
import com.docusign.hackathon.model.OAuthTokenData;
import com.docusign.hackathon.repository.GoogleCredentialRepository;
import com.docusign.hackathon.repository.NotificationDetailRepository;
import com.docusign.hackathon.service.DSAuthService;
import com.docusign.hackathon.service.GoogleMailService;
import com.docusign.hackathon.service.POCService;
import com.docusign.hackathon.transformer.EstimateRequestTransformer;
import com.docusign.hackathon.util.HackathonUtil;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;

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

	@Autowired
	DSAuthService dsAuthService;

	@Autowired
	GoogleCredentialRepository googleCredentialRepository;

	@Autowired
	NotificationDetailRepository notificationDetailRepository;

	@Value("${heroku.gmail.sender.username}")
	private String gmailSenderUsername;

	@Value("${heroku.gmail.notification.email.title}")
	private String gmailNotificationEmailTitle;

	@Value("${heroku.gmail.notification.email.body}")
	private String gmailNotificationEmailBody;

	@Value("${heroku.gmail.notification.autoresponded.email.title}")
	private String gmailDeliveryFailEmailTitle;

	@Value("${heroku.gmail.notification.autoresponded.email.body}")
	private String gmailDeliveryFailEmailBody;

	@Value("${heroku.gmail.application.name}")
	private String gmailApplicationName;

	@Value("${heroku.docusign.api.clientid}")
	private String docuSignAPIClientId;

	@Value("${heroku.docusign.api.username}")
	private String docuSignAPIUserName;

	@Value("${heroku.docusign.api.password}")
	private String docuSignAPIPassword;

	private static final Logger logger = LogManager.getLogger(POCController.class);

	@RequestMapping(value = "/estimates", method = RequestMethod.GET)
	public String estimates(ModelMap model, HttpServletRequest request) {

		logger.debug("POCController.estimates()");

		return "estimates";
	}

	@RequestMapping(value = "/gmailauth", method = RequestMethod.GET)
	public String gmailauth(ModelMap model, HttpServletRequest request) {

		logger.debug("POCController.gmailauth()");

		GoogleAuthorizationCodeFlow flow = hackathonUtil.getGoogleAuthFlow();

		AuthorizationCodeRequestUrl authorizationUrl = flow.newAuthorizationUrl()
				.setRedirectUri(hackathonUtil.createRedirectUri(request, "/successcallback"));

		String googleOAuthUrl = authorizationUrl.build();
		model.put("googleOAuthUrl", googleOAuthUrl);

		return "gmailauth";
	}

	@RequestMapping(value = "/dsauth", method = RequestMethod.GET)
	public String dsauth(ModelMap model, HttpServletRequest request) {

		logger.debug("POCController.dsauth()");

		UUID state = UUID.randomUUID();
		String[] scopes = { "signature" };
		String redirecUri = hackathonUtil.createRedirectUri(request, "dssuccesscallback");

		String dsOAuthUrl = dsAuthService.getAuthCodeGrantUrl(scopes, state.toString(), redirecUri, false);
		model.put("dsOAuthUrl", dsOAuthUrl);

		return "dsauth";
	}

	@RequestMapping(value = "/successcallback", method = RequestMethod.GET)
	public String successcallback(ModelMap model) {

		logger.debug("POCController.successcallback()");

		return "successcallback";
	}

	@RequestMapping(value = "/failcallback", method = RequestMethod.GET)
	public String failcallback(ModelMap model) {

		logger.debug("POCController.failcallback()");

		return "failcallback";
	}
	
	@RequestMapping(value = "/fetchDSToken", method = RequestMethod.GET)
	@ResponseBody
	public String fetchDSToken(@RequestParam("authCode") String authCode, HttpServletRequest request,
			ModelMap model) {
		
		logger.debug("POCController.fetchDSToken()");
		
		OAuthTokenData oAuthTokenData = dsAuthService.getASAccessTokenUsingAuthCode(authCode);

		String accessToken = oAuthTokenData.getAccessToken();
		
		logger.debug("DSToken in POCController.fetchDSToken() " + accessToken);
		
		return accessToken;
	}

	@RequestMapping(value = "/fetchGoogleToken", method = RequestMethod.GET)
	@ResponseBody
	public String fetchGoogleToken(@RequestParam("authCode") String authCode, HttpServletRequest request,
			ModelMap model) {

		logger.debug("POCController.fetchGoogleToken()");

		String accessToken = null;

		try {

			GoogleAuthorizationCodeFlow flow = hackathonUtil.getGoogleAuthFlow();

			TokenResponse response = flow.newTokenRequest(authCode)
					.setRedirectUri(hackathonUtil.createRedirectUri(request, "/successcallback")).execute();

			logger.debug("TokenType in POCController.fetchGoogleToken()- " + response.getTokenType());
			accessToken = response.getAccessToken();

			GoogleCredentialPK googleCredentialPK = new GoogleCredentialPK();
			googleCredentialPK.setApplicationName(gmailApplicationName);
			googleCredentialPK.setGoogleEmail(gmailSenderUsername);

			GoogleCredential googleCredential = new GoogleCredential();
			googleCredential.setGoogleCredentialPK(googleCredentialPK);
			googleCredential.setAccessToken(response.getAccessToken());
			googleCredential.setExpiresIn(new BigInteger(response.getExpiresInSeconds().toString()));
			googleCredential.setRefreshToken(response.getRefreshToken());
			googleCredential.setTokenType(response.getTokenType());

			googleCredentialRepository.save(googleCredential);

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

		String authHeaderValue = "{" + '"' + "Username" + '"' + ":" + '"' + docuSignAPIUserName + '"' + "," + '"'
				+ "Password" + '"' + ":" + '"' + docuSignAPIPassword + '"' + "," + '"' + "IntegratorKey" + '"' + ":"
				+ '"' + docuSignAPIClientId + '"' + "}";

		String authHeader = request.getHeader("X-DocuSign-Authentication");

		if (!StringUtils.isEmpty(request.getHeader("Authorization"))) {
			authHeaderMap.put("Authorization", request.getHeader("Authorization"));
		} else if (!StringUtils.isEmpty(authHeader)) {
			authHeaderMap.put("X-DocuSign-Authentication", authHeader);
		} else {
			authHeaderMap.put("X-DocuSign-Authentication", authHeaderValue);
		}

		logger.debug("POCController.createEstimates() " + files + " RecipientInfoList size "
				+ estimateInfo.getRecipientInfoList().size() + " estimateInfo- " + estimateInfo + " authHeaderMap- "
				+ authHeaderMap);

		List<EstimateRequest> estimateRequestList = estimateRequestTransformer.transformToEstimateRequest(estimateInfo,
				files);

		String envelopeId = pocService.createPOCService(estimateRequestList, estimateInfo.getEmailBlurb(),
				estimateInfo.getEmailSubject(), authHeaderMap);

		logger.info("envelopeId in POCController.createEstimates()- " + envelopeId);

		EstimateResponse estimateResponse = new EstimateResponse();
		estimateResponse.setEnvelopeId(envelopeId);

		return estimateResponse;
	}

	@RequestMapping(value = "/notifySender", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> notifySender(HttpServletRequest request,
			@RequestBody DocuSignEnvelopeInformation docuSignEnvelopeInformation) {

		if (null != docuSignEnvelopeInformation && null != docuSignEnvelopeInformation.getEnvelopeStatus()) {

			String envelopeId = docuSignEnvelopeInformation.getEnvelopeStatus().getEnvelopeID();
			logger.info("EnvelopeId in POCController.notifySender()- " + envelopeId);

			List<RecipientStatus> recipientStatusList = docuSignEnvelopeInformation.getEnvelopeStatus()
					.getRecipientStatuses().getRecipientStatus();

			String requestorEmail = null;
			ArrayOfCustomField arrayOfCustomField = docuSignEnvelopeInformation.getEnvelopeStatus().getCustomFields();
			List<CustomField> customFieldList = arrayOfCustomField.getCustomField();

			for (CustomField customField : customFieldList) {
				if ("requestorEmail".equalsIgnoreCase(customField.getName())) {

					requestorEmail = customField.getValue();
					break;
				}
			}

			for (RecipientStatus recipient : recipientStatusList) {

				String recipientEmail = recipient.getEmail();

				NotificationDetailPK notificationDetailPK = new NotificationDetailPK();
				notificationDetailPK.setEnvelopeId(envelopeId);
				notificationDetailPK.setRecipientEmail(recipientEmail);

				NotificationDetail notificationDetailAvailable = notificationDetailRepository
						.findOne(notificationDetailPK);

				logger.info("Recipient Status in POCController.notifySender()" + recipient.getStatus() + " for email "
						+ recipientEmail);
				if ((RecipientStatusCode.DELIVERED == recipient.getStatus()
						|| RecipientStatusCode.COMPLETED == recipient.getStatus())
						&& (null == notificationDetailAvailable
								|| null == notificationDetailAvailable.getNotificationStatus())) {

					String recipientName = recipient.getUserName();
					XMLGregorianCalendar viewedTimeCalendar = recipient.getDelivered();

					Date viewedDateTime = viewedTimeCalendar.toGregorianCalendar().getTime();

					String viewedDate = hackathonUtil.convertXMLGregStrToDate(viewedDateTime);
					String viewedTime = hackathonUtil.convertXMLGregStrToTimestamp(viewedDateTime);

					try {
						String emailSubject = MessageFormat.format(gmailNotificationEmailTitle, recipientName,
								envelopeId);

						String emailBody = MessageFormat.format(gmailNotificationEmailBody, recipientName,
								recipientEmail, envelopeId, viewedDate, viewedTime);

						GoogleCredential googleCredential = fetchGoogleAccessToken();

						logger.info("requestorEmail in POCController.notifySender()" + requestorEmail
								+ " gmailSenderUsername- " + gmailSenderUsername);
						googleMailService.Send(requestorEmail, "", gmailSenderUsername, emailSubject, emailBody,
								googleCredential.getTokenType(), googleCredential.getAccessToken());

						NotificationDetail notificationDetailSave = new NotificationDetail();
						notificationDetailSave.setNotificationDetailPK(notificationDetailPK);
						notificationDetailSave.setNotificationStatus("sent");
						notificationDetailSave.setSenderEmail(gmailSenderUsername);

						if (!StringUtils.isEmpty(requestorEmail)) {

							notificationDetailSave.setRequestorEmail(requestorEmail);
						} else {
							notificationDetailSave.setRequestorEmail(gmailSenderUsername);
						}

						notificationDetailRepository.save(notificationDetailSave);

						logger.info("Notification sent in POCController.notifySender()");

					} catch (IOException e) {
						e.printStackTrace();

						return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
					} catch (MessagingException e) {
						e.printStackTrace();

						return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
					} catch (Exception e) {

						e.printStackTrace();

						return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
			}
		}

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/notifyDeliveryFailSender", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> notifyDeliveryFailSender(HttpServletRequest request,
			@RequestBody DocuSignEnvelopeInformation docuSignEnvelopeInformation) {

		if (null != docuSignEnvelopeInformation && null != docuSignEnvelopeInformation.getEnvelopeStatus()) {

			String envelopeId = docuSignEnvelopeInformation.getEnvelopeStatus().getEnvelopeID();
			logger.info("EnvelopeId in POCController.notifyDeliveryFailSender()- " + envelopeId);

			String senderEmail = docuSignEnvelopeInformation.getEnvelopeStatus().getEmail();

			List<RecipientStatus> recipientStatusList = docuSignEnvelopeInformation.getEnvelopeStatus()
					.getRecipientStatuses().getRecipientStatus();

			for (RecipientStatus recipient : recipientStatusList) {

				if (RecipientStatusCode.AUTO_RESPONDED == recipient.getStatus()
						|| !StringUtils.isEmpty(recipient.getAutoRespondedReason())) {

					String recipientEmail = recipient.getEmail();

					String emailSubject = MessageFormat.format(gmailDeliveryFailEmailTitle, recipientEmail);

					String emailBody = MessageFormat.format(gmailDeliveryFailEmailBody, recipientEmail, envelopeId);

					GoogleCredential googleCredential = fetchGoogleAccessToken();
					try {
						googleMailService.Send(senderEmail, "", gmailSenderUsername, emailSubject, emailBody,
								googleCredential.getTokenType(), googleCredential.getAccessToken());
					} catch (IOException e) {
						e.printStackTrace();

						return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
					} catch (MessagingException e) {
						e.printStackTrace();

						return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
			}
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	private GoogleCredential fetchGoogleAccessToken() {

		GoogleCredentialPK id = new GoogleCredentialPK();
		id.setApplicationName(gmailApplicationName);
		id.setGoogleEmail(gmailSenderUsername);

		GoogleCredential googleCredential = googleCredentialRepository.findOne(id);

		String accessToken = googleCredential.getAccessToken();
		boolean accessTokenValid = googleMailService.validateAccessToken(accessToken);

		if (!accessTokenValid) {

			accessToken = googleMailService.refreshGoogleToken(googleCredential.getRefreshToken());
			googleCredential.setAccessToken(accessToken);

			googleCredentialRepository.save(googleCredential);
		}

		return googleCredential;

	}

}