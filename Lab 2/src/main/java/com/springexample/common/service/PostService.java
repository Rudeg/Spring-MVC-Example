package com.springexample.common.service;

import com.springexample.common.model.Entity.Post;

public interface PostService {
    void savePost(Post post);
    Post getById(Long id);
}
