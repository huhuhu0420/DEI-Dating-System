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

        return user;
    }

    public static User createUser(UserProfile userProfile, boolean isPremium) {
        User user;
        if (isPremium) {
            user = new PremiumUser(userProfile);
        } else {
            user = new BasicUser(userProfile);
        }

        return user;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void clearUsers() {
        users.clear();
    }

    public static void addUser(User user) {
        users.add(user);
    }
}
