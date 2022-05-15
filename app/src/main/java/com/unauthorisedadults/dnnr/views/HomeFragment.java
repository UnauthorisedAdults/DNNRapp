package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unauthorisedadults.dnnr.R;

public class HomeFragment extends Fragment {

    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        navController = Navigation.findNavController(view);


        setupButtons(view);
    }

    private void setupButtons(View view) {
        Button joinGroup = view.findViewById(R.id.joinGroup);
        joinGroup.setOnClickListener(btn -> joinGroup());

        Button startGroup = view.findViewById(R.id.StartGroup);
        startGroup.setOnClickListener(btn -> startGroup());
    }

    private void joinGroup() {

    }

    private void startGroup() {
        navController.navigate(R.id.group_fragment);
    }

}


