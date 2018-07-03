package com.docusign.hackathon.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.docusign.hackathon.connect.model.DocuSignEnvelopeInformation;
import com.docusign.hackathon.connect.model.EnvelopeStatusCode;
import com.docusign.hackathon.connect.model.RecipientStatus;
import com.docusign.hackathon.db.model.EnvelopeDetails;
import com.docusign.hackathon.db.model.EnvelopeDetailsPK;
import com.docusign.hackathon.domain.EmbeddedURLResponse;
import com.docusign.hackathon.domain.EnvelopeCreationResponse;
import com.docusign.hackathon.domain.EnvelopeData;
import com.docusign.hackathon.domain.RecipientData;
import com.docusign.hackathon.repository.EnvelopeDetailsRepository;
import com.docusign.hackathon.service.HybridService;

@Controller
public class EnvelopeController {

	@Autowired
	EnvelopeDetailsRepository envelopeDetailsRepository;

	@Autowired
	HybridService hybridService;

	private static final Logger logger = LogManager.getLogger(EnvelopeController.class);

	@RequestMapping(value = "/portalLanding", method = RequestMethod.GET)
	public String portalLogin() {

		return "portallogin";
	}

	@RequestMapping(value = "/portalLandingTest", method = RequestMethod.GET)
	public String portalLandingTest() {

		return "portallogintest";
	}

	@RequestMapping(value = "/agentLogin", method = RequestMethod.POST)
	public String agentLogin(@RequestParam(value = "agentusername") String username,
			@RequestParam(value = "agentpassword") String password) {

		return "agenthome";
	}

	@RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
	public String customerLogin(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		model.addAttribute("recipientEmail", username);
		return "customerhome";
	}

	@RequestMapping(value = "/customerLoginIframe", method = RequestMethod.POST)
	public String customerLoginIframe(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		model.addAttribute("recipientEmail", username);
		return "customerhomeiframe";
	}
	
	@RequestMapping(value = "/customerLoginIframeNonAngular", method = RequestMethod.POST)
	public String customerLoginIframeNonAngular(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		model.addAttribute("recipientEmail", username);
		return "customerIframenonangular";
	}

	@RequestMapping(value = "/emeddedCallback", method = RequestMethod.GET)
	public String emeddedCallback(@RequestParam String envelopeId, @RequestParam String recipientName,
			@RequestParam String recipientEmail, @RequestParam String event, Model model) {

		if ("signing_complete".equalsIgnoreCase(event) || "decline".equalsIgnoreCase(event)) {

			EnvelopeDetailsPK envelopeDetailsPK = new EnvelopeDetailsPK();
			envelopeDetailsPK.setEnvelopeId(UUID.fromString(envelopeId));
			envelopeDetailsPK.setRecipientEmail(recipientEmail);
			envelopeDetailsPK.setRecipientId(BigInteger.ONE);

			EnvelopeDetails envelopeDetails = envelopeDetailsRepository.findOne(envelopeDetailsPK);

			if ("signing_complete".equalsIgnoreCase(event)) {
				envelopeDetails.setEnvelopeStatus(EnvelopeStatusCode.COMPLETED.value());
			} else {
				envelopeDetails.setEnvelopeStatus(EnvelopeStatusCode.DECLINED.value());
			}

			envelopeDetailsRepository.save(envelopeDetails);

		}

		model.addAttribute("recipientEmail", recipientEmail);
		return "customerhome";
	}

	@RequestMapping(value = "/createWorkspaceRemoteEnvelope", method = RequestMethod.POST)
	public @ResponseBody EnvelopeCreationResponse createEnvelope(@RequestBody RecipientData recipientData) {

		String recipientName = recipientData.getRecipientName();
		String recipientEmail = recipientData.getRecipientEmail();

		logger.info("In EnvelopeController.createEnvelope() recipientName- " + recipientName + " recipientEmail- "
				+ recipientEmail);
		String workspaceId = hybridService.createWorkspace();

		StringBuilder envelopeBuilder = new StringBuilder();
		String envelopeId = hybridService.createRecipientEnvelopes(recipientName, recipientEmail, workspaceId, false);
		saveEnvelopeDetails(envelopeId, workspaceId, recipientName, recipientEmail, false);

		envelopeBuilder.append(envelopeId);
		envelopeId = hybridService.createRecipientEnvelopes(recipientName, recipientEmail, workspaceId, true);
		saveEnvelopeDetails(envelopeId, workspaceId, recipientName, recipientEmail, true);

		envelopeBuilder.append(", ");
		envelopeBuilder.append(envelopeId);

		EnvelopeCreationResponse envelopeResponse = new EnvelopeCreationResponse();
		envelopeResponse.setEnvelopeId(envelopeBuilder.toString());
		return envelopeResponse;
	}

	@RequestMapping(value = "/fetchRecipientEnvelopes", method = RequestMethod.GET)
	public @ResponseBody List<EnvelopeData> fetchRecipientEnvelopes(@RequestParam String recipientEmail,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("In EnvelopeController.fetchRecipientEnvelopes() recipientEmail- " + recipientEmail);

		List<EnvelopeDetails> envelopeList = envelopeDetailsRepository
				.findByEnvelopeDetailsPK_RecipientEmailAndEnvelopeStatus(recipientEmail, "sent");

		List<EnvelopeData> envelopeDataList = new ArrayList<EnvelopeData>();
		for (EnvelopeDetails envelopeDetails : envelopeList) {

			EnvelopeData envelopeData = new EnvelopeData();
			envelopeData.setEnvelopeId(envelopeDetails.getEnvelopeDetailsPK().getEnvelopeId().toString());
			envelopeData.setEnvelopeSubject(envelopeDetails.getEnvelopeSubject());
			envelopeData.setRecipientEmail(envelopeDetails.getEnvelopeDetailsPK().getRecipientEmail());

			envelopeDataList.add(envelopeData);
		}

		return envelopeDataList;
	}

