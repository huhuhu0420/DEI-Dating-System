package org.ntut.dei.models;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {
    private static List<User> users = new ArrayList<>();

    private UserFactory() {
    }

    public static User createUser(String username, UserProfile userProfile, boolean isPremium) {
        User user;
        if (isPremium) {
            user = new PremiumUser(username, userProfile);
        } else {
            user = new BasicUser(username, userProfile);
        }

        users.add(user);
        return user;
    }

    public static User createUser(UserProfile userProfile, boolean isPremium) {
        User user;
        if (isPremium) {
            user = new PremiumUser(userProfile);
        } else {
            user = new BasicUser(userProfile);
        }

        users.add(user);
        return user;
    }

    public static List<User> getUsers() {
        return users;
    }
}
