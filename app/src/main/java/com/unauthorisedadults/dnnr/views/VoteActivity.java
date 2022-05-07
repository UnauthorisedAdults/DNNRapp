package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.CompactRecipe;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.model.Recipe;
import com.fatsecret.platform.services.Response;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.network.ResponseListener;
import com.unauthorisedadults.dnnr.viewModels.VoteActivityViewModel;

import java.util.List;
//import com.daprlabs.cardstack.SwipeDeck;

public class VoteActivity extends AppCompatActivity {

    private VoteActivityViewModel viewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);

        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        viewModel = new ViewModelProvider(this).get(VoteActivityViewModel.class);



        String key = "c6ef9fd2fd344c8bb55833abcc3263c8"; //Application Consumer Key
        String secret = "80f65c3d235d4d9cbd0077be7cf0ee15"; //Replace this by your Consumer Secret
        String query = "pasta";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        Listener listener = new Listener();



        com.unauthorisedadults.dnnr.network.Request req = new com.unauthorisedadults.dnnr.network.Request(key, secret, listener);

        button.setOnClickListener(btn -> {
            req.getFood(requestQueue, 29304L);

            req.getRecipe(requestQueue, 315L);

            // viewModel.searchRandomRecipe();
            // textView.setText("Jeg virker " + viewModel.getRandomRecipe().getValue());
        });

        //This food object contains detailed information about the food item
      //  req.getFood(requestQueue, 29304L);


        //This recipe object contains detailed information about the recipe item
     //   req.getRecipe(requestQueue, 315L);
    }

    static class Listener implements ResponseListener {
        @Override
        public void onFoodListRespone(Response<CompactFood> response) {
            System.out.println("TOTAL FOOD ITEMS: " + response.getTotalResults());

            List<CompactFood> foods = response.getResults();
            //This list contains summary information about the food items

            System.out.println("=========FOODS============");
            for (CompactFood food: foods) {
                System.out.println(food.getName());
            }
        }

        @Override
        public void onRecipeListRespone(Response<CompactRecipe> response) {
            System.out.println("TOTAL RECIPES: " + response.getTotalResults());

            List<CompactRecipe> recipes = response.getResults();
            System.out.println("=========RECIPES==========");
            for (CompactRecipe recipe: recipes) {
                System.out.println(recipe.getName());
            }
        }

        @Override
        public void onFoodResponse(Food food) {
            System.out.println("FOOD NAME: " + food.getName());
        }

        @Override
        public void onRecipeResponse(Recipe recipe) {
            System.out.println("RECIPE NAME: " + recipe.getName());
        }
    }

}

