package com.unauthorisedadults.dnnr;

import static org.junit.Assert.assertEquals;

import com.unauthorisedadults.dnnr.services.SwipeHandlerService;

import org.junit.Test;

import java.util.List;

public class SwipeHandlerServiceUnitTest {

    // Test der viser man kan tilføje en 'recipeId' til en affirmative liste
    @Test
    public void addRecipesToAffirmativeList()
    {
        int recipeId = 42;
        SwipeHandlerService swipeHandlerService = new SwipeHandlerService();

        swipeHandlerService.addAffirmativeRecipe(recipeId);
        List<Integer> affirmatives = swipeHandlerService.getAffirmatives();

        assertEquals(recipeId, affirmatives.get(0).intValue());
    }

}
