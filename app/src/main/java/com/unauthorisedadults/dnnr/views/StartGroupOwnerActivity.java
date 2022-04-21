package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.User;
import com.unauthorisedadults.dnnr.utilities.UTIL;

import java.util.ArrayList;

public class StartGroupOwnerActivity extends AppCompatActivity {

    TextView groupIdDisplay, groupMemberListView;
    Button start, cancel;
    Switch allergies, preferences;
    ArrayList<String> groupMembers = new ArrayList<>(); //TODO: liveData heeeerr

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groupowneractivity);

        /*
        Toolbar toolbar = findViewById(R.id.DNNR_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_logo_smaller);
        getSupportActionBar().setTitle("");*/


        groupIdDisplay = findViewById(R.id.GroupIdDisplay);
        groupMemberListView = findViewById(R.id.GroupMembersList);
        start = findViewById(R.id.startButton);
        cancel = findViewById(R.id.cancelButton);
        allergies = findViewById(R.id.allergyFilter);
        preferences = findViewById(R.id.preferenceFilter);

        allergies.setChecked(true);
        preferences.setChecked(true);

        // Gruppeejeren modtages fra intent og navnet tilføjes gruppemedlemslisten
        Bundle bundle = getIntent().getExtras();
        User groupOwner = (User) bundle.get(UTIL.USER);
        System.out.println(groupOwner.getUsername());
        groupMembers.add(groupOwner.getUsername());

       groupMemberListView.setText(groupMembers.get(0));


    }

    public void startSwiping(View view) {
        //viewmodel.start
        //Noget med et intent
    }

    public void cancelGroup(View view)
    {
        //viewModel.cancelgroup
        //Intent sender bruger tilbage til home
    }
}
