package org.ntut.dei.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.ntut.dei.dto.UserRequest;
import org.ntut.dei.matching.BiDirectionalStrategy;
import org.ntut.dei.matching.MatchingEngine;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class UserController {
    public List<String> match(UserRequest userRequest) {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        PreferenceProfileBuilder preferenceProfileBuilder = new PreferenceProfileBuilder();

        userProfileBuilder.setName(userRequest.getName());
        userProfileBuilder.setAge(userRequest.getAge());
        userProfileBuilder.setGenderIdentity(userRequest.getGenderIdentity().getGenderIdentityEnum(),
                userRequest.getGenderIdentity().getGenderIdentity());
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

        User user = UserFactory.createUser(userProfile, false);
        List<User> users = new ArrayList<>();

        String matchStrategy = userRequest.getMatchStrategy();
        MatchingEngine matchingEngine = new MatchingEngine(users);

        if (matchStrategy != null) {
            if (matchStrategy.equals("custom")) {
                matchingEngine.setMatchStrategy(new BiDirectionalStrategy());
            }
        }

        List<User> matches = matchingEngine.match(user);

        return matches.stream()
                .map(User::getDescription)
                .collect(Collectors.toList());
    }
}
