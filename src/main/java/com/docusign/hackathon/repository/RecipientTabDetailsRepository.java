package com.docusign.hackathon.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.docusign.hackathon.db.model.RecipientTabDetails;

public interface RecipientTabDetailsRepository extends CrudRepository<RecipientTabDetails, UUID> {

	List<RecipientTabDetails> findByRecipientId(UUID recipientId);
}