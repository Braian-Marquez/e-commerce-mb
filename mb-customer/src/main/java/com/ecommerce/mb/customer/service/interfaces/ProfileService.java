package com.ecommerce.mb.customer.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.mb.commons.models.entity.Address;
import com.ecommerce.mb.customer.models.request.EmailRequest;
import com.ecommerce.mb.customer.models.request.CommerceRequest;
import com.ecommerce.mb.customer.models.request.CustomerRequest;
import jakarta.validation.constraints.NotBlank;

public interface ProfileService {

	ResponseEntity<?> updateImageProfile(MultipartFile imagen, String customerId);

	Object getProfile(String customerId);

	ResponseEntity<?> updateEmail(EmailRequest request, String customerId);

	ResponseEntity<?> validateEmail(@NotBlank String codeEmail, @NotBlank String newEmail, String customerId);

	ResponseEntity<?> updateAdress(Address adress, String customerId);

	ResponseEntity<?> updateProfileCustomer(CustomerRequest request, String profileId);

	ResponseEntity<?> updateProfileCommerce(CommerceRequest request, String profileId);

}