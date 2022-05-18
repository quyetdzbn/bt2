package com.example.demo.model;

import java.util.Date;
import java.util.List;
public class Taco {
	public Long id;
	public String name;
	private Date createdAt;
	private List<Ingredient> ingredients;
	public Taco() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