	@RequestMapping(value = "/redirectToRecipientViewUrlIframe", method = RequestMethod.GET)
	@ResponseBody
	public EmbeddedURLResponse redirectToRecipientViewUrlIframe(@RequestParam("envelopeId") String envelopeId,
			@RequestParam("recipientEmail") String recipientEmail, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("EnvelopeController.redirectToRecipientViewUrlIframe()");

		EmbeddedURLResponse embeddedURLResponse = new EmbeddedURLResponse();
		String embeddedUrl = createRecipientViewUrl(envelopeId, recipientEmail);
		embeddedURLResponse.setEmbeddedUrl(embeddedUrl);
		return embeddedURLResponse;
	}

	private String createRecipientViewUrl(String envelopeId, String recipientEmail) {

		logger.info("In EnvelopeController.createRecipientViewUrl()");

		EnvelopeDetailsPK envelopeDetailsPK = new EnvelopeDetailsPK();
		envelopeDetailsPK.setEnvelopeId(UUID.fromString(envelopeId));
		envelopeDetailsPK.setRecipientEmail(recipientEmail);
		envelopeDetailsPK.setRecipientId(BigInteger.ONE);

		EnvelopeDetails envelopeDetails = envelopeDetailsRepository.findOne(envelopeDetailsPK);

		String clientUserId = null;
		UUID clientUserUUID = envelopeDetails.getClientUserId();
		if (StringUtils.isEmpty(clientUserUUID)) {

			clientUserUUID = UUID.randomUUID();

			envelopeDetails.setClientUserId(clientUserUUID);

			clientUserId = clientUserUUID.toString();
			hybridService.changeToEmbeddedRecipient(envelopeId, recipientEmail, clientUserId);
			envelopeDetailsRepository.save(envelopeDetails);
		} else {
			clientUserId = clientUserUUID.toString();
		}

		String recipientViewUrl = hybridService.recipientViewUrl(envelopeId, envelopeDetails.getRecipientName(),
				recipientEmail, clientUserId);

		logger.info("URL created in EnvelopeController.createRecipientViewUrl() is " + recipientViewUrl);
		return recipientViewUrl;
	}

	@RequestMapping(value = "/redirectToRecipientViewUrl", method = RequestMethod.GET)
	public String redirectToRecipientViewUrl(@RequestParam("envelopeId") String envelopeId,
			@RequestParam("recipientEmail") String recipientEmail, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("In EnvelopeController.redirectToRecipientViewUrl() recipientEmail- " + recipientEmail
				+ " envelopeId- " + envelopeId);

		return "redirect:" + createRecipientViewUrl(envelopeId, recipientEmail);
	}

	@RequestMapping(value = "/postConnect", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> postConnect(HttpServletRequest request,
			@RequestBody DocuSignEnvelopeInformation docuSignEnvelopeInformation) {

		logger.info("EnvelopeController.postConnect() is " + Calendar.getInstance().getTime());

		if (null != docuSignEnvelopeInformation && null != docuSignEnvelopeInformation.getEnvelopeStatus()
				&& EnvelopeStatusCode.COMPLETED == docuSignEnvelopeInformation.getEnvelopeStatus().getStatus()) {

			List<RecipientStatus> recipientStatusList = docuSignEnvelopeInformation.getEnvelopeStatus()
					.getRecipientStatuses().getRecipientStatus();

			for (RecipientStatus recipient : recipientStatusList) {

				String recipientEmail = recipient.getEmail();
				String envelopeId = docuSignEnvelopeInformation.getEnvelopeStatus().getEnvelopeID();

				EnvelopeDetailsPK envelopeDetailsPK = new EnvelopeDetailsPK();
				envelopeDetailsPK.setEnvelopeId(UUID.fromString(envelopeId));
				envelopeDetailsPK.setRecipientEmail(recipientEmail);
				envelopeDetailsPK.setRecipientId(BigInteger.ONE);

				EnvelopeDetails envelopeDetails = envelopeDetailsRepository.findOne(envelopeDetailsPK);

				if (!EnvelopeStatusCode.COMPLETED.value().equalsIgnoreCase(envelopeDetails.getEnvelopeStatus())) {

					envelopeDetails.setEnvelopeStatus(EnvelopeStatusCode.COMPLETED.value());
					envelopeDetailsRepository.save(envelopeDetails);
				}
			}
		}

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	private void saveEnvelopeDetails(String envelopeId, String workspaceId, String recipientName, String recipientEmail,
			boolean isUploadEnvelope) {

		EnvelopeDetailsPK envelopeDetailsPK = new EnvelopeDetailsPK();
		envelopeDetailsPK.setEnvelopeId(UUID.fromString(envelopeId));
		envelopeDetailsPK.setRecipientEmail(recipientEmail);
		envelopeDetailsPK.setRecipientId(BigInteger.ONE);

		EnvelopeDetails envelopeDetails = new EnvelopeDetails();
		envelopeDetails.setEnvelopeDetailsPK(envelopeDetailsPK);
		envelopeDetails.setEnvelopeStatus("sent");
		envelopeDetails.setRecipientName(recipientName);
		envelopeDetails.setWorkspaceId(UUID.fromString(workspaceId));

		if (isUploadEnvelope) {

			envelopeDetails.setEnvelopeSubject("Please upload the required documents");
		} else {

			envelopeDetails.setEnvelopeSubject("Please sign the required documents");
		}

		envelopeDetailsRepository.save(envelopeDetails);
	}
}