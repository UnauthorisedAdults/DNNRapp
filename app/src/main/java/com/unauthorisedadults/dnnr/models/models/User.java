package com.unauthorisedadults.dnnr.models.models;

public class User {
    private String username;
    private String role;

    public User() {
    }

    public User(String name) {
        this.username = name;
    }

    public User(String name, String role) {
        this.username = name;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
