package com.docusign.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.docusign.hackathon.db.model.DocuSignCredential;
import com.docusign.hackathon.db.model.DocuSignCredentialPK;

public interface DocuSignCredentialRepository extends CrudRepository<DocuSignCredential, DocuSignCredentialPK> {

}