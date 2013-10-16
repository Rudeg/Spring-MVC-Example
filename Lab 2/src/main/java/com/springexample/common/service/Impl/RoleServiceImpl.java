package com.springexample.common.service.Impl;

import com.springexample.common.dao.RoleDao;
import com.springexample.common.model.Entity.Role;
import com.springexample.common.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByRoleTitle(String userName) {
        return roleDao.findById(userName);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveRole(Role role) {
        roleDao.saveOrUpdate(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getByID(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteRole(String roleTitle) {
        Role role = roleDao.findById(roleTitle);
        if (role != null) {
            roleDao.delete(role);
        }
    }

    @Override
    public List<Role> findRoles(String roleTitle) {
        return roleDao.findRoles(roleTitle);
    }
}
