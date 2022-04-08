package com.unauthorisedadults.dnnr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    EditText groupNumber;
    Button joinGroup, createGroup;
    TextView usernameText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        groupNumber = findViewById(R.id.groupNumber);
        joinGroup = findViewById(R.id.userJoinGroup);
        createGroup = findViewById(R.id.userCreateGroup);
        usernameText = findViewById(R.id.usernameText);
    }

    public void joinGroup(View view) {
        //Skal rent faktisk føje personen til en gruppe og bruge intent til at sende dem videre
    }
}
