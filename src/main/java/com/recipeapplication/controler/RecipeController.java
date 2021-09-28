package com.recipeapplication.controler;

import com.recipeapplication.entity.Recipe;
import com.recipeapplication.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes")
    public String recipesPage(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/recipes/add")
    public String addRecipePage(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "create-recipe";
    }

    @PostMapping("/recipes/add")
    public String addRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-recipe";
        }

        try {
            recipeService.create(recipe);
        } catch (Throwable exception) {
            return "redirect:/error-page?msg=" + exception.getMessage();
        }
        return "redirect:/recipes";
    }

    @RequestMapping("recipes/delete/{id}")
    public String delete(@PathVariable long id) {
        try {
            recipeService.delete(id);
        } catch (Throwable exception) {
            return "redirect:/error-page?msg=" + exception.getMessage();
        }
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/update/{id}")
    public String updateRecipePage(@PathVariable long id, Model model) {
        Recipe recipe = recipeService.getRecipe(id);
        model.addAttribute("recipe", recipe);
        return "update-recipe";
    }

    @PostMapping("/recipes/update")
    public String updateRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-recipe";
        }

        try {
            recipeService.update(recipe);
        } catch (Throwable exception) {
            return "redirect:/error-page?msg=" + exception.getMessage();
        }
        return "redirect:/recipes";
    }
}