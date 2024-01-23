package com.ecommerce.mb.commerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ecommerce.mb.commerce.models.repository.criteria.ProductCriteria;
import com.ecommerce.mb.commerce.models.repository.criteria.ProductCriteriaSearch;
import com.ecommerce.mb.commerce.service.interfaces.FindProductService;
import com.ecommerce.mb.commons.models.entity.Product;
import com.ecommerce.mb.commons.utils.GenericPage;

@Service
public class FindProductServiceImpl implements FindProductService{
	
	@Autowired
	private ProductCriteria criteria;
	
	@Override
	public Page<Product> findAllWithFiltersPageable(GenericPage page, ProductCriteriaSearch searchCriteria) {
		 return criteria.findAllWithFiltersPageable(page, searchCriteria);
     }


}
