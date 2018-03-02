package com.docusign.hackathon.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocuSignCredentialPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7831975144382501802L;

	@Column(name = "docusignemail")
	private String docuSignEmail;
	
	@Column(name = "applicationname")
	private String applicationName;

	public String getDocuSignEmail() {
		return docuSignEmail;
	}

	public void setDocuSignEmail(String docuSignEmail) {
		this.docuSignEmail = docuSignEmail;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationName == null) ? 0 : applicationName.hashCode());
		result = prime * result + ((docuSignEmail == null) ? 0 : docuSignEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocuSignCredentialPK other = (DocuSignCredentialPK) obj;
		if (applicationName == null) {
			if (other.applicationName != null)
				return false;
		} else if (!applicationName.equals(other.applicationName))
			return false;
		if (docuSignEmail == null) {
			if (other.docuSignEmail != null)
				return false;
		} else if (!docuSignEmail.equals(other.docuSignEmail))
			return false;
		return true;
	}
}