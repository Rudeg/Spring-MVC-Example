package com.springexample.common.service.Impl;

import com.springexample.common.dao.CommentDao;
import com.springexample.common.model.Entity.Comment;
import com.springexample.common.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commentService")
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    @Transactional(readOnly = false)
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }

    @Override
    public Comment getById(Long id) {
        return commentDao.getByID(id);
    }
}