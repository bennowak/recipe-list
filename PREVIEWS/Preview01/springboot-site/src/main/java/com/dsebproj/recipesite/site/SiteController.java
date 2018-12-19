package com.dsebproj.recipesite.site;

import com.dsebproj.recipesite.recipe.Recipe;
import com.dsebproj.recipesite.recipe.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController {

    @Autowired
    private RecipeRepository recipeRepo;

//    @Autowired
//    private SiteRepository siteRepo;
//
//    private static List<Site> sites = new ArrayList<>();

//    This route handles the index page
    @GetMapping("/")
    public ModelAndView index(Recipe recipe) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("pageTitle", "Index");
        mv.addObject("allRecipes", recipeRepo.findAll());
//        System.out.println(recipeList);
        return mv;


    }

//    This route handles the about page
    @GetMapping("/about")
    public ModelAndView about(){
        ModelAndView mv = new ModelAndView("about");
        mv.addObject("pageTitle", "About");
        return mv;
    }
}
