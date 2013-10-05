package com.springexample.common.controllers;

import com.springexample.common.model.Entity.User;
import javax.validation.Valid;

import com.springexample.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView model = new ModelAndView("registration", "user", new User());

        model.addObject("programmingLanguageList", initProgramLang());
        model.addObject("countryMap", initCountry());

        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model m) {
        if (result.hasErrors()) {

            //add objects to model
            m.addAttribute("programmingLanguageList", initProgramLang());
            m.addAttribute("countryMap", initCountry());

            return "registration";
        }
        userService.saveUser(user);
        return "main";
    }

    private List<String> initProgramLang() {
        List<String> programmingLanguagesList = new ArrayList<String>();

        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("C#");
        programmingLanguagesList.add("C++");
        programmingLanguagesList.add("Javascript");
        programmingLanguagesList.add("PHP");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("Ruby");

        return programmingLanguagesList;
    }

    private Map<String,String> initCountry() {
        Map<String,String> country = new LinkedHashMap<String,String>();

        country.put("US", "United Stated");
        country.put("RU", "Russia");
        country.put("UK", "United Kingdom");
        country.put("UA", "Ukraine");

        return country;
    }
}