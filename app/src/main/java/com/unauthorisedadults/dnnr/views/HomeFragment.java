package com.unauthorisedadults.dnnr.views;

import android.annotation.SuppressLint;
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

import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.data.UserRepository;
import com.unauthorisedadults.dnnr.viewModels.HomeViewModel;

public class HomeFragment extends Fragment {

    private NavController navController;
    private HomeViewModel viewModel;
    private TextView username;

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
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        username = view.findViewById(R.id.username);

        setDisplayName();
        setupButtons(view);
    }

    @SuppressLint("SetTextI18n")
    private void setDisplayName() {
        FirebaseUser user = viewModel.getCurrentUser();

        if (user == null) {
            username.setText("Guest");
        } else {
            username.setText(user.getDisplayName());
        }
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


