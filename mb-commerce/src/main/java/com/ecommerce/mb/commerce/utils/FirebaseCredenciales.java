package com.ecommerce.mb.commerce.utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class FirebaseCredenciales {
	
	@Value("${firebase.TYPE}")
	private String TYPE;

	@Value("${firebase.PROJECT_ID}")
	private String PROJECT_ID;

	@Value("${firebase.PROJECT_KEY_ID}")
	private String PROJECT_KEY_ID;

	@Value("${firebase.PROJECT_KEY}")
	private String PROJECT_KEY;

	@Value("$firebase.CLIENT_ID}")
	private String CLIENT_ID;
	
	@Value("${firebase.CLIENT_EMAIL}")
	private String CLIENT_EMAIL;
	
	@Value("${firebase.AUTH_URI}")
	private String AUTH_URI;
	
	@Value("${firebase.TOKEN_URI}")
	private String TOKEN_URI;

	@Value("${firebase.AUTH_PROVIDER_X509_CERT_URL}")
	private String AUTH_PROVIDER_X509_CERT_URL;
	
	@Value("${firebase.CLIENT_X509_CERT_URL}")
	private String CLIENT_X509_CERT_URL;
	
	@Value("${firebase.UNIVERSE_DOMAIN}")
	private String UNIVERSE_DOMAIN;
	
	 public JsonNode getCredenciales() {
	        ObjectNode jsonNode = JsonNodeFactory.instance.objectNode();

	        jsonNode.put("type", TYPE);
	        jsonNode.put("project_id", PROJECT_ID);
	        jsonNode.put("private_key_id", PROJECT_KEY_ID);
	        jsonNode.put("private_key", PROJECT_KEY);
	        jsonNode.put("client_email", CLIENT_EMAIL);
	        jsonNode.put("client_id", CLIENT_ID);
	        jsonNode.put("auth_uri", AUTH_URI);
	        jsonNode.put("token_uri", TOKEN_URI);
	        jsonNode.put("auth_provider_x509_cert_url", AUTH_PROVIDER_X509_CERT_URL);
	        jsonNode.put("client_x509_cert_url", CLIENT_X509_CERT_URL);
	        jsonNode.put("universe_domain", UNIVERSE_DOMAIN);

	        return jsonNode;
	 }
}
