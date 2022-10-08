package com.practice.jwt.simpleway.repository;

import com.practice.jwt.simpleway.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

}
