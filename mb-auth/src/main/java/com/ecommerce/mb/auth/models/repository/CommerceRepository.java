package com.ecommerce.mb.auth.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.mb.commons.models.entity.Commerce;

public interface CommerceRepository extends JpaRepository<Commerce,Long>{
	@Query("SELECT d FROM Commerce d where d.cuit=?1")
	Optional<Commerce> findByCuit(String cuit);

}
