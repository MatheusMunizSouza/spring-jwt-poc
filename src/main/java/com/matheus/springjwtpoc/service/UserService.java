package com.matheus.springjwtpoc.service;

import com.matheus.springjwtpoc.domain.Role;
import com.matheus.springjwtpoc.domain.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
