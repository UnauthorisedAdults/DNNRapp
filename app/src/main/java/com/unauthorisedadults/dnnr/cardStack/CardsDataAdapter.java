package com.unauthorisedadults.dnnr.cardStack;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.unauthorisedadults.dnnr.R;



public class CardsDataAdapter extends ArrayAdapter<String> {

    public CardsDataAdapter(Context applicationContext) {
        super(applicationContext, R.layout.card);
    }

    @Override
    public View getView(int position, final View contentView, ViewGroup parent){


        //supply the layout for your card
        TextView title = (TextView)(contentView.findViewById(R.id.mealTitle));
        title.setText(getItem(position));

        ImageView thumbnail = contentView.findViewById(R.id.imageView);
        thumbnail.setImageURI(Uri.parse(getItem(position)));

        Button yes = contentView.findViewById(R.id.yesButton);
        Button no = contentView.findViewById(R.id.noButton);

        return contentView;
    }

}
