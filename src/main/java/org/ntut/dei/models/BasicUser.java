package org.ntut.dei.models;

public class BasicUser implements User {
    String username;
    UserProfile userProfile;

    public BasicUser(String username, UserProfile userProfile) {
        this.username = username;
        this.userProfile = userProfile;
    }

    public BasicUser(UserProfile userProfile) {
        this.userProfile = userProfile;
        this.username = userProfile.getName();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public UserProfile getUserProfile() {
        return userProfile;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(username).append("\n");
        sb.append("Bio: ").append(userProfile.getBio()).append("\n");
        sb.append("Interests: ").append(userProfile.getInterests()).append("\n");
        sb.append("Age: ").append(userProfile.getAge()).append("\n");

        return sb.toString();
    }

    @Override
    public boolean isPremium() {
        return false;
    }
}
