package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.network.RecipeAPI;
import com.unauthorisedadults.dnnr.network.RecipeAPIConnection;
import com.unauthorisedadults.dnnr.network.RecipeResponse;
import com.unauthorisedadults.dnnr.viewModels.VoteActivityViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
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
        button.setOnClickListener(btn -> {
            viewModel.searchRandomRecipe();
            textView.setText("Jeg virker " + viewModel.getRandomRecipe().getValue());
        });
    }

}

