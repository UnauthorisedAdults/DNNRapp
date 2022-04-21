package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.User;
import com.unauthorisedadults.dnnr.utilities.UTIL;

import java.util.ArrayList;

public class StartGroupOwnerActivity extends AppCompatActivity {

    TextView groupIdDisplay, groupMemberList;
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
        groupIdDisplay.setText("123456");

        groupMemberList = findViewById(R.id.GroupMembersList);
        start = findViewById(R.id.startButton);
        cancel = findViewById(R.id.cancelButton);
        allergies = findViewById(R.id.allergyFilter);
        preferences = findViewById(R.id.preferenceFilter);

        allergies.setChecked(true);
        preferences.setChecked(true);

        // Gruppeejeren modtages fra intent og navnet tilføjes gruppemedlemslisten
        Bundle bundle = getIntent().getExtras();
        User groupOwner = (User) bundle.get(UTIL.USER);
        groupMembers.add(groupOwner.getUsername());

        for (int i = 0; i < groupMembers.size(); i++) {
            groupMemberList.append(groupMembers.get(i) + "\n");
        }



    }

    public void startSwiping(View view) {
        //viewmodel.start
        //Noget med et intent
    }

    public void cancelGroup(View view)
    {
        finish();
    }
}
