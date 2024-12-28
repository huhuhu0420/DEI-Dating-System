package org.ntut.dei.matching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;
import org.ntut.dei.specifications.SpecificationBuilder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class MatchingEngineTest {

    private MatchingEngine matchingEngine;
    private User alex;
    private User alice;
    private User bob;

    @BeforeEach
    void setUp() {
        UserProfile alexProfile = new UserProfileBuilder()
                .setName("Alex")
                .setAge(20)
                .setGenderIdentityWithEnum(GenderIdentityEnum.MALE)
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                .setInterests(List.of("Music"))
                .build();
        PreferenceProfile alexPreference = new PreferenceProfileBuilder()
                .setAgeRange(18, 25)
                .setPreferedGenderIdentityWithEnum(List.of(GenderIdentityEnum.FEMALE))
                .addPreferenceGenderIdentityWithEnum(GenderIdentityEnum.CUSTOM, "Helicopter")
                .setPreferedInterests(List.of("Music", "Movies"))
                .build();
        alexProfile.setPreferenceProfile(alexPreference);
        alex = UserFactory.createUser(alexProfile, false);

        UserProfile aliceProfile = new UserProfileBuilder()
                .setName("Alice")
                .setAge(22)
                .setGenderIdentity(GenderIdentityEnum.CUSTOM, "Helicopter")
                .setSexualOrientation(SexualOrientation.PANSEXUAL)
                .setInterests(List.of("Music"))
                .build();
        PreferenceProfile alicePreference = new PreferenceProfileBuilder()
                .setAgeRange(10, 30)
                .setPreferedInterests(List.of("Music", "Movies"))
                .build();
        aliceProfile.setPreferenceProfile(alicePreference);
        alice = UserFactory.createUser(aliceProfile, true);

        UserProfile bobProfile = new UserProfileBuilder()
                .setName("Bob")
                .setAge(25)
                .setGenderIdentityWithEnum(GenderIdentityEnum.FEMALE)
                .setInterests(List.of("Movies"))
                .build();
        PreferenceProfile bobPreference = new PreferenceProfileBuilder()
                .setAgeRange(20, 30)
                .addPreferenceGenderIdentityWithEnum(GenderIdentityEnum.CUSTOM, "Airplane")
                .build();
        bobProfile.setPreferenceProfile(bobPreference);
        bob = UserFactory.createUser(bobProfile, false);

        List<User> users = List.of(alex, alice, bob);
        matchingEngine = new MatchingEngine(users);
    }

    @Test
    void testMatchUsers_Success() {
        List<User> matchedUsers = matchingEngine.match(alex, new SpecificationBuilder());
        assertEquals(2, matchedUsers.size());
        assertEquals("Bob", matchedUsers.get(1).getUserProfile().getName());
        assertEquals("Alice", matchedUsers.get(0).getUserProfile().getName());
    }

    @Test
    void testMatchUsers_Fail() {
        List<User> matchedUsers = matchingEngine.match(bob, new SpecificationBuilder());
        assertEquals(0, matchedUsers.size());
    }
}