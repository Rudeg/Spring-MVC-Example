package com.springexample.common.service;

import com.springexample.common.model.Entity.Comment;

public interface CommentService {
    void saveComment(Comment comment);
    Comment getById(Long id);
}
