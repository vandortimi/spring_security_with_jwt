package com.practice.jwt.simpleway.repository;

import com.practice.jwt.simpleway.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}

