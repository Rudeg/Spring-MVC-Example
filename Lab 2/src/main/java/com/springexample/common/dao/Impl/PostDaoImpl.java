package com.springexample.common.dao.Impl;

import com.springexample.common.dao.PostDao;
import com.springexample.common.model.Entity.Post;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl extends AbstractDaoImpl<Post, String> implements PostDao {

    protected PostDaoImpl() {
        super(Post.class);
    }

    @Override
    public void savePost(Post post) {
        saveOrUpdate(post);
    }

    @Override
    public Post getByID(Long id) {
        return (Post)getCurrentSession().get(Post.class, id);
    }

    @Override
    public List<Post> loadAllPost() {
        Criteria criteria = getCurrentSession().createCriteria(Post.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }
}
