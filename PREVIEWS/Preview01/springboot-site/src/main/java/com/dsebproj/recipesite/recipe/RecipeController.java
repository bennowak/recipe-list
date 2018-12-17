package com.dsebproj.recipesite.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepo;

    private static List<Recipe> recipes = new ArrayList<>();

    @GetMapping("/recipes")
    public ModelAndView showRecipes() {
        ModelAndView mv = new ModelAndView("recipes/allRecipes");
        mv.addObject("pageTitle", "recipes");
        mv.addObject("allRecipes", recipeRepo.findAll());
        System.out.println((recipeRepo.findAll()));
        return mv;
    }
}
