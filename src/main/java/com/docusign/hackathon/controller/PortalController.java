package com.docusign.hackathon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/createEnvelope", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createEnvelope(@RequestBody TwitterEnvelope twitterEnvelope) {

		System.out.println("PortalController.createEnvelope() " + envelopeService);

		Status lastTweet = readPrivateTwitterMessage();
		twitterEnvelope.setPostMessage(lastTweet.getText());
		twitterEnvelope.setSubmitterName(lastTweet.getUser().getName());

		String envelopeId = envelopeService.createEnvelope(twitterEnvelope);
		System.out.println("PortalController.createEnvelope() " + twitterEnvelope);

		return new ResponseEntity<String>(envelopeId, HttpStatus.OK);
	}

	private Status readPrivateTwitterMessage() {

		TwitterFactory factory = new TwitterFactory();
		AccessToken accessToken = loadAccessToken(1);
		Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer("uI0rvuvB2LOV2qHD5GcyEhwJN", "jIyGfMyaiBjvF3VdC8eTNmAOW2S8R7Tvx6wSlpuvh9efjJtK0r");
		twitter.setOAuthAccessToken(accessToken);

		System.out.println("TestTwitter.main()");
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

		System.out.println("PortalController.portalHome()");

		return "home";
	}

	@RequestMapping(value = "/redirectSuccess", method = RequestMethod.GET)
	public String portalRedirect() {

		System.out.println("PortalController.portalRedirect()");

		return "redirectSuccess";
	}

	@RequestMapping(value = "/validateAccessCode", method = RequestMethod.GET)
	@ResponseBody
	public String validateAccessCode(@RequestParam(value = "accessCode") String accessCode,
			@RequestParam(value = "envelopeId") String envelopeId, HttpServletRequest request) {

		Recipients recipients = envelopeService.fetchRecipients(envelopeId);

		boolean accessCodeValid = false;
		if (null != recipients) {

			List<Signer> signers = recipients.getSigners();

			Signer signerRecipient = signers.get(0);

			System.out.println("PortalController.validateAccessCode()- " + accessCode.replaceAll("\\W", ""));

			System.out.println("PortalController.validateAccessCode()signerRecipient.getAccessCode() "
					+ signerRecipient.getAccessCode());
			System.out.println(
					"PortalController.validateAccessCode()signerRecipient.getEmail() " + signerRecipient.getEmail());
			if ((accessCode.replaceAll("\\W", "")).equalsIgnoreCase(signerRecipient.getAccessCode())) {

				accessCodeValid = true;
				// request.getSession().setAttribute("envelopeId", envelopeId);
			}

		}

		System.out.println("PortalController.validateAccessCode() " + accessCodeValid);

		return String.valueOf(accessCodeValid);
	}

	@RequestMapping(value = "/getRecipientViewUrl", method = RequestMethod.GET)
	public String getRecipientViewUrl(HttpServletRequest request,
			@RequestParam(value = "envelopeId") String envelopeId) {

		System.out.println("PortalController.getRecipientViewUrl() " + envelopeId);

		/*
		 * if (null == envelopeId) {
		 * 
		 * envelopeId = (String)
		 * request.getSession().getAttribute("envelopeId"); }
		 */

		Recipients recipients = envelopeService.fetchRecipients(envelopeId);

		List<Signer> signers = recipients.getSigners();

		Signer signerRecipient = signers.get(0);

		envelopeService.updateRecipient(envelopeId);
		String recipientUrl = envelopeService.recipientUrl(envelopeId, signerRecipient.getClientUserId(),
				signerRecipient.getEmail(), signerRecipient.getName());

		return "redirect:" + recipientUrl;

	}

}