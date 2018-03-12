package com.docusign.hackathon.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.docusign.hackathon.model.OAuthTokenData;
import com.docusign.hackathon.util.HackathonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DSAuthService {

	@Autowired
	HackathonUtil hackathonUtil;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Value("${heroku.docusign.api.clientid}")
	private String clientId;
	
	@Value("${heroku.docusign.api.secretkey}")
	String secretKey;
	
	@Value("${heroku.docusign.api.authbaseuri}")
	String authBaseUri;

	private static final Logger logger = LogManager.getLogger(DSAuthService.class);

	/**
	 * @param scopes
	 * @param state
	 * @param redirectUri
	 * @param clientId
	 * @param authBaseUri
	 * @param withPrompt
	 * @return
	 */
	public String getAuthCodeGrantUrl(String[] scopes, String state, String redirectUri, boolean withPrompt) {

		StringBuilder builder = new StringBuilder();
		for (String scope : scopes) {
			builder.append(scope);
			builder.append(" ");
		}

		String authCodeGrantUrl = authBaseUri + "oauth/auth?response_type=code&scope=" + builder.toString()
				+ "&client_id=" + clientId + "&redirect_uri=" + redirectUri;

		if (withPrompt) {
			authCodeGrantUrl = authCodeGrantUrl + "&prompt=login";
		}

		if (!StringUtils.isEmpty(state)) {
			authCodeGrantUrl = authCodeGrantUrl + "&state=" + state;
		}

		return authCodeGrantUrl;
	}

	public OAuthTokenData getASAccessTokenUsingAuthCode(String authCode) {

		String msgBody = "grant_type=authorization_code&code=" + authCode;
		OAuthTokenData oAuthTokenData = invokeApi(OAuthTokenData.class, msgBody, "oauth/token", HttpMethod.POST);

		return oAuthTokenData;
	}

	public OAuthTokenData getASAccessTokenUsingRefreshToken(String refreshToken) {
		String msgBody = "grant_type=refresh_token&refresh_token=" + refreshToken;
		OAuthTokenData oAuthTokenData = invokeApi(OAuthTokenData.class, msgBody, "oauth/token", HttpMethod.POST);

		return oAuthTokenData;
	}

	/**
	 * @param returnType
	 * @param msgBody
	 * @param uri
	 * @param httpMethod
	 * @return T
	 * @throws ApiException
	 */
	public <T> T invokeApi(Class<T> returnType, String msgBody, String uri, HttpMethod httpMethod) {

		try {
			ResponseEntity<T> callResp = null;

			HttpHeaders httpHeaders = getHeaders();
			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody, httpHeaders);

			String fullURIPath = authBaseUri + uri;

			logger.debug("requestEntity in DSAuthService.invokeApi()" + requestEntity);

			callResp = restTemplate.exchange(fullURIPath, httpMethod, requestEntity, returnType);

			int statusCodeValue = callResp.getStatusCodeValue();
			if (200 == statusCodeValue || 201 == statusCodeValue || 204 == statusCodeValue) {
				return callResp.getBody();
			}

		} catch (Exception e) {

			e.printStackTrace();
			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				logger.error(exp.getResponseBodyAsString());
				logger.error(exp.getMostSpecificCause());
			}

		}

		return null;
	}

	/**
	 * @param accept
	 * @param contentType
	 * @param auth
	 * @return httpHeaders
	 */
	private HttpHeaders getHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		httpHeaders.add("Authorization", "Basic " + hackathonUtil.getEncodedBase64Data(clientId + ":" + secretKey));

		return httpHeaders;
	}
}