package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UserProfileBuilderTest {
    @Test
    public void testUserProfileBuilder() {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        List<String> interests = List.of("testInterest", "testInterest2");
        UserProfile userProfile = userProfileBuilder
                .setName("testName")
                .setAge(20)
                .setGenderIdentity(GenderIdentity.MALE)
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                .setBio("testBio")
                .setInterests(interests)
                .build();

        assertEquals("testName", userProfile.getName());
        assertEquals(20, userProfile.getAge());
        assertEquals(GenderIdentity.MALE, userProfile.getGenderIdentity());
        assertEquals(SexualOrientation.HETEROSEXUAL, userProfile.getSexualOrientation());
        assertEquals("testBio", userProfile.getBio());
        assertEquals(interests, userProfile.getInterests());
    }

    @Test
    public void testUserProfileBuilderWithDefaultValues() {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        UserProfile userProfile = userProfileBuilder.build();

        assertEquals("", userProfile.getName());
        assertEquals(0, userProfile.getAge());
        assertEquals(GenderIdentity.OTHER, userProfile.getGenderIdentity());
        assertEquals(SexualOrientation.OTHER, userProfile.getSexualOrientation());
        assertEquals("", userProfile.getBio());
        assertEquals(null, userProfile.getInterests());
    }
}
