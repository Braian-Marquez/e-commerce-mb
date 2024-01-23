package com.ecommerce.mb.auth.models.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ecommerce.mb.commons.models.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT d FROM Customer d where d.idUser=?1")
	Optional<Customer> getByUserId(Long userId);
	
	@Query("SELECT d FROM Customer d where d.dni=?1")
	Optional<Customer> findByDni(String dni);
	
}
