package com.techtalentsouth.RecipeList.recipe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String author;
	private String title;
	private String body;
	
	private Recipe() {
		
	}

	public Recipe(String author, String title, String body) {
		super();
		this.author = author;
		this.title = title;
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Recipe [author=" + author + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
}
