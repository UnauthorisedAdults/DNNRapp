package com.unauthorisedadults.dnnr.cardStack;

import com.unauthorisedadults.dnnr.services.MatchHandlerService;
import com.unauthorisedadults.dnnr.viewModels.VoteViewModel;
import com.wenchao.cardstack.CardStack;

public class CardListener implements CardStack.CardEventListener {

    private final MatchHandlerService matchHandlerService = MatchHandlerService.getInstance();
    private final VoteViewModel viewModel;

    private int votesMade;

    public CardListener(VoteViewModel viewModel)
    {
        this.viewModel = viewModel;
        votesMade = 0;
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
        votesMade++;
        if (direction == 1 || direction == 3)
        {
            matchHandlerService.addAffirmative(mIndex);
        }

        if (matchHandlerService.isMatch())
        {
            viewModel.matched(matchHandlerService.getMatchId());
        }

        if (votesMade % 9 == 0)
        {
            viewModel.requestRecipes();
        }
        System.out.println("****** INDEX: " + mIndex + " ****** TOTALVOTES: " + votesMade + " ******");
    }

    @Override
    public void topCardTapped() {

    }
}
