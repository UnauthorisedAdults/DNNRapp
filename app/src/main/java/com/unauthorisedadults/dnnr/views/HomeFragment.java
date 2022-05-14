package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.unauthorisedadults.dnnr.R;

public class HomeFragment extends Fragment {

    Button signIn, joinGroup, startGroup;

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



        setupButtons(view);
    }

    private void setupButtons(View view) {
        signIn = view.findViewById(R.id.signIn);
        signIn.setOnClickListener(btn -> signIn());

        joinGroup = view.findViewById(R.id.joinGroup);
        joinGroup.setOnClickListener(btn -> joinGroup());

        startGroup = view.findViewById(R.id.StartGroup);
        startGroup.setOnClickListener(btn -> startGroup());
    }

    private void signIn() {

    }

    private void joinGroup() {

    }

    private void startGroup() {

    }

}


