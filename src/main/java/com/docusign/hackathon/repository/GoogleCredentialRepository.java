package com.docusign.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.docusign.hackathon.db.model.GoogleCredential;
import com.docusign.hackathon.db.model.GoogleCredentialPK;

public interface GoogleCredentialRepository extends CrudRepository<GoogleCredential, GoogleCredentialPK> {

}