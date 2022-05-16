package com.unauthorisedadults.dnnr.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.viewModels.StartGroupViewModel;

public class GroupFragment extends Fragment {

    private StartGroupViewModel viewModel;
    private NavController navController;

    private TextView participantList;
    private MaterialButton connectButton;
    private Button startButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.group_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        viewModel = new ViewModelProvider(this).get(StartGroupViewModel.class);
        participantList = view.findViewById(R.id.group_participants);
        connectButton = view.findViewById(R.id.group_connect);
        startButton = view.findViewById(R.id.group_start);
        viewModel.registerUser();

        viewModel.getParticipantNames().observe(getViewLifecycleOwner(), names -> {
            if (!names.isEmpty()) {
                participantList.setText("");
                for (String name : names) {
                    participantList.append(name + "\n");
                }
            }
        });

        setupButtons();
    }

    private void setupButtons() {
        connectButton.setOnClickListener(btn -> viewModel.registerUser());
        startButton.setOnClickListener(btn -> startButtonAction());
    }

    private void startButtonAction() {
        navController.navigate(R.id.vote_fragment);
    }
}
