package com.springexample.common.service.Impl;

import com.springexample.common.dao.PostDao;
import com.springexample.common.model.Entity.Post;
import com.springexample.common.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("postService")
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    @Transactional(readOnly = false)
    public void savePost(Post post) {
        postDao.savePost(post);
    }

    @Override
    public Post getById(Long id) {
        return postDao.getByID(id);
    }

    @Override
    public List<Post> findAll() {
        return postDao.loadAllPost();
    }
}