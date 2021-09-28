package com.recipeapplication.service;

import com.recipeapplication.entity.Recipe;
import com.recipeapplication.repository.RecipeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.recipeapplication.TestDataProvider.RECIPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RecipeServiceImplTest {

    @MockBean
    private RecipeRepository repository;

    @Autowired
    private RecipeServiceImpl sut;

    @Test
    public void canGetRecipe() {
        given(repository.findById(2L)).willReturn(Optional.of(RECIPE));

        Assertions.assertThat(sut.getRecipe(2)).isEqualTo(RECIPE);
    }

    @Test
    public void canCreateRecipe() {
        when(repository.save(RECIPE)).thenReturn(RECIPE);

        Recipe recipe = sut.create(RECIPE);

        assertThat(recipe).isEqualTo(RECIPE);
    }
}
