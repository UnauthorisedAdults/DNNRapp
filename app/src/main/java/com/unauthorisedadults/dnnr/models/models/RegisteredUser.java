package com.unauthorisedadults.dnnr.models.models;

public class RegisteredUser extends User {
    private String password;
    private int userId;

    public RegisteredUser() {
    }

    public RegisteredUser(String username, String password) {
        super(username);
        this.password = password;
    }

    public RegisteredUser(int userId, String username, String password, String role) {
        super(username, role);
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }
}
