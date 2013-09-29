package com.springexample.common.dao.Impl;

import com.springexample.common.dao.UserDao;
import com.springexample.common.model.Entity.User;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, String> implements UserDao {

    protected UserDaoImpl() {
        super(User.class);
    }

    @Override
    public void saveUser(User user) {
        saveOrUpdate(user);
    }

    @Override
    public User getByID(Long id) {
        return (User)getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findUsers(String userName) {
        return findByCriteria(Restrictions.like("username", userName, MatchMode.START));
    }
}
