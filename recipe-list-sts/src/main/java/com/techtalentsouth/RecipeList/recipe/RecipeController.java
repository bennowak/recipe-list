package com.techtalentsouth.RecipeList.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	private static List<Recipe> posts = new ArrayList<>();
	
	@GetMapping("/")
	private String index() {
		return "index.html";
	}
	
	@GetMapping("/show")
	private String show() {
		return "show.html";
	}
	
	@GetMapping("/result")
	private String result() {
		return "result.html";
	}
	
	private Recipe recipe;
	@PostMapping(value = "/recipe/new")
	public String addNewBlogPost(Recipe recipe, Model model) {
		recipeRepository.save(new Recipe(recipe.getTitle(), recipe.getAuthor(), recipe.getBody()));
		posts.add(recipe);
		model.addAttribute("title", recipe.getTitle());
		model.addAttribute("author", recipe.getAuthor());
		model.addAttribute("blogEntry", recipe.getBody());
		return "recipe/result";
	   }
	
}
