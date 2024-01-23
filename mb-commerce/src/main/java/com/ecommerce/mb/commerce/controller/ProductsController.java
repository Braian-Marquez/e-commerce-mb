package com.ecommerce.mb.commerce.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.mb.commerce.models.request.ProductRequest;
import com.ecommerce.mb.commerce.service.interfaces.ProductService;
import com.ecommerce.mb.commons.exceptions.InvalidCredentialsException;

@Validated
@RestController
@RequestMapping("/commerce/v1")
public class ProductsController {
	
	    @Autowired
	    private ProductService productService;

	   
	    @PostMapping("add-product")
	    public ResponseEntity<?> addProduct(@RequestHeader("profile-id") String profileId,
	    		@RequestBody ProductRequest product,
	    		@RequestPart List<MultipartFile> image) throws NumberFormatException, InvalidCredentialsException, FileNotFoundException, IOException {
	        return ResponseEntity.ok(productService.addProduct(product,profileId,image));
	    }

	 
	    @PutMapping("update-product")
	    public ResponseEntity<?> updateProduct(@RequestHeader("profile-id") String profileId,
	    		@RequestParam Long productId,
	    		@RequestBody ProductRequest product,
	    		@RequestPart List<MultipartFile> image) throws FileNotFoundException, IOException, NumberFormatException, InvalidCredentialsException {
	        if (product != null) {
	            return ResponseEntity.ok(productService.updateProduct(profileId, productId,product,image));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("delete-product")
	    public ResponseEntity<?> deleteProduct(@RequestHeader("profile-id") String profileId,
	    		@RequestParam Long productId) throws NumberFormatException, InvalidCredentialsException {
	        boolean deleted = productService.deleteProduct(profileId,productId);
	        if (deleted) {
	        	return ResponseEntity.status(HttpStatus.ACCEPTED).body(deleted);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
