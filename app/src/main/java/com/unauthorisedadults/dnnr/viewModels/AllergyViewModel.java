package com.unauthorisedadults.dnnr.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.unauthorisedadults.dnnr.repository.AllergyRepository;

public class AllergyViewModel extends AndroidViewModel {

    private AllergyRepository repository;

    public AllergyViewModel(@NonNull Application application) {
        super(application);
        repository = AllergyRepository.getInstance(application);
    }

    //  Enhjørninge magi herefter...
}
