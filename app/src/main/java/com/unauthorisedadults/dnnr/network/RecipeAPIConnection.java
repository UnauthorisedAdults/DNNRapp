package com.unauthorisedadults.dnnr.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeAPIConnection {
    private static RecipeAPI recipeAPI;

    public static RecipeAPI getRecipeAPI() {
        if (recipeAPI == null) {
            recipeAPI = new Retrofit.Builder()
                    .baseUrl("https://platform.fatsecret.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RecipeAPI.class);
        }
        return recipeAPI;
    }

    // https://www.themealdb.com/api.php
}
