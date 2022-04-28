package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.network.RecipeAPI;
import com.unauthorisedadults.dnnr.network.RecipeAPIConnection;
import com.unauthorisedadults.dnnr.network.RecipeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
//import com.daprlabs.cardstack.SwipeDeck;

public class VoteActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(btn -> {
            getRandomRecipe();
        });
    }

    public void getRandomRecipe() {
        RecipeAPI recipeAPI = RecipeAPIConnection.getRecipeAPI();
        Call<RecipeResponse> recipeResponseCall = recipeAPI.getRecipe();
        recipeResponseCall.enqueue(new Callback<RecipeResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    textView.setText(response.body().getRecipe());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }

}
