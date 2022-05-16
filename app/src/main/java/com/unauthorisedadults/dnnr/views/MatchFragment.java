package com.unauthorisedadults.dnnr.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.Recipe;

public class MatchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.match_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView meal = view.findViewById(R.id.match_title);
        ImageView thumbnail = view.findViewById(R.id.match_thumbnail);
        MaterialButton recipe = view.findViewById(R.id.match_get_recipe);

        if (getArguments() != null)
        {
            Recipe match = (Recipe) getArguments().getSerializable("recipe");
            meal.setText(match.getStrMeal());
            Glide.with(view).load(match.getStrMealThumb()).into(thumbnail);

            Uri recipeLink = Uri.parse("https://www.themealdb.com/meal.php?c=" + match.getIdMeal());
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, recipeLink);

            recipe.setOnClickListener(btn -> startActivity(browserIntent));
        }

    }
}
