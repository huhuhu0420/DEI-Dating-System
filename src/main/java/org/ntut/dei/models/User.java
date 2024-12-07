package org.ntut.dei.models;

public class User {
    String username;
    UserProfile userProfile;

    public User(String username, UserProfile userProfile) {
        this.username = username;
        this.userProfile = userProfile;
    }

    public User(UserProfile userProfile) {
        this.userProfile = userProfile;
        this.username = userProfile.getName();
    }

    public String getUsername() {
        return username;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }
}