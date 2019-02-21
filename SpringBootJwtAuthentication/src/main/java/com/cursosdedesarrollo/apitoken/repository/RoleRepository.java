package com.cursosdedesarrollo.apitoken.repository;

import java.util.Optional;

import com.cursosdedesarrollo.apitoken.model.Role;
import com.cursosdedesarrollo.apitoken.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}