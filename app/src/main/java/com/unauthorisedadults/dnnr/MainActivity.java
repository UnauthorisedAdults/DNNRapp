package com.unauthorisedadults.dnnr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button startGroup, joinGroup, signIn;
    EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.DNNR_Toolbar);
        setSupportActionBar(toolbar);
       getSupportActionBar().setIcon(R.drawable.ic_logo_smaller);
       getSupportActionBar().setTitle("");

        startGroup = findViewById(R.id.StartGroup);
        joinGroup = findViewById(R.id.JoinGroup);
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.PasswordField);
        signIn = findViewById(R.id.signIn);
    }

    public void startGroup(View view) {
    }


    public void joinGroup(View view) {
    }

    public void signIn(View view) {
    }
}