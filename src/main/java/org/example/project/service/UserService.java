package org.example.project.service;

import org.example.project.entity.User;

public class UserService {

    public User createUser(String username, String email) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        if (username.matches(".*\\s.*")) {
            throw new IllegalArgumentException("Username cannot contain spaces");
        }
        return new User(username.trim(), email.trim(), true);
    }
}