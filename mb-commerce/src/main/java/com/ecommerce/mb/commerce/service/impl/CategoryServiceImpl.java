package com.ecommerce.mb.commerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.mb.commerce.models.repository.CategoryRepository;
import com.ecommerce.mb.commerce.service.interfaces.CategoryService;
import com.ecommerce.mb.commons.exceptions.NotFoundException;
import com.ecommerce.mb.commons.models.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(()->new NotFoundException("The category not exist."));
	}

	@Override
	public Object addCategory(Category category) {
		Optional<Category> entity=categoryRepository.findByName(category.getName());
		if(entity.isPresent()) {
			throw new NotFoundException("The category already exists.");
		}
		categoryRepository.save(category);
		return category;
	}

	@Override
	public boolean deleteCategory(Long categoryId) {
		Optional<Category> entity=categoryRepository.findById(categoryId);
		categoryRepository.delete(entity.get());
		return true;
	}

}
