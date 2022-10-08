package com.practice.jwt.simpleway.service;

import com.practice.jwt.simpleway.domain.AppUser;
import com.practice.jwt.simpleway.domain.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser appUser);

    Role saveRole(Role role);

    void addRoleToAppUser(String username, String roleName);

    AppUser getAppUser(String username);

    List<AppUser> getAppUsers();

}
