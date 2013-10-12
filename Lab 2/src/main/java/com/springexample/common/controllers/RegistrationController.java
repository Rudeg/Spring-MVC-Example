package com.springexample.common.controllers;

import com.springexample.common.constraits.DatabasePasswordSecurerBean;
import com.springexample.common.model.Entity.RegistrationUser;
import com.springexample.common.model.Entity.Role;
import com.springexample.common.model.Entity.User;
import javax.validation.Valid;

import com.springexample.common.service.RoleService;
import com.springexample.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DatabasePasswordSecurerBean databasePasswordSecurerBean;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView model = new ModelAndView("registration", "user", new RegistrationUser());

        model.addObject("programmingLanguageList", initProgramLang());
        model.addObject("countryMap", initCountry());

        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") RegistrationUser user, BindingResult result, Model m) {
        if (result.hasErrors()) {

            //add objects to model
            m.addAttribute("programmingLanguageList", initProgramLang());
            m.addAttribute("countryMap", initCountry());

            return "registration";
        }
        Role userRole = roleService.getById(2L); //ROLE_USER
        Set<Role> roles = new HashSet<Role>();
        roles.add(userRole);

        User u = new User();
        u.setPasswordHash(databasePasswordSecurerBean.secureUser(user, user.getPassword()));
        u.setComments(user.getComments());
        u.setCountry(user.getCountry());
        u.setFirstname(user.getFirstname());
        u.setLastname(user.getLastname());
        u.setPosts(user.getPosts());
        u.setProgLang(user.getProgLang());
        u.setReceiveNewsLetter(user.getReceiveNewsLetter());
        u.setSex(user.getSex());
        u.setUsername(user.getUsername());
        u.setId(user.getId());

        u.setUserRoles(roles);
        userService.saveUser(u);

        m.addAttribute("username", user.getUsername());

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
