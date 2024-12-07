package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserProfileTest {

    private UserProfile userProfile;
    private PreferenceProfileBuilder preferenceProfileBuilder;

    @BeforeEach
    public void setUp() {
        userProfile = new UserProfile("John Doe", 25, GenderIdentity.MALE, SexualOrientation.HETEROSEXUAL, "Bio",
                Arrays.asList("Reading", "Traveling"));
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", userProfile.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(25, userProfile.getAge());
    }

    @Test
    public void testGetGenderIdentity() {
        assertEquals(GenderIdentity.MALE, userProfile.getGenderIdentity());
    }

    @Test
    public void testGetSexualOrientation() {
        assertEquals(SexualOrientation.HETEROSEXUAL, userProfile.getSexualOrientation());
    }

    @Test
    public void testGetBio() {
        assertEquals("Bio", userProfile.getBio());
    }

    @Test
    public void testGetInterests() {
        List<String> interests = userProfile.getInterests();
        assertEquals(2, interests.size());
        assertEquals("Reading", interests.get(0));
        assertEquals("Traveling", interests.get(1));
    }

    @Test
    public void testGetPreferenceProfile_Default() {
        List<GenderIdentity> defaultSexualOrientation = List.of(GenderIdentity.FEMALE);
        preferenceProfileBuilder = new PreferenceProfileBuilder();
        PreferenceProfile preferenceProfile = preferenceProfileBuilder
                .setPreferedGenderIdentity(defaultSexualOrientation).setPreferedInterests(userProfile.getInterests())
                .build();
        PreferenceProfile userProfilePreferenceProfile = userProfile.getPreferenceProfile();
        assertNotNull(userProfilePreferenceProfile);
        assertEquals(preferenceProfile.getPreferedGenderIdentity(),
                userProfilePreferenceProfile.getPreferedGenderIdentity());
        assertEquals(preferenceProfile.getPreferedInterests(), userProfilePreferenceProfile.getPreferedInterests());
        assertEquals(preferenceProfile.getPreferedAgeRange().getMinAge(),
                userProfilePreferenceProfile.getPreferedAgeRange().getMinAge());
    }

    @Test
    public void testSetPreferenceProfile() {
    }

    @Test
    public void testSetCustomGenderIdentity() {
        userProfile = new UserProfile("John Doe", 25, GenderIdentity.CUSTOM, SexualOrientation.HETEROSEXUAL, "Bio",
                Arrays.asList("Reading", "Traveling"));
        userProfile.setCustomGenderIdentityDisplayName("testCustomIdentity");
        assertEquals("testCustomIdentity", userProfile.getGenderIdentity().getDisplayName());
    }
}
