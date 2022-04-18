package com.unauthorisedadults.dnnr.database;

import java.util.ArrayList;
import java.util.Arrays;

public class Database implements Idao {
    //For now just hardcoded
    private final ArrayList<String> animals = new ArrayList<String>(
            Arrays.asList("Dog",
                    "Cat",
                    "Horse",
                    "Penguin",
                    "Snail"));
    private final ArrayList<String> colors = new ArrayList<String>(
            Arrays.asList("Orange",
                    "Red",
                    "Blue",
                    "Purple",
                    "Lilac")
    );


    public Database() {
    }



    @Override
    public ArrayList<String> getAnimals() {
        return animals;
    }

    @Override
    public ArrayList<String> getColors() {
        return colors;
    }
}
