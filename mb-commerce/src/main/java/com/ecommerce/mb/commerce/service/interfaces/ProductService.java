package com.ecommerce.mb.commerce.service.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.mb.commerce.models.request.ProductRequest;
import com.ecommerce.mb.commons.exceptions.InvalidCredentialsException;

public interface ProductService {

	Object addProduct(ProductRequest product, String profileId, List<MultipartFile> image) throws NumberFormatException, InvalidCredentialsException, FileNotFoundException, IOException;

	Object updateProduct(String profileId, Long productId, ProductRequest product, List<MultipartFile> image) throws FileNotFoundException, IOException, NumberFormatException, InvalidCredentialsException;

	boolean deleteProduct(String profileId, Long productId) throws NumberFormatException, InvalidCredentialsException;

}
