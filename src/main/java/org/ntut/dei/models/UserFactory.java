package org.ntut.dei.models;

public class UserFactory {
    public User createUser(String username, UserProfile userProfile, boolean isPremium) {
        if (isPremium) {
            return new PremiumUser(username, userProfile);
        } else {
            return new BasicUser(username, userProfile);
        }
    }
}
