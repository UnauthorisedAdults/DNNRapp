package com.unauthorisedadults.dnnr.database;

import java.util.ArrayList;
import java.util.Arrays;

public class Database {
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
                    "Purple")
    );

    private ArrayList<String> usedNames = new ArrayList<>();

    public Database() {
    }

    public String getRandomId() {
        //TODO find random combination
        return null;
    }
}
