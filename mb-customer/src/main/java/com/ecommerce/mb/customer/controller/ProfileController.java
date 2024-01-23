package com.ecommerce.mb.customer.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.ecommerce.mb.commons.exceptions.InvalidCredentialsException;
import com.ecommerce.mb.commons.models.entity.Address;
import com.ecommerce.mb.customer.models.request.EmailRequest;
import com.ecommerce.mb.customer.models.request.CommerceRequest;
import com.ecommerce.mb.customer.models.request.CustomerRequest;
import com.ecommerce.mb.customer.service.interfaces.ProfileService;
import jakarta.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/user/v1")
public class ProfileController {
    @Autowired
	private ProfileService service;
    
    @PutMapping(value = "update-image-profile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getImageProfile(@RequestHeader("profile-id") String profileId,
		@RequestPart MultipartFile imagen) throws FileNotFoundException, IOException, NumberFormatException, InvalidCredentialsException {
		return service.updateImageProfile(imagen,profileId);
	}
    
    @PutMapping(value = "update-adress", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateAdress(@RequestHeader("profile-id") String commerceId,
		@RequestBody Address adress) throws FileNotFoundException, IOException, NumberFormatException, InvalidCredentialsException {
		return service.updateAdress(adress,commerceId);
	}
    
    @PutMapping(value = "update-profile-customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProfileCustomer(@RequestHeader("profile-id") String profileId,
		@RequestBody CustomerRequest request) throws FileNotFoundException, IOException, NumberFormatException, InvalidCredentialsException {
		return service.updateProfileCustomer(request,profileId);
	}
    
    @PutMapping(value = "update-profile-commerce", produces = MediaType.APPLICATION_JSON_VALUE)
   	public ResponseEntity<?> updateProfileCommerce(@RequestHeader("profile-id") String profileId,
   		@RequestBody CommerceRequest request) throws FileNotFoundException, IOException, NumberFormatException, InvalidCredentialsException {
   		return service.updateProfileCommerce(request,profileId);
   	}

	@GetMapping(value = "get-profile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProfile(@RequestHeader("profile-id") String profileId) throws NumberFormatException, InvalidCredentialsException {
		return ResponseEntity.ok(service.getProfile(profileId));
	}

	@PutMapping(value = "update-email", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateEmail(@RequestHeader("profile-id") String profileId,
		@RequestBody EmailRequest request) throws NumberFormatException, InvalidCredentialsException {
		return service.updateEmail(request,profileId);
	}

	@PutMapping(value = "validate-email", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validateEmail(@RequestHeader("profile-id") String profileId,
			@RequestParam("code-email") @NotBlank String codeEmail, 
			@RequestParam("new-email")@NotBlank String newEmail)
		throws IOException, NumberFormatException, InvalidCredentialsException {
		return service.validateEmail(codeEmail, newEmail,profileId);
	}
	
}
