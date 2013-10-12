package com.springexample.common.dao;

import com.springexample.common.model.Entity.Post;

public interface PostDao extends AbstractDao<Post, String> {
    void savePost(Post user);
    Post getByID(Long id);
}
