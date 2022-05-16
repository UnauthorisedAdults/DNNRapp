package com.unauthorisedadults.dnnr.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.unauthorisedadults.dnnr.network.RecipeRepository;

public class VoteActivityViewModel extends AndroidViewModel {
    RecipeRepository repository;

    public VoteActivityViewModel(Application application) {
        super(application);
        repository = RecipeRepository.getInstance();
    }

    public void matched(int index) {
    }

    public LiveData<String> getRandomRecipe() {
        return repository.getRandomRecipe();
    }

    public void searchRandomRecipe()
    {
        repository.searchRandomRecipe();
    }
}
