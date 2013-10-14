package com.springexample.common.controllers;

import com.springexample.common.model.Entity.Post;
import com.springexample.common.model.Entity.User;
import com.springexample.common.service.PostService;
import com.springexample.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String registration( @ModelAttribute("post") Post post, BindingResult result, Model m, Principal principal) {
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
