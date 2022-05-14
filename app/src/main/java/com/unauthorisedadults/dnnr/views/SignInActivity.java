package com.unauthorisedadults.dnnr.views;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.firebase.ui.auth.AuthUI;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.viewModels.SignInViewModel;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.List;

public class SignInActivity extends AppCompatActivity {

    private SignInViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        checkIfSignedIn();
      setContentView(R.layout.login);
    }

    private void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(this, user -> {
            if (user != null)
                goToMain();
            else
                signIn();
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK)
                    goToMain();
                else
                    Toast.makeText(this, "Sign in cancelled", Toast.LENGTH_SHORT).show();
            }
    );

    private void goToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void signIn() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.AnonymousBuilder().build()
        );

        Intent intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.ic_logo_smaller)
                .build();

        activityResultLauncher.launch(intent);
    }
}
