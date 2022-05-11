package com.unauthorisedadults.dnnr.cardStack;

import com.unauthorisedadults.dnnr.network.BusinessConnection;

public class CardEventHandler {

    private static final CardEventHandler instance = new CardEventHandler();

    private CardEventHandler() {}

    public static CardEventHandler getInstance() {
        return instance;
    }

    public void registerVote(int index) {
        BusinessConnection.getInstance().CastVote("AQGSYD", index);
    }
}
