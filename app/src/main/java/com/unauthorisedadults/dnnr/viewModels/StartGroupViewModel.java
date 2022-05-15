package com.unauthorisedadults.dnnr.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.data.UserRepository;
import com.unauthorisedadults.dnnr.models.AffirmativeSwipe;
import com.unauthorisedadults.dnnr.services.MatchHandlerService;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Objects;

public class StartGroupViewModel extends AndroidViewModel {

    private final UserRepository userRepository;
    private final MatchHandlerService matchHandlerService;
    private final MutableLiveData<List<String>> participantNames;

    public StartGroupViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
        matchHandlerService = MatchHandlerService.getInstance();
        participantNames = new MutableLiveData<>(new ArrayList<>());
    }

    public void registerUser() {
        FirebaseUser currentUser = userRepository.getCurrentUser().getValue();
        assert currentUser != null;
        matchHandlerService.addParticipant(currentUser.getUid());
        if (participantNames.getValue() != null) {
            if (currentUser.getDisplayName() == null || currentUser.getDisplayName().equals(""))
                participantNames.getValue().add("Guest");
            else
                participantNames.getValue().add(currentUser.getDisplayName());
        }
    }

    public LiveData<List<String>> getParticipantNames() {
        return participantNames;
    }
}
