package com.springexample.common.controllers;

import com.springexample.common.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView testMethod() {
        return new ModelAndView("index", "command", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView  registration(@ModelAttribute("index") User user, BindingResult result) {
        return new ModelAndView("main","user", user);
    }
}
