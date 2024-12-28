package org.ntut.dei.service;

import java.util.List;
import java.util.stream.Collectors;

import org.ntut.dei.dto.UserData;
import org.ntut.dei.dto.UserMapper;
import org.ntut.dei.matching.BiDirectionalStrategy;
import org.ntut.dei.matching.MatchingEngine;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.specifications.SpecificationBuilder;

public class UserService {
    public List<UserData> match(UserData userRequest) {
        User user = UserMapper.toEntity(userRequest);
        List<User> users = UserFactory.getUsers();

        String matchStrategy = userRequest.getMatchStrategy();
        MatchingEngine matchingEngine = new MatchingEngine(users);

        if (matchStrategy != null && matchStrategy.equals("bidirectional")) {
            matchingEngine.setMatchStrategy(new BiDirectionalStrategy());
        }

        SpecificationBuilder specificationBuilder = new SpecificationBuilder();

        List<User> matches = matchingEngine.match(user, specificationBuilder);

        // sort with user.isPremium()
        matches.sort((u1, u2) -> {
            if (u1.isPremium() && !u2.isPremium()) {
                return -1;
            } else if (!u1.isPremium() && u2.isPremium()) {
                return 1;
            }
            return 0;
        });

        List<UserData> matchedUsers = matches.stream().map(UserMapper::toDTO).collect(Collectors.toList());

        return matchedUsers;
    }

    public User createUser(UserData userRequest) {
        User user = UserMapper.toEntity(userRequest);
        UserFactory.addUser(user);
        return user;
    }

}
