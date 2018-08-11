package com.docusign.hackathon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.docusign.hackathon.db.model.EnvelopeDetails;
import com.docusign.hackathon.db.model.EnvelopeDetailsPK;

public interface EnvelopeDetailsRepository extends CrudRepository<EnvelopeDetails, EnvelopeDetailsPK> {

	List<EnvelopeDetails> findByEnvelopeDetailsPK_RecipientEmailAndEnvelopeStatus(String recipientEmail,
			String envelopeStatus);
	
	List<EnvelopeDetails> findByEnvelopeDetailsPK_EnvelopeId(String envelopeId);
}