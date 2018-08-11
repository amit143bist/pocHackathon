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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.docusign.hackathon.connect.model.ArrayOfCustomField;
import com.docusign.hackathon.connect.model.ArrayOfFormDataXfdfField;
import com.docusign.hackathon.connect.model.CustomField;
import com.docusign.hackathon.connect.model.DocuSignEnvelopeInformation;
import com.docusign.hackathon.connect.model.EnvelopeStatus;
import com.docusign.hackathon.connect.model.EnvelopeStatusCode;
import com.docusign.hackathon.connect.model.FormData;
import com.docusign.hackathon.connect.model.FormDataXfdf;
import com.docusign.hackathon.connect.model.FormDataXfdfField;
import com.docusign.hackathon.connect.model.RecipientStatus;
import com.docusign.hackathon.db.model.EnvelopeDetails;
import com.docusign.hackathon.db.model.EnvelopeDetailsPK;
import com.docusign.hackathon.db.model.RecipientTabDetails;
import com.docusign.hackathon.domain.EnvelopeCreationResponse;
import com.docusign.hackathon.domain.EnvelopeInformationData;
import com.docusign.hackathon.domain.RecipientEnvelopeData;
import com.docusign.hackathon.domain.RecipientTabData;
import com.docusign.hackathon.repository.EnvelopeDetailsRepository;
import com.docusign.hackathon.repository.RecipientTabDetailsRepository;
import com.docusign.hackathon.service.UnitedPOCService;

@Controller
public class UnitedPOCController {

	@Autowired
	UnitedPOCService unitedPOCService;

	@Autowired
	EnvelopeDetailsRepository envelopeDetailsRepository;

	@Autowired
	RecipientTabDetailsRepository recipientTabDetailsRepository;

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

	@RequestMapping(value = "/unitedConnectPost", method = RequestMethod.POST)
	public String unitedConnectPost(@RequestParam(value = "envelopeId") String envelopeId, HttpServletRequest request,
			HttpServletResponse response, Model model, final RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("envelopeId", envelopeId);
		logger.info("In UnitedPOCController.unitedConnectPost()");

		return "redirect:unitedConnect";
	}

	@RequestMapping(value = "/unitedConnect", method = RequestMethod.GET)
	public String unitedConnect(@ModelAttribute("envelopeId") String envelopeId, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		logger.info("In UnitedPOCController.unitedConnect GET() " + envelopeId);

		model.addAttribute("envelopeId", envelopeId);

		return "unitedconnect";
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
		model.addAttribute("envelopeId", envelopeId);
		model.addAttribute("recipientName", recipientName);
		model.addAttribute("recipientEmail", recipientEmail);

		return "unitedcallback";
	}

	@RequestMapping(value = "/fetchSignedFormData", method = RequestMethod.GET)
	@ResponseBody
	public EnvelopeInformationData fetchSignedFormData(@RequestParam String envelopeId, Model model) {

		logger.info("In UnitedPOCController.fetchSignedFormData()");

		List<EnvelopeDetails> envelopeDetailsList = envelopeDetailsRepository
				.findByEnvelopeDetailsPK_EnvelopeId(UUID.fromString(envelopeId));

		EnvelopeInformationData envelopeInformationData = new EnvelopeInformationData();
		List<RecipientEnvelopeData> recipientEnvelopeDataList = new ArrayList<RecipientEnvelopeData>();

		if (null != envelopeDetailsList && !envelopeDetailsList.isEmpty()) {

			for (EnvelopeDetails envelopeDetails : envelopeDetailsList) {
				List<RecipientTabDetails> recipientTabDetailsList = recipientTabDetailsRepository
						.findByRecipientId(envelopeDetails.getRecipientUUID());

				RecipientEnvelopeData recipientEnvelopeData = new RecipientEnvelopeData();
				recipientEnvelopeData.setEnvelopeId(envelopeId);
				recipientEnvelopeData.setRecipientEmail(envelopeDetails.getEnvelopeDetailsPK().getRecipientEmail());
				recipientEnvelopeData.setRecipientName(envelopeDetails.getRecipientName());
				recipientEnvelopeData.setRecipientId(envelopeDetails.getRecipientUUID().toString());
				recipientEnvelopeData.setUsecaseName(envelopeDetails.getUsecaseName());

				List<RecipientTabData> recipientTabDataList = new ArrayList<RecipientTabData>();
				for (RecipientTabDetails recipientTabDetails : recipientTabDetailsList) {

					RecipientTabData recipientTabData = new RecipientTabData();

					recipientTabData.setTabName(recipientTabDetails.getTabName());
					recipientTabData.setTabValue(recipientTabDetails.getTabValue());

					recipientTabDataList.add(recipientTabData);

				}

				recipientEnvelopeData.setRecipientTabDataList(recipientTabDataList);
				recipientEnvelopeDataList.add(recipientEnvelopeData);
			}

			envelopeInformationData.setEnvelopeDataAvailable("Yes");
			envelopeInformationData.setRecipientEnvelopeDataList(recipientEnvelopeDataList);
		} else {
			envelopeInformationData.setEnvelopeDataAvailable("No");
		}

		return envelopeInformationData;
	}

