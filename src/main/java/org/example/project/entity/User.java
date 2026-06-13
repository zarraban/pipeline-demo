package org.example.project.entity;

public class User {
    private final String username;
    private final String email;

    public User(String username, String email, boolean isActive) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
}