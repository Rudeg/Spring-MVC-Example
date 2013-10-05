package com.springexample.common.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "index";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout() {
        return "index";
    }
}
