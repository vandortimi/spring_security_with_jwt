package com.practice.jwt.simpleway;

import com.practice.jwt.simpleway.domain.AppUser;
import com.practice.jwt.simpleway.domain.Role;
import com.practice.jwt.simpleway.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService appUserService) {
        return args -> {
            appUserService.saveRole(new Role(null, "ROLE_USER"));
            appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            appUserService.saveUser(new AppUser(null, "John Doe", "john", "test1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "Steve Doe", "steve", "test1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "Jim Doe", "jim", "test1234", new ArrayList<>()));

            appUserService.addRoleToAppUser("john", "ROLE_USER");
            appUserService.addRoleToAppUser("john", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToAppUser("jim", "ROLE_MANAGER");
            appUserService.addRoleToAppUser("steve", "ROLE_USER");
            appUserService.addRoleToAppUser("steve", "ROLE_ADMIN");
        };
    }

}
