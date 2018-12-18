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

    private String user;
    private String title;
    private String ingredients;
    private String steps;
    private String imgURL;

    public Recipe(String user, String title, String ingredients, String steps, String imgURL) {
        super();
        this.user = user;
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.imgURL = imgURL;
    }

    public Recipe(){ }

    @Override
    public String toString() {
        return String.format("Recipe ( id=%s, user=%s, title=%s, ingredients=%s, steps=%s, imgURL=%s)",
                this.id,
                this.user,
                this.title,
                this.ingredients,
                this.steps,
                this.imgURL);
    }

    public String toJSON() {
        return String.format("{\"id\": %s, \"user\": \"%s\", \"title\": \"%s\", \"ingredients\": %s, \"steps\": %s, \"img\": \"%s\"}",
                this.id,
                this.user,
                this.title,
                this.ingredients,
                this.steps,
                this.imgURL);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}