	@RequestMapping(value = "/unitedConnect", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> unitedConnect(HttpServletRequest request,
			@RequestBody DocuSignEnvelopeInformation docuSignEnvelopeInformation) {

		logger.info("UnitedPOCController.unitedConnect() is " + Calendar.getInstance().getTime());

		if (null != docuSignEnvelopeInformation && null != docuSignEnvelopeInformation.getEnvelopeStatus()
				&& EnvelopeStatusCode.COMPLETED == docuSignEnvelopeInformation.getEnvelopeStatus().getStatus()) {

			EnvelopeStatus envelopeStatus = docuSignEnvelopeInformation.getEnvelopeStatus();
			List<RecipientStatus> recipientStatusList = envelopeStatus.getRecipientStatuses().getRecipientStatus();

			String usecaseNameValue = null;
			ArrayOfCustomField arrayOfCustomField = envelopeStatus.getCustomFields();
			List<CustomField> customFieldList = arrayOfCustomField.getCustomField();
			for (CustomField customField : customFieldList) {

				if ("UseCaseName".equalsIgnoreCase(customField.getName())) {
					usecaseNameValue = customField.getValue();
					break;
				}
			}

			String envelopeId = envelopeStatus.getEnvelopeID();
			String envelopeSubject = envelopeStatus.getSubject();

			for (RecipientStatus recipient : recipientStatusList) {

				UUID recipientUUID = UUID.fromString(recipient.getRecipientId());

				saveRecipientTabDetails(recipient, recipientUUID);

				saveEnvelopeDetails(usecaseNameValue, envelopeId, envelopeSubject, recipientUUID, recipient.getEmail(),
						recipient.getUserName());

			}

		}

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	/**
	 * @param recipient
	 * @param recipientUUID
	 */
	private void saveRecipientTabDetails(RecipientStatus recipient, UUID recipientUUID) {
		FormData formData = recipient.getFormData();

		FormDataXfdf formDataXfdf = formData.getXfdf();
		ArrayOfFormDataXfdfField arrayOfFormDataXfdfField = formDataXfdf.getFields();
		List<FormDataXfdfField> formDataXfdfFieldList = arrayOfFormDataXfdfField.getField();

		List<RecipientTabDetails> recipientTabDetailsList = new ArrayList<RecipientTabDetails>();
		for (FormDataXfdfField formDataXfdfField : formDataXfdfFieldList) {

			RecipientTabDetails recipientTabDetails = new RecipientTabDetails();
			recipientTabDetails.setRecipientId(recipientUUID);
			recipientTabDetails.setTabId(UUID.randomUUID());
			recipientTabDetails.setTabName(formDataXfdfField.getName());
			recipientTabDetails.setTabValue(formDataXfdfField.getValue());

			recipientTabDetailsList.add(recipientTabDetails);
		}

		logger.info("Saving recipientTabDetails in UnitedPOCController.saveRecipientTabDetails()");
		recipientTabDetailsRepository.save(recipientTabDetailsList);
	}

	/**
	 * @param usecaseNameValue
	 * @param envelopeId
	 * @param envelopeSubject
	 * @param recipient
	 * @param recipientEmail
	 * @param recipientName
	 */
	private void saveEnvelopeDetails(String usecaseNameValue, String envelopeId, String envelopeSubject,
			UUID recipientUUID, String recipientEmail, String recipientName) {

		EnvelopeDetailsPK envelopeDetailsPK = new EnvelopeDetailsPK();

		envelopeDetailsPK.setEnvelopeId(UUID.fromString(envelopeId));
		envelopeDetailsPK.setRecipientId(BigInteger.valueOf(System.currentTimeMillis()));
		envelopeDetailsPK.setRecipientEmail(recipientEmail);

		EnvelopeDetails envelopeDetails = new EnvelopeDetails();

		envelopeDetails.setEnvelopeDetailsPK(envelopeDetailsPK);
		envelopeDetails.setEnvelopeStatus(EnvelopeStatusCode.COMPLETED.value());
		envelopeDetails.setUsecaseName(usecaseNameValue);
		envelopeDetails.setRecipientUUID(recipientUUID);
		envelopeDetails.setRecipientName(recipientName);
		envelopeDetails.setEnvelopeSubject(envelopeSubject);

		logger.info("Saving envelopeDetails in UnitedPOCController.saveEnvelopeDetails()");
		envelopeDetailsRepository.save(envelopeDetails);
	}
}