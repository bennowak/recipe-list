package com.dsebproj.recipesite.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        mv.addObject("pageTitle", "Recipes");
        Iterable<Recipe> allRecipes = recipeRepo.findAll();
        ArrayList<String> recipeList = new ArrayList<>();
        for(Recipe r : allRecipes){
            recipeList.add(r.toJSON());
        }
        mv.addObject("allRecipes", recipeList);
        System.out.println((recipeList));
        return mv;
    }

    @GetMapping("/recipes/new")
    public ModelAndView newRecipeForm() {
        ModelAndView mv = new ModelAndView("recipes/newRecipe");
        mv.addObject("pageTitle", "New Recipe");
        return mv;
    }

    @PostMapping("/recipes/new")
    public ModelAndView newRecipeSubmit(){
        ModelAndView mv = new ModelAndView("recipes/addRecipe");
        return mv;
    }
}
