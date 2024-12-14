package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testUser() {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        UserProfile userProfile = userProfileBuilder.build();
        User user = new BasicUser("testUsername", userProfile);

        assertEquals("testUsername", user.getUsername());
        assertEquals(userProfile, user.getUserProfile());
    }
}
