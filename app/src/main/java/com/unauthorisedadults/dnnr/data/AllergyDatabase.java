package com.unauthorisedadults.dnnr.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.unauthorisedadults.dnnr.models.Allergy;

@Database(entities = {Allergy.class}, version = 1)
public abstract class AllergyDatabase extends RoomDatabase {

    private static AllergyDatabase instance;
    public abstract AllergyDao allergyDao();

    public static synchronized AllergyDatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AllergyDatabase.class, "allergy_database")
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return instance;
    }
}
