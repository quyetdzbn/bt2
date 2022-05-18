package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Ingredient.Type;
import com.example.demo.model.Taco;

@Controller
@RequestMapping("/design")
public class DesignTacoController {
	private RestTemplate rest = new RestTemplate();

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays
				.asList(rest.getForObject("http://localhost:8080/  ingredients", Ingredient[].class));
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}

	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("taco", new Taco());
		return "design";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		List<Ingredient> ingrList = new ArrayList<Ingredient>();
		for (Ingredient ingredient : ingredients) {
			if (ingredient.getType().equals(type))
				ingrList.add(ingredient);
		}
		return ingrList;
	}

	@PostMapping
	public String processDesign(Taco taco) {
		// Save the taco design...
		// We'll do this later
		// log.info("Processing design: " + taco);
		return "redirect:/orders/current";
	}

}
