package com.unauthorisedadults.dnnr.network;

public class RecipeResponse {
    private String idMeal;
    private String strMeal;
    private String strCategory;

    public String getRecipe() {
        System.out.println("Recipe name in Response: " + strMeal);
        return strMeal;
        }
}
