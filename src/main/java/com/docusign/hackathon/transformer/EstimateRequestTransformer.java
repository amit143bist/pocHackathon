package com.docusign.hackathon.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.docusign.hackathon.model.EstimateInfo;
import com.docusign.hackathon.model.EstimateRequest;

@Service
public class EstimateRequestTransformer {

	public List<EstimateRequest> transformToEstimateRequest(EstimateInfo estimateInfo, MultipartFile... files) {

		EstimateRequest estimateRequest = new EstimateRequest();

		estimateRequest.setMultiPartFileList(Arrays.asList(files));
		estimateRequest.setRecipientInfoList(estimateInfo.getRecipientInfoList());
		estimateRequest.setInlineTemplateSequenceNumber(estimateInfo.getInlineTemplateSequenceNumber());
		estimateRequest.setUseCaseName(estimateInfo.getUseCaseName());
		estimateRequest.setRequestorEmail(estimateInfo.getRequestorEmail());

		List<EstimateRequest> estimateRequestList = new ArrayList<EstimateRequest>();
		estimateRequestList.add(estimateRequest);

		return estimateRequestList;
	}
}