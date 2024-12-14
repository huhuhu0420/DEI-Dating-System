package org.ntut.dei.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.ntut.dei.dto.UserData;
import org.ntut.dei.matching.BiDirectionalStrategy;
import org.ntut.dei.matching.MatchingEngine;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;

public class UserController {
    public List<UserData> match(UserData userRequest) {
        User user = userRequest.toUser();
        List<User> users = UserFactory.getUsers();

        String matchStrategy = userRequest.getMatchStrategy();
        MatchingEngine matchingEngine = new MatchingEngine(users);

        if (matchStrategy != null) {
            if (matchStrategy.equals("custom")) {
                matchingEngine.setMatchStrategy(new BiDirectionalStrategy());
            }
        }

        List<User> matches = matchingEngine.match(user);

        // sort with user.isPremium()
        matches.sort((u1, u2) -> {
            if (u1.isPremium() && !u2.isPremium()) {
                return -1;
            } else if (!u1.isPremium() && u2.isPremium()) {
                return 1;
            }
            return 0;
        });

        List<UserData> matchedUsers = matches.stream().map(UserData::fromUser).collect(Collectors.toList());

        return matchedUsers;
    }

    public User createUser(UserData userRequest) {
        User user = userRequest.toUser();
        UserFactory.addUser(user);
        return user;
    }

}
