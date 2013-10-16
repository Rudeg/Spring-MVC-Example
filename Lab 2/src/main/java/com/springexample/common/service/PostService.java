package com.springexample.common.service;

import com.springexample.common.model.Entity.Post;

import java.util.List;

public interface PostService {
    void savePost(Post post);
    Post getById(Long id);
    List<Post> findAll();
}
