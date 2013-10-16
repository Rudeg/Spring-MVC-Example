package com.springexample.common.dao;

import com.springexample.common.model.Entity.Role;

import java.util.List;

public interface RoleDao extends AbstractDao<Role, String> {
    void saveRole(Role role);
    Role getByID(Long id);
    List<Role> findRoles(String roleTitle);
}
