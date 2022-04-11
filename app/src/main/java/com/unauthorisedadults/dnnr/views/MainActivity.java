package com.unauthorisedadults.dnnr.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.unauthorisedadults.dnnr.R;

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
        joinGroup = findViewById(R.id.guest);
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.PasswordField);
        signIn = findViewById(R.id.signIn);
    }

    public void startGroup(View view) {
        //Noget med at starte en gruppe og sende brugeren over til gruppe-view med intent
    }


    public void joinGroup(View view) {
        //Det er vist bare intent til at komme til en anden screen
    }

    public void signIn(View view) {
        //signIn metode, og så giver det nogle ekstra muligheder på samme skærm, ved ikke lige hvordan man griber det an
    }
}