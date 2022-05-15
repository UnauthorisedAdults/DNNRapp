package com.unauthorisedadults.dnnr.services;

import java.util.ArrayList;
import java.util.List;

public class SwipeHandlerService {
    private List<Integer> affirmatives;

    public SwipeHandlerService() {
        affirmatives = new ArrayList<>();
    }

    public void addAffirmativeRecipe(int recipeId) {
        affirmatives.add(recipeId);
    }

    public List<Integer> getAffirmatives() {
        List<Integer> returnList = new ArrayList<>();

        returnList.addAll(affirmatives);

        return returnList;
    }
}
