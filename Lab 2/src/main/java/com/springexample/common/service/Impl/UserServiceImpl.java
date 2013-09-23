package com.springexample.common.service.Impl;

import com.springexample.common.dao.UserDao;
import com.springexample.common.model.Entity.User;
import com.springexample.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserName(String userName) {
        return userDao.findById(userName);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getByID(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(String userName) {
        User user = userDao.findById(userName);
        if (user != null) {
            userDao.delete(user);
        }
    }

    @Override
    public List<User> findUsers(String user) {
        return userDao.findUsers(user);
    }
}
