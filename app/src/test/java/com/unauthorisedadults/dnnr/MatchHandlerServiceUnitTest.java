package com.unauthorisedadults.dnnr;

import static org.junit.Assert.assertEquals;

import com.unauthorisedadults.dnnr.services.MatchHandlerService;

import org.junit.Test;

import java.util.List;

public class MatchHandlerServiceUnitTest {

    // Test der viser man kan tilføje en deltager til en deltagerliste
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

}
