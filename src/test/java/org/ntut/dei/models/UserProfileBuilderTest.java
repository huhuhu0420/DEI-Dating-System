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
                .setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE))
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                .setBio("testBio")
                .setInterests(interests)
                .build();

        assertEquals("testName", userProfile.getName());
        assertEquals(20, userProfile.getAge());
        assertEquals(GenderIdentityEnum.MALE, userProfile.getGenderIdentity().getGenderIdentityEnum());
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
        assertEquals(GenderIdentityEnum.OTHER, userProfile.getGenderIdentity().getGenderIdentityEnum());
        assertEquals(SexualOrientation.OTHER, userProfile.getSexualOrientation());
        assertEquals("", userProfile.getBio());
        assertEquals(null, userProfile.getInterests());
    }

    @Test
    public void testCustomIdentity() {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        List<String> interests = List.of("testInterest", "testInterest2");
        GenderIdentity customIdentity = new GenderIdentity(GenderIdentityEnum.CUSTOM, "testCustomIdentity");
        UserProfile userProfile = userProfileBuilder
                .setName("testName")
                .setAge(20)
                .setGenderIdentity(customIdentity)
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                .setBio("testBio")
                .setInterests(interests)
                .build();

        assertEquals("testName", userProfile.getName());
        assertEquals(20, userProfile.getAge());
        assertEquals(GenderIdentityEnum.CUSTOM, userProfile.getGenderIdentity().getGenderIdentityEnum());
        assertEquals("testCustomIdentity", userProfile.getGenderIdentity().getGenderIdentity());
        assertEquals(SexualOrientation.HETEROSEXUAL, userProfile.getSexualOrientation());
        assertEquals("testBio", userProfile.getBio());
        assertEquals(interests, userProfile.getInterests());
    }
}
