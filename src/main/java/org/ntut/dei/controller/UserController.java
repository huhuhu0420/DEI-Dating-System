package org.ntut.dei.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.ntut.dei.dto.UserData;
import org.ntut.dei.matching.BiDirectionalStrategy;
import org.ntut.dei.matching.MatchingEngine;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class UserController {
    public List<UserData> match(UserData userRequest) {
        User user = createUser(userRequest);
        List<User> users = UserFactory.getUsers();

        String matchStrategy = userRequest.getMatchStrategy();
        MatchingEngine matchingEngine = new MatchingEngine(users);

        if (matchStrategy != null) {
            if (matchStrategy.equals("custom")) {
                matchingEngine.setMatchStrategy(new BiDirectionalStrategy());
            }
        }

        List<User> matches = matchingEngine.match(user);

        // sort with user.isPremium() first, then by user.getUsername()
        matches.sort((u1, u2) -> {
            if (u1.isPremium() && !u2.isPremium()) {
                return -1;
            } else if (!u1.isPremium() && u2.isPremium()) {
                return 1;
            } else {
                return u1.getUsername().compareTo(u2.getUsername());
            }
        });

        List<UserData> matchedUsers = matches.stream().map(UserData::fromUser).collect(Collectors.toList());

        return matchedUsers;
    }

    public User createUser(UserData userRequest) {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        PreferenceProfileBuilder preferenceProfileBuilder = new PreferenceProfileBuilder();

        userProfileBuilder.setName(userRequest.getName());
        userProfileBuilder.setAge(userRequest.getAge());
        userProfileBuilder.setGenderIdentity(userRequest.getGenderIdentity());
        if (userRequest.getSexualOrientation() != null) {
            userProfileBuilder.setSexualOrientation(userRequest.getSexualOrientation());
        }
        if (userRequest.getBio() != null) {
            userProfileBuilder.setBio(userRequest.getBio());
        }
        if (userRequest.getInterests() != null) {
            userProfileBuilder.setInterests(userRequest.getInterests());
        }
        if (userRequest.getPreferedGenderIdentity() != null) {
            preferenceProfileBuilder.setPreferedGenderIdentity(userRequest.getPreferedGenderIdentity());
        }
        if (userRequest.getPreferedMinAge() != 0) {
            preferenceProfileBuilder.setAgeRange(userRequest.getPreferedMinAge(), userRequest.getPreferedMaxAge());
        }
        if (userRequest.getPreferedInterests() != null) {
            preferenceProfileBuilder.setPreferedInterests(userRequest.getPreferedInterests());
        }

        UserProfile userProfile = userProfileBuilder.build();
        PreferenceProfile preferenceProfile = preferenceProfileBuilder.build();
        userProfile.setPreferenceProfile(preferenceProfile);

        User user = UserFactory.createUser(userRequest.getName(), userProfile, false);
        return user;
    }

}
