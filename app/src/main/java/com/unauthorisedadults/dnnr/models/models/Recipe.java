package com.unauthorisedadults.dnnr.models.models;

public class Recipe {
    // https://www.themealdb.com/api.php

    private String name; //"strMeal"
    private String imgURL; // "strMealThumb"
    private String category; //"strCategory"

    public Recipe(String name, String imgURL, String category) {
        this.name = name;
        this.imgURL = imgURL;
        this.category = category;
    }

    public Recipe() {
    }
}
