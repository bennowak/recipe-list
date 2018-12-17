package com.dsebproj.recipesite.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController {

//    @Autowired
//    private SiteRepository siteRepo;
//
//    private static List<Site> sites = new ArrayList<>();

    @GetMapping("/")
    public ModelAndView userLogin() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("pageTitle", "Index");
        return mv;
    }
}
