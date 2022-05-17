package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.cardStack.CardListener;
import com.unauthorisedadults.dnnr.cardStack.CardsDataAdapter;
import com.unauthorisedadults.dnnr.models.models.Recipe;
import com.unauthorisedadults.dnnr.viewModels.VoteViewModel;
import com.wenchao.cardstack.CardStack;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class VoteFragment extends Fragment {

    private NavController navController;
    private CardStack mCardStack;
    private CardsDataAdapter mCardAdapter;
    private VoteViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vote_frag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(VoteViewModel.class);
        navController = Navigation.findNavController(view);

        mCardStack = view.findViewById(R.id.vote_cardstack);
        mCardStack.setContentResource(R.layout.card);
        mCardStack.setListener(new CardListener(viewModel));
        mCardStack.setStackMargin(20);

        ArrayList<Recipe> testRecipes = new ArrayList<>();
        try {
            testRecipes.add(new Recipe("Tamiya", "https://www.themealdb.com/images/media/meals/n3xxd91598732796.jpg", "Vegetarian"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        mCardAdapter = new CardsDataAdapter(view.getContext(), viewModel);
        viewModel.setCardAdapter(mCardAdapter);
        viewModel.requestRecipes();
        mCardStack.setAdapter(mCardAdapter);

        observeMatch();
    }

    private void observeMatch() {
        viewModel.broadcastMatch().observeForever(recipe -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("recipe", recipe);
            navController.navigate(R.id.match_fragment, bundle);
        });
    }
}
