package com.unauthorisedadults.dnnr.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.data.UserRepository;
import com.unauthorisedadults.dnnr.models.models.User;
import com.unauthorisedadults.dnnr.services.GuestNameService;

public class MainViewModel extends AndroidViewModel {

    //private GuestNameService guestNameService = new GuestNameService();
    private UserRepository userRepository;

    public MainViewModel(Application app) {
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public User signIn(String username, String password) {
        return null; //Det skal ud til business serveren og tjekkes
    }

    public LiveData<FirebaseUser> getUser() {
    return userRepository.getCurrentUser();
    }

    public void signOut() {
        userRepository.signOut();
    }
}
