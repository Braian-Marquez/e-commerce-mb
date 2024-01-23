package com.ecommerce.mb.commerce.service.interfaces;

import java.util.List;
import com.ecommerce.mb.commons.models.entity.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Category getCategoryById(Long categoryId);

	Object addCategory(Category category);

	boolean deleteCategory(Long categoryId);

}
