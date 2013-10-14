package com.springexample.common.dao;

import com.springexample.common.model.Entity.Post;

import java.util.List;

public interface PostDao extends AbstractDao<Post, String> {
    void savePost(Post user);
    Post getByID(Long id);
    List<Post> loadAllPost();
}
