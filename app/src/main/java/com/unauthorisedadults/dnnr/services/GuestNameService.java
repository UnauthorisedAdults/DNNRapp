package com.unauthorisedadults.dnnr.services;

import com.unauthorisedadults.dnnr.database.Database;
import com.unauthorisedadults.dnnr.database.Idao;

import java.util.ArrayList;

public class GuestNameService {

    private ArrayList<String> animals;
    private ArrayList<String> colors;
    private ArrayList<String> usedNames = new ArrayList<>();
    private Idao dao = new Database();

    public GuestNameService() {
        this.animals = dao.getAnimals();
        this.colors = dao.getColors();
    }

    public String getRandomId() {
        int range = animals.size() + 1;
        String animal = animals.get((int) (Math.random() * range));
        range = colors.size() + 1;
        String color = colors.get((int) (Math.random() * range));

        String Id = color + " " + animal;

        if(usedNames.contains(Id))
            getRandomId();
        else
            usedNames.add(Id);

        return Id;
    }
}
