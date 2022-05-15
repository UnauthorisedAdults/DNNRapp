package com.unauthorisedadults.dnnr.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.unauthorisedadults.dnnr.data.AllergyDao;
import com.unauthorisedadults.dnnr.data.AllergyDatabase;
import com.unauthorisedadults.dnnr.models.Allergy;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AllergyRepository {

    private static AllergyRepository instance;
    private AllergyDao allergyDao;
    private LiveData<List<Allergy>> allergies;
    private ExecutorService executerService;

    private AllergyRepository(Application application) {

        AllergyDatabase database = AllergyDatabase.getInstance(application);
        allergyDao = database.allergyDao();
        allergies = allergyDao.getAllAllergies();
        executerService = Executors.newFixedThreadPool(2);

    }

    public static synchronized AllergyRepository getInstance(Application application) {

        if (instance == null)
        {
            instance = new AllergyRepository(application);
        }

        return instance;
    }

    public LiveData<List<Allergy>> getAllergies() {
        return allergies;
    }

    public void insert(Allergy allergy) {
        executerService.execute(() ->
                allergyDao.insert(allergy)
        );
    }

    public void deleteAllAllergies() {
        executerService.execute(allergyDao::deleteAllAllergies);
    }
}
