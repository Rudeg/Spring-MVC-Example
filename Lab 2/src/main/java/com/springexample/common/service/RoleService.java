package com.springexample.common.service;

import com.springexample.common.model.Entity.Role;

import java.util.List;

public interface RoleService {

    Role findByRoleTitle(String roleName);
    void saveRole(Role role);
    Role getById(Long id);
    void deleteRole(String roleName);
    List<Role> findRoles(String roleTitle);
}
