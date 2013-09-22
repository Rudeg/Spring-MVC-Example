package com.springexample.common.controllers;

import com.springexample.common.model.Entity.User;
import javax.validation.Valid;

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
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView testFormMethod() {
        ModelAndView model = new ModelAndView("index", "user", new User());

        return FillSignUpModelAndView(model);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model m) {
        if (result.hasErrors()) {
            //country map
            Map<String,String> country = new LinkedHashMap<String,String>();
            country.put("US", "United Stated");
            country.put("RU", "Russia");
            country.put("UK", "United Kingdom");
            country.put("UA", "Ukraine");

        //programming languages list
        List<String> programmingLanguagesList = new ArrayList<String>();
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("C#");
        programmingLanguagesList.add("C++");
        programmingLanguagesList.add("Javascript");
        programmingLanguagesList.add("PHP");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("Ruby");
        //add objects to model
        m.addAttribute("programmingLanguageList", programmingLanguagesList);
        m.addAttribute("countryMap", country);
            return "index";//return FillSignUpModelAndView(new ModelAndView("index", "user", user));
        }
        return "main";//return new ModelAndView("main","user", user);
    }

    private ModelAndView FillSignUpModelAndView(ModelAndView model)
    {
        //country map
        Map<String,String> country = new LinkedHashMap<String,String>();
        country.put("US", "United Stated");
        country.put("RU", "Russia");
        country.put("UK", "United Kingdom");
        country.put("UA", "Ukraine");

        //programming languages list
        List<String> programmingLanguagesList = new ArrayList<String>();
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("C#");
        programmingLanguagesList.add("C++");
        programmingLanguagesList.add("Javascript");
        programmingLanguagesList.add("PHP");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("Ruby");
        //add objects to model
        model.addObject("programmingLanguageList", programmingLanguagesList);
        model.addObject("countryMap", country);

        return model;
    }

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }
}
