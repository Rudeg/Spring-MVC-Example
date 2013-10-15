package com.springexample.common.controllers;

import com.springexample.common.model.Entity.Comment;
import com.springexample.common.model.Entity.Post;
import com.springexample.common.model.Entity.User;
import com.springexample.common.service.CommentService;
import com.springexample.common.service.PostService;
import com.springexample.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "redirect:main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(Principal principal) {
        ModelAndView model = new ModelAndView("main");
        String name = principal.getName();
        model.addObject("username", name);

        List<Post> postList = postService.findAll();
        if(postList != null)
            model.addObject("posts", postList);

        return model;
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public ModelAndView addPost(Principal principal) {

        ModelAndView model = new ModelAndView("addPost", "post", new Post());
        String name = principal.getName();
        model.addObject("username", name);

        return model;
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment( @ModelAttribute("comment") Comment comment,
                           @RequestParam(required = false, value = "postId") String postId,
                           Model m, Principal principal) {
        String name = principal.getName();
        m.addAttribute("username", name);
        //set user to post
        User user = userService.findByUserName(name);
        comment.setUser(user);
        //update user posts
        Post post = postService.getById(Long.parseLong(postId));
        comment.setPost(post);

        Set<Comment> postComments = post.getComments();
        if(postComments == null) {
            postComments = new HashSet<Comment>();
        }
        postComments.add(comment);
        post.setComments(postComments);

        commentService.saveComment(comment);
        postService.savePost(post);

        return "redirect:/post/" + post.getId();
    }


    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView post(@PathVariable String id, Principal principal) {
        ModelAndView model = new ModelAndView("post");
        String name = principal.getName();
        model.addObject("username", name);

        Post post = postService.getById(Long.parseLong(id));
        if(post != null) {
            model.addObject("post", post);
        }

        return model;
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addComment( @ModelAttribute("post") Post post, BindingResult result, Model m, Principal principal) {
        String name = principal.getName();
        m.addAttribute("username", name);
        //set user to post
        User user = userService.findByUserName(name);
        post.setUser(user);
        //update user posts
        Set<Post> userPosts = user.getPosts();
        if(userPosts == null) {
            userPosts = new HashSet<Post>();
        }
        userPosts.add(post);
        user.setPosts(userPosts);

        userService.saveUser(user);
        postService.savePost(post);

        return "redirect:/main";
    }



}
