package com.unauthorisedadults.dnnr.cardStack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class CardsDataAdapter extends ArrayAdapter<Recipe> {

    private ArrayList<Recipe> recipes;
    private ViewHolder viewHolder;

    public CardsDataAdapter(Context applicationContext, ArrayList<Recipe> recipes) {
        super(applicationContext, R.layout.card, recipes);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        //Check om der er et view vi genbruger
        if (contentView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.card, parent, false);
            viewHolder = new ViewHolder(contentView);
            contentView.setTag(viewHolder);
        }

        //Sætte data ind
        viewHolder.title.setText(recipes.get(position).getName());

        //For at få et billede ind fra URL

        try {
            InputStream inputStream = (InputStream) recipes.get(position).getImgURL().getContent();
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            viewHolder.thumbnail.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return contentView;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnail;

        ViewHolder(View itemView) {
            super(itemView);
            TextView title = itemView.findViewById(R.id.mealTitle);
            ImageView thumbnail = itemView.findViewById(R.id.imageView);
        }
    }
}
