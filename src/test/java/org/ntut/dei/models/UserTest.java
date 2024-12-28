package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User basicUser;
    private User premiumUser;
    private UserProfile userProfile;

    @BeforeEach
    public void setUp() {
        userProfile = new UserProfileBuilder().setAge(30).setName("testName")
                .setGenderIdentityWithEnum(GenderIdentityEnum.MALE)
                .setBio("bio")
                .setInterests(List.of("interest1", "interest2")).build();
        basicUser = new BasicUser("testUsername", userProfile);
        premiumUser = new PremiumUser("testUsername", userProfile);
    }

    @Test
    public void testBasicUser() {
        assertEquals("testUsername", basicUser.getUsername());
        assertEquals(userProfile, basicUser.getUserProfile());
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append("testUsername").append("\n");
        sb.append("Bio: ").append("bio").append("\n");
        sb.append("Interests: ").append(List.of("interest1", "interest2")).append("\n");
        sb.append("Age: ").append(30).append("\n");
        assertEquals(sb.toString(), basicUser.getDescription());
        assertEquals(false, basicUser.isPremium());
    }

    @Test
    public void testPremiumUser() {
        assertEquals("testUsername", premiumUser.getUsername());
        assertEquals(userProfile, premiumUser.getUserProfile());
        StringBuilder sb = new StringBuilder();
        sb.append("*** PREMIUM USER ***\n");
        sb.append("Username: ").append("testUsername").append("\n");
        sb.append("Bio: ").append("bio").append("\n");
        sb.append("Interests: ").append(List.of("interest1", "interest2")).append("\n");
        sb.append("Age: ").append(30).append("\n");
        assertEquals(sb.toString(), premiumUser.getDescription());
        assertEquals(true, premiumUser.isPremium());
    }
}
