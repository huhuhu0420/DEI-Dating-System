package org.ntut.dei.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.dto.UserData;
import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;

public class UserServiceTest {

    private UserService userService;
    private UserData userData;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
        userData = new UserData();
        userData.setAge(25);
        userData.setName("Alice");
        userData.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE));
        userData.setSexualOrientation(SexualOrientation.HOMOSEXUAL);
        userData.setInterests(Arrays.asList("Reading", "Swimming"));
        userData.setPremium(true);
        userService.createUser(userData);
    }

    @Test
    public void testCreateUser() {
        userData = new UserData();
        userData.setAge(25);
        userData.setName("Alice");
        userData.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE));
        userData.setSexualOrientation(SexualOrientation.HOMOSEXUAL);
        userData.setInterests(Arrays.asList("Reading", "Swimming"));
        userData.setPremium(false);
        User user = userService.createUser(userData);
        userData = new UserData();
        userData.setAge(25);
        userData.setName("Alice");
        userData.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE));
        userData.setSexualOrientation(SexualOrientation.HOMOSEXUAL);
        userData.setInterests(Arrays.asList("Reading", "Swimming"));
        userData.setPremium(false);
        User user2 = userService.createUser(userData);
        userData = new UserData();
        userData.setAge(25);
        userData.setName("Alice");
        userData.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE));
        userData.setSexualOrientation(SexualOrientation.HOMOSEXUAL);
        userData.setInterests(Arrays.asList("Reading", "Swimming"));
        userData.setPremium(true);
        User user3 = userService.createUser(userData);
        assertNotNull(user);
        assertNotNull(user2);
        assertNotNull(user3);
    }

    @Test
    public void testMatchWithBidirectionalStrategy() {
        userData.setMatchStrategy("bidirectional");
        // Set necessary fields in userRequest

        List<UserData> result = userService.match(userData);
        assertNotNull(result);
        // Add more assertions based on expected behavior
    }

    @Test
    public void testMatchWithoutBidirectionalStrategy() {
        userData.setMatchStrategy("unidirectional");
        // Set necessary fields in userRequest

        List<UserData> result = userService.match(userData);
        assertNotNull(result);
        // Add more assertions based on expected behavior
    }
}