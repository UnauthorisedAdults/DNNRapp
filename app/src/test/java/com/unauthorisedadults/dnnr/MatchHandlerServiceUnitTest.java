package com.unauthorisedadults.dnnr;

import static org.junit.Assert.assertEquals;

import com.unauthorisedadults.dnnr.models.AffirmativeSwipe;
import com.unauthorisedadults.dnnr.services.MatchHandlerService;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MatchHandlerServiceUnitTest {

   /* // Test der viser man kan tilføje en deltager til en deltagerliste
    @Test
    public void addParticipantsToParticipantsList()
    {
        MatchHandlerService matchHandlerServiceService = new MatchHandlerService();
        String participant = "Jack";

        matchHandlerServiceService.addParticipant(participant);
        List<String> participants = matchHandlerServiceService.getParticipants();

        assertEquals(participant, participants.get(0));
    }

    @Test
    public void noMatchWhenLessThanTwoParticipants()
    {
        MatchHandlerService matchHandlerServiceService = new MatchHandlerService();

        String participant = "Jack";

        matchHandlerServiceService.addParticipant(participant);

        matchHandlerServiceService.addAffirmative(42);

        boolean isMatch = matchHandlerServiceService.isMatch();

        assertEquals(false, isMatch);
    }

    //  Test der viser match mellem deltagerne
    @Test
    public void matchFoundBetweenTwoParticipants()
    {
        MatchHandlerService matchHandlerServiceService = new MatchHandlerService();

        String participant1 = "Jack";
        String participant2 = "Black";

        matchHandlerServiceService.addParticipant(participant1);
        matchHandlerServiceService.addParticipant(participant2);

        matchHandlerServiceService.addAffirmative(21);
        matchHandlerServiceService.addAffirmative(42);
        matchHandlerServiceService.addAffirmative(42);
        // id 2 har two stemmer fra lige så mange deltagere => match

        boolean isMatch = matchHandlerServiceService.isMatch();
        int matchId = matchHandlerServiceService.getMatchId();

        assertEquals(true, isMatch);
        assertEquals(42, matchId);
    }

    //  Giv en top 5 liste, antager der ikke er match
    @Test
    public void returnATop5List()
    {
        MatchHandlerService matchHandlerServiceService = new MatchHandlerService();

        String participant1 = "Jack";
        String participant2 = "Black";
        String participant3 = "Jane";
        String participant4 = "White";
        String participant5 = "Joe";
        String participant6 = "Pink";

        matchHandlerServiceService.addParticipant(participant1);
        matchHandlerServiceService.addParticipant(participant2);
        matchHandlerServiceService.addParticipant(participant3);
        matchHandlerServiceService.addParticipant(participant4);
        matchHandlerServiceService.addParticipant(participant5);
        matchHandlerServiceService.addParticipant(participant6);

        matchHandlerServiceService.addAffirmative(21);

        matchHandlerServiceService.addAffirmative(42);
        matchHandlerServiceService.addAffirmative(42);
        matchHandlerServiceService.addAffirmative(42);
        matchHandlerServiceService.addAffirmative(42);
        matchHandlerServiceService.addAffirmative(42);

        matchHandlerServiceService.addAffirmative(404);
        matchHandlerServiceService.addAffirmative(404);
        matchHandlerServiceService.addAffirmative(404);

        matchHandlerServiceService.addAffirmative(500);
        matchHandlerServiceService.addAffirmative(500);
        matchHandlerServiceService.addAffirmative(500);
        matchHandlerServiceService.addAffirmative(500);

        matchHandlerServiceService.addAffirmative(22);
        matchHandlerServiceService.addAffirmative(22);

        List<AffirmativeSwipe> affirmatives = new ArrayList<>();
        affirmatives.add(new AffirmativeSwipe(42, 5));
        affirmatives.add(new AffirmativeSwipe(500, 4));
        affirmatives.add(new AffirmativeSwipe(404, 3));
        affirmatives.add(new AffirmativeSwipe(22, 2));
        affirmatives.add(new AffirmativeSwipe(21, 1));

        List<AffirmativeSwipe> topList = matchHandlerServiceService.topAffirmatives();

        assertEquals(affirmatives.get(0).getId(), topList.get(0).getId());
        assertEquals(affirmatives.get(0).getVotes(), topList.get(0).getVotes());

        assertEquals(affirmatives.get(1).getId(), topList.get(1).getId());
        assertEquals(affirmatives.get(1).getVotes(), topList.get(1).getVotes());

        assertEquals(affirmatives.get(2).getId(), topList.get(2).getId());
        assertEquals(affirmatives.get(2).getVotes(), topList.get(2).getVotes());

        assertEquals(affirmatives.get(3).getId(), topList.get(3).getId());
        assertEquals(affirmatives.get(3).getVotes(), topList.get(3).getVotes());

        assertEquals(affirmatives.get(4).getId(), topList.get(4).getId());
        assertEquals(affirmatives.get(4).getVotes(), topList.get(4).getVotes());
    } */
}
