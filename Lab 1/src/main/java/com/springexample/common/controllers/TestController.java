package com.springexample.common.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String testMethod(ModelMap model) {
        model.addAttribute("message", "Test message is here");
        return "index";
    }

}
