package com.springexample.common.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.math.BigInteger;

import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "redirect:main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(Principal principal) {
        ModelAndView model = new ModelAndView("main");
        String name = principal.getName();
        model.addObject("username", name);

        return model;
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public ModelAndView addPost(Principal principal) {
        ModelAndView model = new ModelAndView("addPost");
        String name = principal.getName();
        model.addObject("username", name);

        return model;
    }


}
