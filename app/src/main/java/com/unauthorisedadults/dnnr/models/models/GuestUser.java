package com.unauthorisedadults.dnnr.models.models;

public class GuestUser extends User {
    public GuestUser(String username) {
        super(username, "Guest");
    }
}
