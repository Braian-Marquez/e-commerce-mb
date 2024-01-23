package com.ecommerce.mb.commerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.mb.commerce.service.interfaces.CategoryService;
import com.ecommerce.mb.commons.models.entity.Category;

@Validated
@RestController
@RequestMapping("/public/v1")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;

  
    @GetMapping("get-all-categories")
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("get-id")
    public ResponseEntity<?> getCategoryById(@RequestParam Long categoryId) {
    	Category category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
