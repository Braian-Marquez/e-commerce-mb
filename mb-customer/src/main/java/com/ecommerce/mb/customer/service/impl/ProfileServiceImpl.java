package com.ecommerce.mb.customer.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.mb.commons.models.entity.Address;
import com.ecommerce.mb.customer.models.request.EmailRequest;
import com.ecommerce.mb.customer.models.request.CommerceRequest;
import com.ecommerce.mb.customer.models.request.CustomerRequest;
import com.ecommerce.mb.customer.service.interfaces.ProfileService;
import jakarta.validation.constraints.NotBlank;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Override
	public ResponseEntity<?> updateImageProfile(MultipartFile imagen, String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProfile(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateEmail(EmailRequest request, String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> validateEmail(@NotBlank String codeEmail, @NotBlank String newEmail, String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateAdress(Address adress, String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateProfileCustomer(CustomerRequest request, String profileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateProfileCommerce(CommerceRequest request, String profileId) {
		// TODO Auto-generated method stub
		return null;
	}



}
