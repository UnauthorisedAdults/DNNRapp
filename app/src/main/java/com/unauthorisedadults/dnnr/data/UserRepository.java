package com.unauthorisedadults.dnnr.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

public class UserRepository {

    private static UserRepository instance;
    private  UserLiveData currentUser;
    private  Application app;

    public UserRepository(Application app) {
        this.app = app;
        currentUser = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application app) {
        if (instance == null)
            instance = new UserRepository(app);
        return instance;
    }

    public LiveData<FirebaseUser> getCurrentUser(){
        return currentUser;
    }

    public void signOut() {
        AuthUI.getInstance().signOut(app.getApplicationContext());
    }
}
