package com.springexample.common.dao.Impl;

import com.springexample.common.dao.RoleDao;
import com.springexample.common.model.Entity.Role;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role, String> implements RoleDao {

    protected RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public void saveRole(Role role) {
        saveOrUpdate(role);
    }

    @Override
    public Role getByID(Long id) {
        return (Role)getCurrentSession().get(Role.class, id);
    }

    @Override
    public List<Role> findRoles(String roleTitle) {
        return findByCriteria(Restrictions.like("authority", roleTitle, MatchMode.START));
    }
}
