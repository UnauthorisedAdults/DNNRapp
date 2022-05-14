package com.unauthorisedadults.dnnr.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.unauthorisedadults.dnnr.cardStack.CardEventHandler;
import com.unauthorisedadults.dnnr.network.RecipeRepository;

public class VoteActivityViewModel extends ViewModel {
    RecipeRepository repository;

    public VoteActivityViewModel() {
        repository = RecipeRepository.getInstance();
    }

    public LiveData<String> getRandomRecipe() {
        return repository.getRandomRecipe();
    }

    public void searchRandomRecipe()
    {
        repository.searchRandomRecipe();
    }
}
