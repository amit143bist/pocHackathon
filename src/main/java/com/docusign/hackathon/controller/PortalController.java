package com.docusign.hackathon.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.docusign.hackathon.connect.model.ArrayOfTabStatus;
import com.docusign.hackathon.connect.model.DocuSignEnvelopeInformation;
import com.docusign.hackathon.connect.model.RecipientStatus;
import com.docusign.hackathon.connect.model.RecipientStatusCode;
import com.docusign.hackathon.connect.model.TabStatus;
import com.docusign.hackathon.model.Recipients;
import com.docusign.hackathon.model.Signer;
import com.docusign.hackathon.model.TwitterEnvelope;
import com.docusign.hackathon.service.EnvelopeService;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

@Controller
@RequestMapping("hackathon")
public class PortalController {

	@Autowired
	EnvelopeService envelopeService;

	private static final Logger logger = LogManager.getLogger(PortalController.class);

	@RequestMapping(value = "/createEnvelope", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createEnvelope(@RequestBody TwitterEnvelope twitterEnvelope) {

		logger.debug("PortalController.createEnvelope() " + envelopeService);

		Status lastTweet = readPrivateTwitterMessage();
		twitterEnvelope.setPostMessage(lastTweet.getText());
		twitterEnvelope.setSubmitterName(lastTweet.getUser().getName());

		String envelopeId = envelopeService.createEnvelope(twitterEnvelope);
		logger.debug("PortalController.createEnvelope() " + twitterEnvelope);

		return new ResponseEntity<String>(envelopeId, HttpStatus.OK);
	}

	private Status readPrivateTwitterMessage() {

		TwitterFactory factory = new TwitterFactory();
		AccessToken accessToken = loadAccessToken(1);
		Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer("uI0rvuvB2LOV2qHD5GcyEhwJN", "jIyGfMyaiBjvF3VdC8eTNmAOW2S8R7Tvx6wSlpuvh9efjJtK0r");
		twitter.setOAuthAccessToken(accessToken);

		Paging paging = new Paging();
		paging.setCount(1);
		ResponseList<Status> userTimeLineList = null;

		Status stat = null;
		try {
			userTimeLineList = twitter.getUserTimeline(paging);
			stat = userTimeLineList.get(0);
		} catch (TwitterException e) {
			e.printStackTrace();
		}

		return stat;
	}

	private static AccessToken loadAccessToken(int useId) {
		String token = "961256536759676928-uIxDD2eJmJxsGANCquw8BbsLhOcwEn2";
		String tokenSecret = "ueFOQjrbsp4oylhIGp4WfNFTp5Pg5cvy1Nu8NsgUd1F6h";
		return new AccessToken(token, tokenSecret);
	}

	@RequestMapping(value = "/portal", method = RequestMethod.GET)
	public String portalHome(@RequestParam(value = "envelopeId") String envelopeId, ModelMap model) {

		model.addAttribute("serverTime", " Test1111 ");

		model.addAttribute("envelopeId", envelopeId);

		logger.debug("PortalController.portalHome()");

		return "home";
	}

	@RequestMapping(value = "/redirectSuccess", method = RequestMethod.GET)
	public String portalRedirect() {

		logger.debug("PortalController.portalRedirect()");

		return "redirectSuccess";
	}

	@RequestMapping(value = "/validateAccessCode", method = RequestMethod.GET)
	@ResponseBody
	public String validateAccessCode(@RequestParam(value = "accessCode") String accessCode,
			@RequestParam(value = "envelopeId") String envelopeId, HttpServletRequest request) {

		logger.info("AccessCode in PortalController.validateAccessCode() " + accessCode);
		Recipients recipients = envelopeService.fetchRecipients(envelopeId);

		boolean accessCodeValid = false;
		if (null != recipients) {

			List<Signer> signers = recipients.getSigners();

			Signer signerRecipient = signers.get(0);

			if ((accessCode.replaceAll("\\W", "")).equalsIgnoreCase(signerRecipient.getAccessCode())) {

				accessCodeValid = true;
			}

		}

		logger.info("PortalController.validateAccessCode() " + accessCodeValid);

		return String.valueOf(accessCodeValid);
	}

	@RequestMapping(value = "/getRecipientViewUrl", method = RequestMethod.GET)
	public String getRecipientViewUrl(HttpServletRequest request,
			@RequestParam(value = "envelopeId") String envelopeId) {

		logger.debug("PortalController.getRecipientViewUrl() " + envelopeId);

		Recipients recipients = envelopeService.fetchRecipients(envelopeId);

		List<Signer> signers = recipients.getSigners();

		Signer signerRecipient = signers.get(0);

		envelopeService.updateRecipient(envelopeId);
		String recipientUrl = envelopeService.recipientUrl(envelopeId, signerRecipient.getClientUserId(),
				signerRecipient.getEmail(), signerRecipient.getName());

		logger.info("Current time in PortalController.getRecipientViewUrl() before redirect is "
				+ Calendar.getInstance().getTime());

		return "redirect:" + recipientUrl;

	}

	@RequestMapping(value = "/postAcmeConnect", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> postAcmeConnect(HttpServletRequest request,
			@RequestBody DocuSignEnvelopeInformation docuSignEnvelopeInformation) {

		logger.info("Current time in PortalController.postAcmeConnect() is " + Calendar.getInstance().getTime());

		String twitterPostMessage = null;

		if (null != docuSignEnvelopeInformation && null != docuSignEnvelopeInformation.getEnvelopeStatus()) {

			List<RecipientStatus> recipientStatusList = docuSignEnvelopeInformation.getEnvelopeStatus()
					.getRecipientStatuses().getRecipientStatus();

			for (RecipientStatus recipient : recipientStatusList) {

				if (RecipientStatusCode.COMPLETED == recipient.getStatus()) {

					ArrayOfTabStatus arrayOfTabStatus = recipient.getTabStatuses();

					List<TabStatus> tabStatusList = arrayOfTabStatus.getTabStatus();
					for (TabStatus tabStatus : tabStatusList) {

						if ("postMessage".equalsIgnoreCase(tabStatus.getTabLabel())) {

							twitterPostMessage = tabStatus.getTabValue();
							break;
						}
					}

				}
			}

		}

		if (!StringUtils.isEmpty(twitterPostMessage)) {

			TwitterFactory factory = new TwitterFactory();
			AccessToken accessToken = loadAccessTokenForCorp(1);
			Twitter twitter = factory.getInstance();
			twitter.setOAuthConsumer("hJHza0hloY3YDY7YexAK48C7t", "yrjmpFaySNS2nooUULdKmhOnhBmr8ivJWNXY2Munr65gu85lCV");
			twitter.setOAuthAccessToken(accessToken);

			try {
				twitter.updateStatus(twitterPostMessage);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		}

		logger.info("Current time after posting twitter message is " + Calendar.getInstance().getTime());

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	private static AccessToken loadAccessTokenForCorp(int useId) {
		String token = "961423566720782336-fl7Hv6XOoEzSGbjdecGeGNCMuQV5lsY";
		String tokenSecret = "cv8byVXpQ56WkJDwEPDOBnX8PHj89coqH33gj3xKprD6I";
		return new AccessToken(token, tokenSecret);
	}

}