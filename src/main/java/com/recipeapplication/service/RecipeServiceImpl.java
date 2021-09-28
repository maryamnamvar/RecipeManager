package com.recipeapplication.service;

import com.recipeapplication.entity.Recipe;
import com.recipeapplication.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipe(long id) {
        return recipeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));
    }

    @Override
    public String delete(long id) {
        Recipe recipe = getRecipe(id);//to make sure the recipe exists
        recipeRepository.delete(recipe);
        return "recipe is deleted";
    }

    @Override
    public Recipe create(Recipe recipe) {
        recipe.setCreationDate(LocalDateTime.now());
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe update(Recipe recipe) {
        Recipe recipeInDb = getRecipe(recipe.getId());//to make sure the recipe exists
        recipe.setId(recipeInDb.getId());
        return recipeRepository.save(recipe);
    }
}