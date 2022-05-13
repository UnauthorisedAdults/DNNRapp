package com.unauthorisedadults.dnnr.views;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.models.models.GuestUser;
import com.unauthorisedadults.dnnr.models.models.RegisteredUser;
import com.unauthorisedadults.dnnr.models.models.User;
import com.unauthorisedadults.dnnr.utilities.UTIL;
import com.unauthorisedadults.dnnr.viewModels.MainViewModel;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button startGroup, joinGroup, signIn;
    EditText usernameField, passwordField;
    TextView username;
    MainViewModel mainViewModel;
    ImageView container;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Toolbar toolbar = findViewById(R.id.DNNR_Toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.ic_logo_smaller);
        getSupportActionBar().setTitle("");

        checkSignedIn();

        startGroup = findViewById(R.id.StartGroup);
        joinGroup = findViewById(R.id.guest);
        username = findViewById(R.id.username);

        // container = findViewById(R.id.container);

    }

    /*Start group metoden sender brugeren til et group owner view. I dette view bliver gruppen oprettet
     og brugeren bliver sat som group owner*/
    public void startGroup(View view) {
      /*  Intent intent = new Intent(MainActivity.this, StartGroupOwnerActivity.class);
        intent.putExtra(UTIL.USER, user);
        startActivity(intent);*/
        Context context = getApplicationContext();
        Intent intent = new Intent(context, VoteActivity.class);
        startActivity(intent);
    }

    /*Skal sende bruger til et group member view. Her skal brugeren føjes til listen over medlemmer
    i gruppen. Hele brugeren skal sendes med intent her også. */
    public void joinGroup(View view) {
        //TODO: Det er vist bare intent til at komme til en anden screen
    }


    private void checkSignedIn() {
        mainViewModel.getUser().observe(this, user -> {
            if (user != null) {
                if (user.getDisplayName() != null)
                    username.setText(user.getDisplayName());
                else if (user.isAnonymous())
                    username.setText("guest");
            } else
                startLogin();
        });
    }

    private void startLogin() {
        startActivity(new Intent(this, SignInActivity.class));

    }


}