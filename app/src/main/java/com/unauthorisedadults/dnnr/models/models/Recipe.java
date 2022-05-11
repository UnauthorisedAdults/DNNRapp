package com.unauthorisedadults.dnnr.models.models;

import java.net.MalformedURLException;
import java.net.URL;

public class Recipe {
    // https://www.themealdb.com/api.php

    private String name; //"strMeal"
    private URL imgURL; // "strMealThumb"
    private String category; //"strCategory"

    public Recipe(String name, String imgURL, String category) throws MalformedURLException {
        this.name = name;
        this.imgURL = new URL(imgURL);
        this.category = category;
    }

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public URL getImgURL() {
        return imgURL;
    }

    public String getCategory() {
        return category;
    }
}
