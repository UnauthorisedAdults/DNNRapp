package com.unauthorisedadults.dnnr.cardStack;

import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;

import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.services.MatchHandlerService;
import com.unauthorisedadults.dnnr.viewModels.VoteViewModel;
import com.wenchao.cardstack.CardStack;

public class CardListener implements CardStack.CardEventListener {

    private final MatchHandlerService matchHandlerService = MatchHandlerService.getInstance();
    private final VoteViewModel viewModel;

    private int votesMade;

    @ColorInt
    private int bgColour;

    public CardListener(VoteViewModel viewModel) {
        this.viewModel = viewModel;
        votesMade = 0;
        bgColour = Color.WHITE;
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
        @ColorInt
        int red = viewModel.getColours()[0];
        @ColorInt
        int green = viewModel.getColours()[1];

        int alpha = calculateAlpha(distanceX);

        try {
            if (section == 1 || section == 3)
                bgColour = ColorUtils.setAlphaComponent(green, alpha);
            else
                bgColour = ColorUtils.setAlphaComponent(red, alpha);
        }
        catch (IllegalArgumentException e)
        {
            if (section == 1 || section == 3)
                bgColour = ColorUtils.setAlphaComponent(green, 255);
            else
                bgColour = ColorUtils.setAlphaComponent(red, 255);
        }

        viewModel.setBgColour(bgColour);
        System.out.println("****** X: " + distanceX + " ****** Y: " + distanceY + " ****** COLOUR: " + bgColour + " ******");
        return section == 1 || section == 3;
    }

    private int calculateAlpha(float distance) {
        float OLD = distance / 600;
        float NEW = 255 * OLD;
        return Math.round(NEW);
    }

    @Override
    public void discarded(int mIndex, int direction) {
        votesMade++;
        if (direction == 1 || direction == 3) {
            matchHandlerService.addAffirmative(mIndex);
        }

        if (matchHandlerService.isMatch()) {
            viewModel.matched(matchHandlerService.getMatchId());
        }

        if (votesMade % 9 == 0) {
            viewModel.requestRecipes();
        }

        bgColour = Color.WHITE;
        viewModel.setBgColour(bgColour);
    }

    @Override
    public void topCardTapped() {

    }
}
