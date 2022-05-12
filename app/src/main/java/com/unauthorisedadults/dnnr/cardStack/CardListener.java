package com.unauthorisedadults.dnnr.cardStack;

import com.wenchao.cardstack.CardStack;

public class CardListener implements CardStack.CardEventListener {

    private final CardEventHandler eventHandler = CardEventHandler.getInstance();

    @Override
    public boolean swipeEnd(int section, float distance) {

        return distance > 300;
    }

    @Override
    public boolean swipeStart(int section, float distance) {
        System.out.println("HERE: " + section);

        return false;
    }

    @Override
    public boolean swipeContinue(int section, float distanceX, float distanceY) {
        return section == 1 || section == 3;
    }

    @Override
    public void discarded(int mIndex, int direction) {

    }


    @Override
    public void topCardTapped() {

    }
}
