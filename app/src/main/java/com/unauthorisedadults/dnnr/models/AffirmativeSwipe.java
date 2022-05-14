package com.unauthorisedadults.dnnr.models;

public class AffirmativeSwipe implements Comparable<AffirmativeSwipe>{
    private int id;
    private int votes;

    public AffirmativeSwipe(int id) {
        this.id = id;
        this.votes = 1;
    }

    public AffirmativeSwipe(int id, int votes) {
        this.id = id;
        this.votes = votes;
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

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public int compareTo(AffirmativeSwipe affirmativeSwipe) {
        return this.getVotes() - affirmativeSwipe.getVotes();
    }
}
