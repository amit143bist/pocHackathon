package com.docusign.hackathon.controller;

import java.math.BigInteger;
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

	@RequestMapping(value = "/emeddedCallback", method = RequestMethod.GET)
	public String emeddedCallback(@RequestParam String envelopeId, @RequestParam String recipientName,
			@RequestParam String recipientEmail, @RequestParam String event, Model model) {

		if ("signing_complete".equalsIgnoreCase(event)) {

			EnvelopeDetailsPK envelopeDetailsPK = new EnvelopeDetailsPK();
			envelopeDetailsPK.setEnvelopeId(UUID.fromString(envelopeId));
			envelopeDetailsPK.setRecipientEmail(recipientEmail);
			envelopeDetailsPK.setRecipientId(BigInteger.ONE);

			EnvelopeDetails envelopeDetails = envelopeDetailsRepository.findOne(envelopeDetailsPK);

			envelopeDetails.setEnvelopeStatus(EnvelopeStatusCode.COMPLETED.value());
			envelopeDetailsRepository.save(envelopeDetails);

		}

		model.addAttribute("recipientEmail", recipientEmail);
		return "customerhome";
	}

	@RequestMapping(value = "/createWorkspaceRemoteEnvelope", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createEnvelope(@RequestParam String recipientName,
			@RequestParam String recipientEmail) {

		logger.info("In EnvelopeController.createEnvelope() recipientName- " + recipientName + " recipientEmail- "
				+ recipientEmail);
		String workspaceId = hybridService.createWorkspace();

		StringBuilder envelopeBuilder = new StringBuilder();
		String envelopeId = hybridService.createRecipientEnvelopes(recipientName, recipientEmail, workspaceId, false);
		saveEnvelopeDetails(envelopeId, workspaceId, recipientName, recipientEmail, false);

		envelopeBuilder.append(envelopeId);
		envelopeId = hybridService.createRecipientEnvelopes(recipientName, recipientEmail, workspaceId, true);
		saveEnvelopeDetails(envelopeId, workspaceId, recipientName, recipientEmail, true);

		envelopeBuilder.append(envelopeId);

		return ResponseEntity.ok(envelopeBuilder.toString());
	}

	@RequestMapping(value = "/fetchRecipientEnvelopes", method = RequestMethod.GET)
	public @ResponseBody List<EnvelopeDetails> fetchRecipientEnvelopes(@RequestParam String recipientEmail,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("In EnvelopeController.fetchRecipientEnvelopes() recipientEmail- " + recipientEmail);

		List<EnvelopeDetails> envelopeList = envelopeDetailsRepository
				.findByEnvelopeDetailsPK_RecipientEmailAndEnvelopeStatus(recipientEmail, "sent");
		
		for(EnvelopeDetails envelopeDetails: envelopeList){
			
			logger.info("EnvelopeDetailsPK- " + envelopeDetails.getEnvelopeDetailsPK());
			logger.info("EnvelopeId- " + envelopeDetails.getEnvelopeDetailsPK().getEnvelopeId());
		}

		return envelopeList;
	}

	@RequestMapping(value = "/createRecipientViewUrl", method = RequestMethod.POST)
	public String createRecipientViewUrl(@RequestParam String envelopeId, @RequestParam String recipientEmail) {

		logger.info("In EnvelopeController.createRecipientViewUrl() recipientEmail- " + recipientEmail + " envelopeId- "
				+ envelopeId);

		EnvelopeDetailsPK envelopeDetailsPK = new EnvelopeDetailsPK();
		envelopeDetailsPK.setEnvelopeId(UUID.fromString(envelopeId));
		envelopeDetailsPK.setRecipientEmail(recipientEmail);
		envelopeDetailsPK.setRecipientId(BigInteger.ONE);

		EnvelopeDetails envelopeDetails = envelopeDetailsRepository.findOne(envelopeDetailsPK);

		UUID clientUUID = UUID.randomUUID();
		String clientUserId = UUID.randomUUID().toString();

		envelopeDetails.setClientUserId(clientUUID);

		hybridService.changeToEmbeddedRecipient(envelopeId, recipientEmail, clientUserId);
		envelopeDetailsRepository.save(envelopeDetails);

		String recipientViewUrl = hybridService.recipientViewUrl(envelopeId, envelopeDetails.getRecipientName(),
				recipientEmail, clientUserId);

		return "redirect:" + recipientViewUrl;
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