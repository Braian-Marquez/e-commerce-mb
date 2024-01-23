package com.ecommerce.mb.commerce.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.mb.commons.models.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("SELECT c FROM Category c WHERE c.name=?1")
	Optional<Category> findByName(String name);

}
