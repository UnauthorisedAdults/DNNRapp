package com.unauthorisedadults.dnnr.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.data.UserRepository;

public class SignInViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public SignInViewModel(Application app) {
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepository.getCurrentUser();
    }
}
