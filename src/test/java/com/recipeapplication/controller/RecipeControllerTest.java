package com.recipeapplication.controller;

import com.recipeapplication.service.RecipeServiceImpl;
import com.recipeapplication.TestDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @MockBean
    RecipeServiceImpl recipeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "test", password = "test", roles = "USER")
    public void canShowAllRecipes() throws Exception {
        when(recipeService.getAllRecipes()).thenReturn(Arrays.asList(TestDataProvider.RECIPE, TestDataProvider.RECIPE_2));

        mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes"))
                .andExpect(model().attribute("recipes", hasSize(2)))
                .andExpect(model().attribute("recipes", hasItem(
                        allOf(
                                hasProperty("name", is("Pizza")),
                                hasProperty("cookingInstruction", is("Bread, then ingredients, then cheese, then cook")),
                                hasProperty("numberOfPeople", is(2))
                        )
                ))).andExpect(model().attribute("recipes", hasItem(
                allOf(
                        hasProperty("name", is("Lasagna")),
                        hasProperty("cookingInstruction", is("ingredients, then cheese, then cook")),
                        hasProperty("numberOfPeople", is(4))
                )
        )));

    }

    @Test
    @WithMockUser(username = "test", password = "test", roles = "USER")
    public void canShowAddRecipePage() throws Exception {
        mockMvc.perform(get("/recipes/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("create-recipe"))
                .andExpect(model().attribute("recipe", is(
                        allOf(
                                hasProperty("name", nullValue()),
                                hasProperty("cookingInstruction", nullValue()),
                                hasProperty("numberOfPeople", is(0))
                        )
                )));
    }

    @Test
    @WithMockUser(username = "test", password = "test", roles = "USER")
    public void canShowUpdateRecipePage() throws Exception {
        when(recipeService.getRecipe(2)).thenReturn(TestDataProvider.RECIPE);

        mockMvc.perform(get("/recipes/update/2"))
                .andExpect(status().isOk())
                .andExpect(view().name("update-recipe"))
                .andExpect(model().attribute("recipe", is(
                        allOf(
                                hasProperty("name", is("Pizza")),
                                hasProperty("cookingInstruction", is("Bread, then ingredients, then cheese, then cook")),
                                hasProperty("numberOfPeople", is(2))
                        )
                )));
    }
}
