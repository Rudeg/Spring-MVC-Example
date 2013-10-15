package com.springexample.common.dao;

import com.springexample.common.model.Entity.Comment;

import java.util.List;

public interface CommentDao extends AbstractDao<Comment, String> {
    void saveComment(Comment comment);
    Comment getByID(Long id);
    List<Comment> loadAllComments();

}
