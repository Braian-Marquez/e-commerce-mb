package com.ecommerce.mb.commerce.models.repository.criteria;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import com.ecommerce.mb.commons.models.entity.Product;
import com.ecommerce.mb.commons.utils.GenericPage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class ProductCriteria {
	
	 private final EntityManager entityManager;
		
		private final CriteriaBuilder criteriaBuilder;
		
		public ProductCriteria(EntityManager entityManager) {
			super();
			this.entityManager = entityManager;
			this.criteriaBuilder = entityManager.getCriteriaBuilder();
		}


		public Page<Product> findAllWithFiltersPageable(GenericPage page,
				ProductCriteriaSearch searchCriteria) {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Product> cq = cb.createQuery(Product.class);

			Root<Product> root = cq.from(Product.class);
			
			cq.select(root);
			Predicate predicate = getPredicatePageable(searchCriteria, root);
			cq.where(predicate);
			
			if (page.getSortDirection() == Sort.Direction.ASC) {
	            cq.orderBy(criteriaBuilder.asc(root.get("id")));
	        } else {
	            cq.orderBy(criteriaBuilder.desc(root.get("id")));
	        }
			
			TypedQuery<Product> list = entityManager.createQuery(cq);
			list.setFirstResult(page.getPageNumber() * page.getPageSize());
			list.setMaxResults(page.getPageSize());

			Pageable pageable = getPageable(page);
			long count = list.getResultList().size();

			return new PageImpl<>(list.getResultList(), pageable, count);
		}
		
		private Predicate getPredicatePageable(ProductCriteriaSearch searchCriteria, Root<Product> root) {
		    List<Predicate> predicates = new ArrayList<>();

		    if (searchCriteria.getProductId() != null) {
		        predicates.add(criteriaBuilder.equal(root.get("id"), searchCriteria.getProductId()));
		    }

		    if (searchCriteria.getCommerceId() != null) {
		        predicates.add(criteriaBuilder.equal(root.get("commerceId"), searchCriteria.getCommerceId()));
		    }

		    if (searchCriteria.getCategoryId() != null) {
		        predicates.add(criteriaBuilder.equal(root.get("category").get("id"), searchCriteria.getCategoryId()));
		    }

		    if (searchCriteria.getPrice() > 0) {
		        predicates.add(criteriaBuilder.equal(root.get("price"), searchCriteria.getPrice()));
		    }

		    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		}

		private Pageable getPageable(GenericPage page) {
			Sort sort = Sort.by(page.getSortDirection(), page.getSortBy());
			return PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);
		}

	}