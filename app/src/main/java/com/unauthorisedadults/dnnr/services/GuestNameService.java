package com.unauthorisedadults.dnnr.services;

import com.unauthorisedadults.dnnr.data.Database;
import com.unauthorisedadults.dnnr.data.Idao;

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
//FIXME: Der kommer ind i mellem fejl her med index out of bounds 5
    public String getRandomId() {
        int range = animals.size() + 1;
        String animal = animals.get((int) Math.floor(Math.random() * range));
        range = colors.size() + 1;
        String color = colors.get((int) Math.floor(Math.random() * range));

        String Id = color + " " + animal;

        if(usedNames.contains(Id))
            getRandomId();
        else
            usedNames.add(Id);

        return Id;
    }
}
