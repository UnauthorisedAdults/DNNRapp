package com.unauthorisedadults.dnnr.models;

public class AffirmativeSwipe {
    int id;
    int votes;

    public AffirmativeSwipe(int id) {
        this.id = id;
        this.votes = 1;
    }

    public int getId() {
        return id;
    }

    public void addVote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }
}
