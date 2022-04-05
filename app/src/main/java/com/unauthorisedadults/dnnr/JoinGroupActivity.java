package com.unauthorisedadults.dnnr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JoinGroupActivity extends AppCompatActivity {

    EditText groupNumber;
    Button joinGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_gorup_activity);

        groupNumber = findViewById(R.id.groupNumber);
        joinGroup = findViewById(R.id.UserJoinGroup);
    }

    public void joinGroup(View view) {
        //Skal rent faktisk føje personen til en gruppe og bruge intent til at sende dem videre
    }
}
