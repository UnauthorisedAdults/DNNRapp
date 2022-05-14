/*
 *  MatchHandlerService
 *
 *  Det er klasse er lavet med henblik på at 'en' af deltagerne
 *  opretter en gruppe de andre kan deltage i. Hvis deltageren
 *  er host, så skal denne klasse styre om der er match eller
 *  ej. Ved match sendes besked til andre eller ???
 */
package com.unauthorisedadults.dnnr.services;

import com.unauthorisedadults.dnnr.models.AffirmativeSwipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MatchHandlerService {
    private List<String> participants;
    private List<AffirmativeSwipe> affirmativeList;
    private int matchId;

    public MatchHandlerService() {
        participants = new ArrayList<>();
        affirmativeList = new ArrayList<>();
    }

    public void addParticipant(String participant) {
        participants.add(participant);
    }


    public List<String> getParticipants() {
        List<String> returnList = new ArrayList<>();

        returnList.addAll(participants);

        return returnList;
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
        // Hvis mindre end to deltagere giver isMatch ikke mening!
        if (participants.size() < 2)
        {
            return false;
        }

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
        Collections.sort(affirmativeList, Comparator.comparing(AffirmativeSwipe::getVotes).reversed());

        return affirmativeList;
    }
}
