package com.unauthorisedadults.dnnr.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.unauthorisedadults.dnnr.models.models.Recipe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class RecipeRepository {
    private static RecipeRepository instance;
    private final MutableLiveData<String> randomRecipe;

    public RecipeRepository() {
        randomRecipe = new MutableLiveData<>();
    }

    public static synchronized RecipeRepository getInstance() {
        if (instance == null) {
            instance = new RecipeRepository();
        }
        return instance;
    }

    public LiveData<String> getRandomRecipe() {
        System.out.println("getRandomRecipe, Recipe = " + randomRecipe.getValue());
        return randomRecipe;
    }


    public void searchRandomRecipe() {
        RecipeAPI recipeAPI = RecipeAPIConnection.getRecipeAPI();
        Call<RecipeResponse> recipeResponseCall = recipeAPI.getRecipe();
        recipeResponseCall.enqueue(new Callback<RecipeResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    randomRecipe.setValue(response.body().getMeals().get(0).getStrMeal());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
        System.out.println("searchRandomRecipe, Recipe = " + randomRecipe.getValue());
    }
}
