package com.dsebproj.recipesite.recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String recipeJSON;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeJSON() {
        return recipeJSON;
    }

    public void setRecipeJSON(String recipeJSON) {
        this.recipeJSON = recipeJSON;
    }

    @Override
    public String toString() {
        return String.format("Recipe ( id=%s, recipeJSON=%s)",
                this.id,
                this.recipeJSON);
    }
}
