package com.recipeapplication;

import com.recipeapplication.entity.Recipe;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TestDataProvider {

    public static final Recipe RECIPE = new Recipe(
            "Pizza",
            "Bread, then ingredients, then cheese, then cook",
            2,
            LocalDateTime.parse("2021-04-05T16:20:12"),
            Arrays.asList("Cheese", "Bread", "Seasoning", "Sausage")
    );

    public static final Recipe RECIPE_2 = new Recipe(
            "Lasagna",
            "ingredients, then cheese, then cook",
            4,
            LocalDateTime.parse("2021-07-05T16:20:12"),
            Arrays.asList("Lasagna", "Meat", "Seasoning")
    );

    static {
        RECIPE.setId(22);
    }
}
