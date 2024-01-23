package com.ecommerce.mb.commerce.service.interfaces;

import org.springframework.data.domain.Page;

import com.ecommerce.mb.commerce.models.repository.criteria.ProductCriteriaSearch;
import com.ecommerce.mb.commons.models.entity.Product;
import com.ecommerce.mb.commons.utils.GenericPage;

public interface FindProductService {

	Page<Product> findAllWithFiltersPageable(GenericPage page, ProductCriteriaSearch searchCriteria);

}
