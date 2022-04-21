package com.unauthorisedadults.dnnr.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.GuestUser;
import com.unauthorisedadults.dnnr.models.models.RegisteredUser;
import com.unauthorisedadults.dnnr.models.models.User;
import com.unauthorisedadults.dnnr.utilities.UTIL;
import com.unauthorisedadults.dnnr.viewModels.MainViewModel;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Button startGroup, joinGroup, signIn;
    EditText usernameField, passwordField;
    TextView username;
    MainViewModel mainViewModel;
    ImageView container;
    String randomId;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Toolbar toolbar = findViewById(R.id.DNNR_Toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.ic_logo_smaller);
        getSupportActionBar().setTitle("");

        startGroup = findViewById(R.id.StartGroup);
        joinGroup = findViewById(R.id.guest);
        username = findViewById(R.id.username);
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.PasswordField);
        signIn = findViewById(R.id.signIn);
       // container = findViewById(R.id.container);

        randomId = assignRandomId();
        username.setText(randomId);

        user = new GuestUser(randomId);
    }

    public String assignRandomId() {
        return mainViewModel.assignRandomId();
    }

    /*Start group metoden sender brugeren til et group owner view. I dette view bliver gruppen oprettet
     og brugeren bliver sat som group owner*/
    public void startGroup(View view) {
        Intent intent = new Intent(MainActivity.this, StartGroupOwnerActivity.class);
        intent.putExtra(UTIL.USER, user);
        startActivity(intent);
    }

    /*Skal sende bruger til et group member view. Her skal brugeren føjes til listen over medlemmer
    i gruppen. Hele brugeren skal sendes med intent her også. */
    public void joinGroup(View view) {
        //TODO: Det er vist bare intent til at komme til en anden screen
    }

    public void signIn(View view) {
        user = mainViewModel.signIn(usernameField.getText().toString(), passwordField.getText().toString());
        //TODO: signIn metode, og så giver det nogle ekstra muligheder på samme skærm, ved ikke lige
        // hvordan man griber det an. Måske med fragments?
    }
}