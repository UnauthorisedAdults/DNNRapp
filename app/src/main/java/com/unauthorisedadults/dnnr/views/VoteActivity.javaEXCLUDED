package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.cardStack.CardListener;
import com.unauthorisedadults.dnnr.cardStack.CardsDataAdapter;
import com.unauthorisedadults.dnnr.models.models.Recipe;
import com.unauthorisedadults.dnnr.network.RecipeAPI;
import com.unauthorisedadults.dnnr.network.RecipeAPIConnection;
import com.unauthorisedadults.dnnr.network.RecipeResponse;
import com.unauthorisedadults.dnnr.viewModels.VoteActivityViewModel;
import com.wenchao.cardstack.CardStack;

import java.net.MalformedURLException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
//import com.daprlabs.cardstack.SwipeDeck;

public class VoteActivity extends AppCompatActivity {
    private CardStack mCardStack;
    private CardsDataAdapter mCardAdapter;
    private VoteActivityViewModel viewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);

        viewModel = new ViewModelProvider(this).get(VoteActivityViewModel.class);

        //Cardstack indlæsning
        mCardStack = (CardStack) findViewById(R.id.cardStackContainer);
        mCardStack.setContentResource(R.layout.card);
        //mCardStack.setListener(new CardListener(viewModel));
        mCardStack.setStackMargin(20);

        //Cardstack Adapter
        ArrayList<Recipe> recipes = new ArrayList<>();
        try {
            recipes.add(new Recipe("Tamiya", "https://www.themealdb.com/images/media/meals/n3xxd91598732796.jpg", "Vegetarian"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        mCardAdapter = new CardsDataAdapter(getApplicationContext());
        mCardAdapter.addAll(recipes);

        mCardStack.setAdapter(mCardAdapter);

        Button button = findViewById(R.id.noButton);
        //textView = findViewById(R.id.textView);

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
                    // textView.setText(response.body().getRecipe());
                    Recipe recipe = response.body().getMeals().get(0);
                    mCardAdapter.add(recipe);
                    mCardAdapter.notifyDataSetChanged();
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
