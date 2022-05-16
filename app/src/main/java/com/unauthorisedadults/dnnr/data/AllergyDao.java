package com.unauthorisedadults.dnnr.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.unauthorisedadults.dnnr.models.Allergy;

import java.util.List;

@Dao
public interface AllergyDao {
    @Insert
    void insert(Allergy allergy);

    @Update
    void update(Allergy allergy);

    @Delete
    void delete(Allergy allergy);

    @Query("DELETE FROM allergy_table")
    void deleteAllAllergies();

    @Query("SELECT * FROM allergy_table")
    LiveData<List<Allergy>> getAllAllergies();
}
