package com.springexample.common.dao.Impl;

import com.springexample.common.dao.CommentDao;
import com.springexample.common.model.Entity.Comment;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Comment, String> implements CommentDao {

    protected CommentDaoImpl() {
        super(Comment.class);
    }

    @Override
    public void saveComment(Comment comment) {
        saveOrUpdate(comment);
    }

    @Override
    public Comment getByID(Long id) {
        return (Comment)getCurrentSession().get(Comment.class, id);
    }

    @Override
    public List<Comment> loadAllComments() {
        Criteria criteria = getCurrentSession().createCriteria(Comment.class);
        return criteria.list();
    }
}
