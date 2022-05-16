package com.unauthorisedadults.dnnr.viewModels;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataKt;
import androidx.lifecycle.MutableLiveData;

import com.unauthorisedadults.dnnr.cardStack.CardsDataAdapter;
import com.unauthorisedadults.dnnr.models.models.Recipe;
import com.unauthorisedadults.dnnr.network.RecipeAPI;
import com.unauthorisedadults.dnnr.network.RecipeAPIConnection;
import com.unauthorisedadults.dnnr.network.RecipeResponse;
import com.unauthorisedadults.dnnr.services.MatchHandlerService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class VoteViewModel extends AndroidViewModel {

    private final ExecutorService executorService;
    private final Handler mainThreadHandler;

    private Recipe match;

    private final MatchHandlerService matchHandlerService;
    private CardsDataAdapter mCardAdapter;

    public VoteViewModel(@NonNull Application application) {
        super(application);
        executorService = Executors.newFixedThreadPool(2);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
        matchHandlerService = MatchHandlerService.getInstance();
    }

    public void setCardAdapter(CardsDataAdapter adapter) {
        mCardAdapter = adapter;
    }

    public void matched(int index) {
        match = mCardAdapter.getItem(index);
    }

    public LiveData<Recipe> broadcastMatch() {
        return new MutableLiveData<>(match);
    }

    public void requestRecipes() {
        executorService.execute(() -> {
            RecipeAPI recipeAPI = RecipeAPIConnection.getRecipeAPI();
            for (int i = 0; i < 10; i++) {
                Call<RecipeResponse> responseCall = recipeAPI.getRecipe();
                responseCall.enqueue(new Callback<RecipeResponse>() {
                    @EverythingIsNonNull
                    @Override
                    public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            Recipe recipe = response.body().getMeals().get(0);
                            mainThreadHandler.post(() -> mCardAdapter.setRecipe(recipe));
                        }
                    }

                    @EverythingIsNonNull
                    @Override
                    public void onFailure(Call<RecipeResponse> call, Throwable t) {
                        Log.e("Retrofit", t.getMessage());
                    }
                });

            }
        });

    }
}
