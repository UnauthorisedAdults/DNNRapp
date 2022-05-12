package com.unauthorisedadults.dnnr.models.models;

import java.net.MalformedURLException;
import java.net.URL;

public class Recipe {
    // https://www.themealdb.com/api.php

    private String strMeal; //"strMeal"
    private URL strMealThumb; // "strMealThumb"
    private String strCategory; //"strCategory"

    public Recipe(String strMeal, String strMealThumb, String strCategory) throws MalformedURLException {
        this.strMeal = strMeal;
        this.strMealThumb = new URL(strMealThumb);
        this.strCategory = strCategory;
    }

    public Recipe() {
    }

    public String getStrMeal() {
        return strMeal;
    }

    public URL getStrMealThumb() {
        return strMealThumb;
    }

    public String getStrCategory() {
        return strCategory;
    }
}
