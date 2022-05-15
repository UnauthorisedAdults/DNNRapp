package com.unauthorisedadults.dnnr.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.data.UserRepository;

public class HomeViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
    }

    public FirebaseUser getCurrentUser() {
        return userRepository.getCurrentUser().getValue();
    }
}
