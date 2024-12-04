package org.ntut.dei.models;

public class User {
    String username;
    UserProfile userProfile;

    public User(String username, UserProfile userProfile) {
        this.username = username;
        this.userProfile = userProfile;
    }

    public String getUsername() {
        return username;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }
}