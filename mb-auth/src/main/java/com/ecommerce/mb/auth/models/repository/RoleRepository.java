package com.ecommerce.mb.auth.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.mb.auth.models.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
