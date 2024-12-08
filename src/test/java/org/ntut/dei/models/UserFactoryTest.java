package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserFactoryTest {
    @Test
    public void testCreateUser() {
        UserFactory userFactory = new UserFactory();
        UserProfile userProfile = new UserProfileBuilder().build();
        User user = userFactory.createUser("testUsername", userProfile, false);

        assertEquals("testUsername", user.getUsername());
        assertFalse(user.isPremium());

        User user2 = userFactory.createUser("testUsername", userProfile, true);

        assertEquals("testUsername", user2.getUsername());
        assertTrue(user2.isPremium());
    }
}
