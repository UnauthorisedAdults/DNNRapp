package com.unauthorisedadults.dnnr.cardStack;

import static android.graphics.drawable.Drawable.createFromStream;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.os.HandlerCompat;

import com.bumptech.glide.Glide;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CardsDataAdapter extends ArrayAdapter<Recipe> {

    private final Handler mainThreadHandler;
    private final ExecutorService executorService;

    public CardsDataAdapter(Context context) {
        super(context, R.layout.card);
        executorService = Executors.newFixedThreadPool(2);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {

            TextView title = contentView.findViewById(R.id.mealTitle);
            ImageView thumbnail = contentView.findViewById(R.id.imageView);

        //Sætte data ind
       title.setText(getItem(position).getStrMeal());

        //For at få et billede ind fra URL

        Glide.with(contentView).load(getItem(position).getStrMealThumb()).into(thumbnail);

        return contentView;
    }

    public void setRecipe(Recipe recipe) {
        add(recipe);
        notifyDataSetChanged();
    }

     private static class ViewHolder {
        protected TextView title;
        protected ImageView thumbnail;

         public ViewHolder() {

         }
     }
}
