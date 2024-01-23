package com.ecommerce.mb.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import com.ecommerce.mb.commerce.models.repository.criteria.ProductCriteriaSearch;
import com.ecommerce.mb.commerce.service.interfaces.FindProductService;
import com.ecommerce.mb.commons.exceptions.NotFoundException;
import com.ecommerce.mb.commons.models.entity.Product;
import com.ecommerce.mb.commons.utils.GenericPage;

@Validated
@RestController
@RequestMapping("/public/v1")
public class FindProductsController {

	@Autowired
	private FindProductService service;

	@GetMapping("get-all-products")
	public ResponseEntity<?> getAllProducts(@RequestParam(value = "page-number") int pageNumber,
			@RequestParam(value = "page-size") int pageSize,
			@RequestParam(value = "sort-direction") String sortDirection,
			@RequestParam(required = false, value = "product-id") Long productId,
			@RequestParam(required = false, value = "commerce-id") Long commerceId,
			@RequestParam(required = false, value = "category-id") Long categoryId,
			@RequestParam(required = false, value = "price") Double price) {
		try {
			ProductCriteriaSearch searchCriteria = new ProductCriteriaSearch();
			if (productId != null) {
				searchCriteria.setProductId(productId);
			}
			if (commerceId != null) {
				searchCriteria.setCommerceId(commerceId);
			}

			if (categoryId != null) {
				searchCriteria.setCategoryId(categoryId);
			}
			if (price != null) {
				searchCriteria.setPrice(price);
			}
			GenericPage page = new GenericPage();
			page.setPageNumber(pageNumber);
			page.setPageSize(pageSize);
			page.setSortDirection(Sort.Direction.valueOf(sortDirection));
			Page<Product> pagereturn = service.findAllWithFiltersPageable(page, searchCriteria);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pagereturn);
		} catch (Exception ex) {
			throw new NotFoundException(ex.getMessage());
		}
	}

}
