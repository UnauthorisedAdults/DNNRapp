package com.unauthorisedadults.dnnr.cardStack;

import static android.graphics.drawable.Drawable.createFromStream;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.os.HandlerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
       title.setText(getItem(position).getName());

        //For at få et billede ind fra URL

        executorService.execute(() -> {
            InputStream inputStream = null;
            try {
                inputStream = (InputStream) CardsDataAdapter.this.getItem(position).getImgURL().getContent();
                Drawable drawable = createFromStream(inputStream, null);
                mainThreadHandler.post(() -> thumbnail.setImageDrawable(drawable));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return contentView;
    }

     private static class ViewHolder {
        protected TextView title;
        protected ImageView thumbnail;

         public ViewHolder() {

         }
     }
}
