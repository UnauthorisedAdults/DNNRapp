/*
 *  MatchHandlerService
 *
 *  Det er klasse er lavet med henblik på at 'en' af deltagerne
 *  opretter en gruppe de andre kan deltage i. Hvis deltageren
 *  er host, så skal denne klasse styre om der er match eller
 *  ej. Ved match sendes besked til andre eller ???
 */
package com.unauthorisedadults.dnnr.services;

import androidx.annotation.RestrictTo;

import com.unauthorisedadults.dnnr.models.AffirmativeSwipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchHandlerService {

    private static MatchHandlerService instance;
    private List<String> participants;
    private List<AffirmativeSwipe> affirmativeList;
    private int matchId;

    private MatchHandlerService() {
        participants = new ArrayList<>();
        affirmativeList = new ArrayList<>();
    }

    public void addParticipant(String participant) {
        participants.add(participant);
    }

    public static MatchHandlerService getInstance() {
        if (instance == null) {
            instance = new MatchHandlerService();
        }
        return instance;
    }

    public List<String> getParticipants() {
        return new ArrayList<>(participants);
    }

    public void addAffirmative(int id) {
        if (!findAffirmativeAndVote(id))
        {
            affirmativeList.add(new AffirmativeSwipe(id));
        }
    }

    private boolean findAffirmativeAndVote(int id) {
        for (AffirmativeSwipe affirmative : affirmativeList)
        {
            if (affirmative.getId() == id)
            {
                affirmative.addVote();
                return true;
            }
        }

        return false;
    }

    public boolean isMatch() {
        // Hvis mindre end to deltagere, giver isMatch ikke mening!
        /*if (participants.size() < 2)
        {
            return false;
        }*/

        for (AffirmativeSwipe affirmative : affirmativeList) {
            if (affirmative.getVotes() == participants.size())
            {
                matchId = affirmative.getId();
                return true;
            }
        }

        return false;
    }

    public int getMatchId() {
        return matchId;
    }

    public List<AffirmativeSwipe> topAffirmatives() {
        Collections.sort(affirmativeList);
        Collections.reverse(affirmativeList);

        return affirmativeList;
    }

    @RestrictTo(RestrictTo.Scope.TESTS)
    public void clearListsForTesting() {
        participants = new ArrayList<>();
        affirmativeList = new ArrayList<>();
    }
}
