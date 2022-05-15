package com.unauthorisedadults.dnnr.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.data.UserRepository;
import com.unauthorisedadults.dnnr.services.MatchHandlerService;

public class StartGroupViewModel extends AndroidViewModel {

    private final UserRepository userRepository;
    private final MatchHandlerService matchHandlerService;

    public StartGroupViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
        matchHandlerService = MatchHandlerService.getInstance();
    }

    public void registerUser() {
        FirebaseUser currentUser = userRepository.getCurrentUser().getValue();
        assert currentUser != null;
        matchHandlerService.addParticipant(currentUser.getUid());
    }
}
