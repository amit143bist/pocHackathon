package com.docusign.hackathon.db.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "googlecredential")
public class GoogleCredential {

	@EmbeddedId
	private GoogleCredentialPK googleCredentialPK;

	@Column(name = "refreshtoken")
	private String refreshToken;

	@Column(name = "accesstoken")
	private String accessToken;

	@Column(name = "tokentype")
	private String tokenType;

	@Column(name = "expiresin")
	private BigInteger expiresIn;
	
	public GoogleCredential() {
		super();
	}

	public GoogleCredentialPK getGoogleCredentialPK() {
		return googleCredentialPK;
	}

	public void setGoogleCredentialPK(GoogleCredentialPK googleCredentialPK) {
		this.googleCredentialPK = googleCredentialPK;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public BigInteger getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(BigInteger expiresIn) {
		this.expiresIn = expiresIn;
	}

}
