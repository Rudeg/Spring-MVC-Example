package com.springexample.common.service;

import com.springexample.common.model.Entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String userName);
    void saveUser(User user);
    User getById(Long id);
    void deleteUser(String userName);
    List<User> findUsers(String user);
}
