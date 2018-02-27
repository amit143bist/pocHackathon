package com.docusign.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

@SpringBootApplication
public class ProServHackathon2018Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProServHackathon2018Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProServHackathon2018Application.class);
	}

	@Bean(name = "restTemplate")
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		RestTemplate REST_TEMPLATE = builder.build();

		return REST_TEMPLATE;
	}

	@Bean(name = "objectMapper")
	public ObjectMapper objectMapper() {

		ObjectMapper OBJECT_MAPPER = Jackson2ObjectMapperBuilder.json().build();
		return OBJECT_MAPPER;
	}

	@Bean(name = "httpTransport")
	public HttpTransport HttpTransport() {

		HttpTransport HTTP_TRANSPORT = null;
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}

		return HTTP_TRANSPORT;
	}

	@Bean(name = "jsonFactory")
	public JsonFactory JsonFactory() {
		
		JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

		return JSON_FACTORY;
	}
}