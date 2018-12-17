package com.dsebproj.recipesite.siteuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteUserController {

    @Autowired
    private SiteUserRepository siteUserRepo;

    private static List<SiteUser> users = new ArrayList<>();

    @GetMapping("/login")
    public ModelAndView userLogin() {
        ModelAndView mv = new ModelAndView("users/login");
        return mv;
    }

    @GetMapping("/users")
    public ModelAndView showUsers() {
        ModelAndView mv = new ModelAndView("users/allUsers");
        mv.addObject("pageTitle", "users");
        mv.addObject("siteUsers", siteUserRepo.findAll());
        System.out.println((siteUserRepo.findAll()));
        return mv;
    }
}

