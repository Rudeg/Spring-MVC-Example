package com.springexample.common.dao;

import com.springexample.common.model.Entity.Comment;

public interface CommentDao extends AbstractDao<Comment, String> {
    void saveComment(Comment comment);
    Comment getByID(Long id);
}
