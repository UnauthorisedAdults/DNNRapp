package com.unauthorisedadults.dnnr.network;

import com.unauthorisedadults.dnnr.models.models.Recipe;

import java.util.List;

public class RecipeResponse {
    private List<Recipe> meals;

    public List<Recipe> getMeals() {
        return meals;
    }
}
