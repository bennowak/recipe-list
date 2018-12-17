package com.dsebproj.recipesite.recipe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
//public interface RecipeRepository extends MongoRepository<Recipe, Long> {

}
