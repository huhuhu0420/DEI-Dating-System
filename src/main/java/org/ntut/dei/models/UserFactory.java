package org.ntut.dei.models;

public class UserFactory {
    private UserFactory() {
    }

    public static User createUser(String username, UserProfile userProfile, boolean isPremium) {
        if (isPremium) {
            return new PremiumUser(username, userProfile);
        } else {
            return new BasicUser(username, userProfile);
        }
    }

    public static User createUser(UserProfile userProfile, boolean isPremium) {
        if (isPremium) {
            return new PremiumUser(userProfile);
        } else {
            return new BasicUser(userProfile);
        }
    }
}
