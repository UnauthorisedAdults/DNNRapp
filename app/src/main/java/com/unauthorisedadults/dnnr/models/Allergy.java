package com.unauthorisedadults.dnnr.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "allergy_table")
public class Allergy {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String allergy;

    public Allergy(String allergy) {
        this.allergy = allergy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
