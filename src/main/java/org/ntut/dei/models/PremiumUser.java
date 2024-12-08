package org.ntut.dei.models;

public class PremiumUser implements User {
    private String username;
    private UserProfile userProfile;

    public PremiumUser(String username, UserProfile userProfile) {
        this.username = username;
        this.userProfile = userProfile;
    }

    public PremiumUser(UserProfile userProfile) {
        this.username = userProfile.getName();
        this.userProfile = userProfile;
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
        sb.append("*** PREMIUM USER ***\n");
        sb.append("Username: ").append(username).append("\n");
        sb.append("Bio: ").append(userProfile.getBio()).append("\n");
        sb.append("Interests: ").append(userProfile.getInterests()).append("\n");
        sb.append("Age: ").append(userProfile.getAge()).append("\n");

        return sb.toString();
    }

    @Override
    public boolean isPremium() {
        return true;
    }
}
