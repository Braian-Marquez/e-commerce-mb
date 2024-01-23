package com.ecommerce.mb.auth.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ecommerce.mb.auth.models.entity.UserEntity;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	@Query("SELECT u FROM UserEntity u WHERE u.email=?1")
	Optional<UserEntity> findByUsername(String username);
	
	@Query("SELECT u FROM UserEntity u WHERE u.email=?1")
	Optional<UserEntity> findByEmail(String email);


}
