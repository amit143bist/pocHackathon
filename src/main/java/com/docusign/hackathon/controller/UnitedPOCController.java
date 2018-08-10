package com.docusign.hackathon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.docusign.hackathon.domain.EnvelopeCreationResponse;
import com.docusign.hackathon.service.UnitedPOCService;

@Controller
public class UnitedPOCController {

	@Autowired
	UnitedPOCService unitedPOCService;

	private static final Logger logger = LogManager.getLogger(UnitedPOCController.class);

	@RequestMapping(value = "/pdatHome", method = RequestMethod.GET)
	public String portalLandingTest() {

		logger.info("In UnitedPOCController.portalLandingTest()");
		return "technicianlogin";
	}

	@RequestMapping(value = "/createEnvelopeAsSenderView", method = RequestMethod.POST)
	@ResponseBody
	public EnvelopeCreationResponse createEnvelopeAsSenderView(
			@RequestParam(value = "medicineName") String medicineName, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		logger.info("In UnitedPOCController.createEnvelopeAsSenderView()");
		String envelopeId = unitedPOCService.createRecipientEnvelopes(false, medicineName, true);

		EnvelopeCreationResponse envelopeResponse = new EnvelopeCreationResponse();
		envelopeResponse.setEnvelopeId(envelopeId);

		return envelopeResponse;
	}

	@RequestMapping(value = "/generateSenderView", method = RequestMethod.GET)
	public String generateSenderView(@RequestParam(value = "envelopeId") String envelopeId, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		logger.info("In UnitedPOCController.generateSenderView()");

		return "redirect:" + unitedPOCService.senderViewUrl(envelopeId);
	}

	@RequestMapping(value = "/createEnvelopeAsRecipientView", method = RequestMethod.POST)
	@ResponseBody
	public EnvelopeCreationResponse createEnvelopeAsRecipientView(
			@RequestParam(value = "medicineName") String medicineName, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		logger.info("In UnitedPOCController.createEnvelopeAsRecipientView()");

		String envelopeId = unitedPOCService.createRecipientEnvelopes(true, medicineName, false);

		EnvelopeCreationResponse envelopeResponse = new EnvelopeCreationResponse();
		envelopeResponse.setEnvelopeId(envelopeId);

		return envelopeResponse;
	}

	@RequestMapping(value = "/generateRecipientView", method = RequestMethod.GET)
	public String generateRecipientView(@RequestParam(value = "envelopeId") String envelopeId,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		logger.info("In UnitedPOCController.generateRecipientView()");

		return "redirect:" + unitedPOCService.recipientViewUrl(envelopeId);
	}

	@RequestMapping(value = "/createEnvelopeAsSystem", method = RequestMethod.POST)
	@ResponseBody
	public EnvelopeCreationResponse createEnvelopeAsSystem(@RequestParam(value = "medicineName") String medicineName,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		logger.info("In UnitedPOCController.createEnvelopeAsSystem()");

		String envelopeId = unitedPOCService.createRecipientEnvelopes(false, medicineName, false);

		EnvelopeCreationResponse envelopeResponse = new EnvelopeCreationResponse();
		envelopeResponse.setEnvelopeId(envelopeId);

		return envelopeResponse;
	}

	@RequestMapping(value = "/emeddedUnitedCallback", method = RequestMethod.GET)
	public String emeddedUnitedCallback(@RequestParam String envelopeId, @RequestParam String recipientName,
			@RequestParam String recipientEmail, @RequestParam String event, Model model) {

		logger.info("In UnitedPOCController.emeddedUnitedCallback()");

		model.addAttribute("callResponse", event);

		return "unitedcallback";
	}
}