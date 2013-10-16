package com.springexample.common.service;

import com.springexample.common.model.Entity.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(Comment comment);
    Comment getById(Long id);
    List<Comment> findAll();

}
