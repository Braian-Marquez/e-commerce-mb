package com.ecommerce.mb.commerce.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.mb.commerce.service.interfaces.CategoryService;
import com.ecommerce.mb.commons.exceptions.InvalidCredentialsException;
import com.ecommerce.mb.commons.models.entity.Category;

@Validated
@RestController
@RequestMapping("/admin/v1")
public class AdminController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("add-category")
	public ResponseEntity<?> addCategory(@RequestBody Category category)
			throws NumberFormatException, InvalidCredentialsException, FileNotFoundException, IOException {
		return ResponseEntity.ok(categoryService.addCategory(category));
	}

	@DeleteMapping("delete-category")
	public ResponseEntity<?> deleteCategory(@RequestParam("category-id") Long categoryId)
			throws NumberFormatException, InvalidCredentialsException {
		boolean deleted = categoryService.deleteCategory(categoryId);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(deleted);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
