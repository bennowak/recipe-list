package com.dsebproj.recipesite.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepo;

    private static List<Recipe> recipes = new ArrayList<>();

//  This route gets all the recipes from the database, then creates an ArrayList which is used
//  to hold the individual Recipes as JSON objects.  Then the ArrayList of JSON strings is passed
//  to the page for rendering using JavaScript on the page.
    @GetMapping("/recipes")
    public ModelAndView showRecipes() {
//        ModelAndView mv = new ModelAndView("recipes/allRecipes");
//        mv.addObject("pageTitle", "Recipes");
//        Iterable<Recipe> allRecipes = recipeRepo.findAll();
//        ArrayList<String> recipeList = new ArrayList<>();
//        for(Recipe r : allRecipes){
//            recipeList.add(r.toJSON());
//        }
//        mv.addObject("allRecipes", recipeList);
////        System.out.println(recipeList);
//        return mv;
    	ModelAndView mv = new ModelAndView("recipes/allRecipes");
        mv.addObject("pageTitle", "Recipes");
        mv.addObject("allRecipes", recipeRepo.findAll());
//        System.out.println(recipeList);
        return mv;
    }

//    This route used a Path Variable to query the recipes table for a recipe that matches the id.
//    If a match is found, it is added to the ModelAndView.  If no match is found a "null" recipe
//    object is instantiated and passed with an error message in the title field.
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
        System.out.println(found.get().toJSON());
        return mv;
    }

//    This route is to the new recipe form page
    @GetMapping("/recipes/new")
    public ModelAndView newRecipeForm(Recipe newRecipe) {
        ModelAndView mv = new ModelAndView("recipes/newRecipe");
        mv.addObject("pageTitle", "New Recipe");
        mv.addObject("newRecipe", newRecipe);
        return mv;
    }

//    This route handles submission of the new ricipe form
    @PostMapping("/recipes/new")
    public ModelAndView newRecipeSubmit(Recipe recipe){
        ModelAndView mv = new ModelAndView("recipes/newRecipeResult");
        mv.addObject("pageTitle", "Recipe Submitted");
        Recipe newRecipe = recipeRepo.save(recipe);
        mv.addObject("newRecipe", newRecipe);
//        System.out.println(newRecipe.toString());
        return mv;
    }

//    This route used a Path Variable to query the recipes table for a recipe that matches the id.
//    If a match is found, it is deleted and then a confirmation message added to the ModelAndView.
//    If no match is found then an error message is added to the ModelAndView and returned.
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
    
    @PostMapping("/recipes/edit/{id}")
	public ModelAndView updatePostForm(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("recipes/editpage");
		Optional<Recipe> recipe = recipeRepo.findById(id);
		mv.addObject("newRecipe", recipe);
		mv.addObject("pageTitle", "Recipe - Edit");
		return mv;
	}
    
    @PostMapping("/recipes/update/{id}")
    public ModelAndView mv(@PathVariable("id") long id, Recipe recipeUpdate) {
        System.out.println(recipeUpdate);
        ModelAndView mv = new ModelAndView("recipes/update");
        if(recipeRepo.existsById(id)){
            Recipe updated = recipeRepo.findById(id).get();
            updated.setIngredients(recipeUpdate.getIngredients());
            updated.setImgURL(recipeUpdate.getImgURL());
            updated.setSteps(recipeUpdate.getSteps());
            updated.setTitle(recipeUpdate.getTitle());
            recipeRepo.save(updated);
            mv.addObject("pageTitle", "Recipe Updated");
            mv.addObject("updateMessage", "The recipe has been updated");
        } else {
        	mv.addObject("pageTitle", "Update Error");
            mv.addObject("updateMessage", "Unable to update recipe. Please contact admin.");
        }
        return mv;
    }
}
