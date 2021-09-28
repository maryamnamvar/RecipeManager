package com.recipeapplication.service;

import com.recipeapplication.entity.Recipe;

public interface RecipeService {

    Iterable<Recipe> getAllRecipes();

    Recipe getRecipe(long id);

    String delete(long id);

    Recipe create(Recipe recipe);

    Recipe update(Recipe recipe);
}