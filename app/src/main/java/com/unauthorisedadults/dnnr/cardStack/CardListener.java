package com.unauthorisedadults.dnnr.cardStack;

import androidx.lifecycle.ViewModelProvider;

import com.unauthorisedadults.dnnr.services.MatchHandlerService;
import com.unauthorisedadults.dnnr.viewModels.VoteActivityViewModel;
import com.wenchao.cardstack.CardStack;

public class CardListener implements CardStack.CardEventListener {

    private final MatchHandlerService matchHandlerService = MatchHandlerService.getInstance();
    private final VoteActivityViewModel viewModel;

    public CardListener(VoteActivityViewModel viewModel)
    {
        super();
        this.viewModel = viewModel;
    }

    @Override
    public boolean swipeEnd(int section, float distance) {

        return distance > 300;
    }

    @Override
    public boolean swipeStart(int section, float distance) {

        return false;
    }

    @Override
    public boolean swipeContinue(int section, float distanceX, float distanceY) {
        return section == 1 || section == 3;
    }

    @Override
    public void discarded(int mIndex, int direction) {
        if (direction == 1 || direction == 3)
        {
            matchHandlerService.addAffirmative(mIndex);
            if (matchHandlerService.isMatch())
            {
                viewModel.matched(matchHandlerService.getMatchId());
            }
        }
    }

    @Override
    public void topCardTapped() {

    }
}
