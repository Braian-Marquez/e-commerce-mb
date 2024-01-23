package com.ecommerce.mb.commerce.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.mb.commons.models.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
