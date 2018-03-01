package com.docusign.hackathon.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GoogleCredentialPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3065195065567370620L;
	
	@Column(name = "googleemail")
	private String googleEmail;
	
	@Column(name = "applicationname")
	private String applicationName;

	public String getGoogleEmail() {
		return googleEmail;
	}

	public void setGoogleEmail(String googleEmail) {
		this.googleEmail = googleEmail;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
