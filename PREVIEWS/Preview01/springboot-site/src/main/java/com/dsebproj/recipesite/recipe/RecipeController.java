package com.dsebproj.recipesite.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        System.out.println(recipeList);
        return mv;
    }

    @GetMapping("/recipes/detail/{id}")
    public ModelAndView readRecipe(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("recipes/detail");
        mv.addObject("pageTitle", "Recipe Detail");
        Optional<Recipe> found = recipeRepo.findById(id);
        if(found.isPresent()){
            mv.addObject("recipe", found.get());
        } else {
            mv.addObject("recipe", new Recipe(null, "Error, this recipe is not in the Database", null, null, null));
        }
        return mv;
    }

    @GetMapping("/recipes/new")
    public ModelAndView newRecipeForm(Recipe newRecipe) {
        ModelAndView mv = new ModelAndView("recipes/newRecipe");
        mv.addObject("pageTitle", "New Recipe");
        mv.addObject("newRecipe", newRecipe);
        return mv;
    }

    @PostMapping("/recipes/new")
    public ModelAndView newRecipeSubmit(Recipe recipe){
        ModelAndView mv = new ModelAndView("recipes/newRecipeResult");
        Recipe newRecipe = recipeRepo.save(recipe);
        mv.addObject("newRecipe", newRecipe);
        System.out.println(newRecipe.toString());
        return mv;
    }

    @PostMapping("/recipes/delete/{id}")
    public ModelAndView deleteRecipe(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("recipes/deleteRecipe");
        mv.addObject("pageTitle", "Recipe Delete");
        if(recipeRepo.existsById(id)){
            recipeRepo.deleteById(id);
            mv.addObject("deleteMessage", "The recipe has been deleted");
        } else {
            mv.addObject("deleteMessage", "Unable to delete recipe. Please contact admin.");
        }
        return mv;
    }
}
